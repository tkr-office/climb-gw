package jp.co.is.gw.rating.engine.fire.impl;

import static jp.co.is.gw.rating.engine.fire.rate.RateRepository.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.common.constants.IntegratedPayment;

/**
 * 保険料に払い込み方法による割増引適用仕様
 *
 * @author t-kubo
 *
 */
public class IntegratedPaymentRatingSpec extends AbstractRatingSpec {

    public IntegratedPaymentRatingSpec(RatingSpec dependRating, RatingContext context) {
	super(dependRating, context);
    }

    /**
     * 保険料に払い込み方法による割増引を適用する。
     *
     * @return 払い込み方法による割増引適用後の保険料
     * @throws Exception
     *
     * @see jp.co.is.gw.rating.engine.common.RatingSpec#apply()
     */
    @Override
    public BigDecimal apply() throws Exception {

	BigDecimal temporaryPremiumAmount = getDependRate();

	// 一時払
	if (context().getIntegratedPayment() == IntegratedPayment.LumpSum) {
	    return lumpSum(temporaryPremiumAmount, context());
	}

	// 年払い
	if (context().getIntegratedPayment() == IntegratedPayment.LongTermYearlyPayment) {
	    return longTermYearlyPayment(temporaryPremiumAmount, context());
	}

	// 分割払い
	if (context().getIntegratedPayment() == IntegratedPayment.Installment6
		|| context().getIntegratedPayment() == IntegratedPayment.Installment12) {
	    return installmentPayment(temporaryPremiumAmount, context());
	}

	// 長期一括払い
	if (context().getIntegratedPayment() == IntegratedPayment.LongTermLumpSum) {
	    return longTermLumpSum(temporaryPremiumAmount, context());
	}

	throw new UnsupportedOperationException("この払い込み方法・保険期間は現在サポートされていません。");
    }

    /**
     * 払込方法が「一時払」の場合の割増引適用処理
     *
     * @param premiumAmount 保険料
     * @param context コンテキスト
     * @return 割増引適用後の保険料
     */
    private static BigDecimal lumpSum(BigDecimal premiumAmount, RatingContext context) {

	// 保険期間が1年
	if (context.getPolicyPeriodYears() == 1) {
	    return premiumAmount.setScale(-1, RoundingMode.FLOOR);
	}

	// 保険期間が1年未満
	if (context.getPolicyPeriodMonths() >= 1) {
	    return premiumAmount.//
		    multiply(new BigDecimal(context.getPolicyPeriodMonths())).//
		    divide(new BigDecimal(12)).//
		    setScale(-1, RoundingMode.FLOOR);
	}

	throw new UnsupportedOperationException("払込方法が「一時払」の場合、この保険期間は現在サポートされていません。");
    }

    /**
     * 払込方法が「年払い」の場合の割増引適用処理
     *
     * @param premiumAmount 保険料
     * @param context コンテキスト
     * @return 割増引適用後の保険料
     */
    private static BigDecimal longTermYearlyPayment(BigDecimal premiumAmount, RatingContext context) {

	// 保険期間が1年以上
	if (context.getPolicyPeriodYears() >= 1) {
	    return premiumAmount.setScale(-1, RoundingMode.FLOOR);
	}

	throw new UnsupportedOperationException("払込方法が「年払い」の場合、この保険期間は現在サポートされていません。");
    }

    /**
     * 払込方法が「分割払い」の場合の割増引適用処理
     *
     * @param premiumAmount 保険料
     * @param context コンテキスト
     * @return 割増引適用後の保険料
     */
    private static BigDecimal installmentPayment(BigDecimal premiumAmount, RatingContext context) {

	// 保険期間が1年
	if (context.getPolicyPeriodYears() != 1) {
	    throw new UnsupportedOperationException("払込方法が「分割払い」の場合、この保険期間は現在サポートされていません。");
	}

	return premiumAmount.multiply(INTEGRATED_PAYMENT_FACTOR.getRate(context)).//
		divide(new BigDecimal(context.getIntegratedPayment().getPaymentNum())).//
		setScale(-1, RoundingMode.FLOOR);
    }

    /**
     * 払込方法が「長期一括払い」の場合の割増引適用処理
     *
     * @param premiumAmount 保険料
     * @param context コンテキスト
     * @return 割増引適用後の保険料
     */
    private static BigDecimal longTermLumpSum(BigDecimal premiumAmount, RatingContext context) {

	// 保険期間が1年未満、または36年を超える場合
	if (context.getPolicyPeriodYears() < 1 || context.getPolicyPeriodYears() > 36) {
	    throw new UnsupportedOperationException("払込方法が「分割払い」の場合、この保険期間は現在サポートされていません。");
	}

	return premiumAmount.multiply(LONG_TERM_FACTOR.getRate(context)).//
		setScale(-1, RoundingMode.FLOOR);
    }
}
