package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.PreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 保険料算出時の前提条件
 *
 * @author t-kubo
 *
 */
public final class PreConditons {

    private PreConditons() {
	// NOP
    }

    /**
     * 建物を担保とした保険料算出における前提条件を取得する。
     *
     * @param context コンテキスト
     * @return 前提条件
     */
    public static PreCondition ratingOfResidentialProperty(RatingContext context) {
	return new RatingOfResidentialPropertyPreCondition(context);
    }

    /**
     * 払込方法が「一時払」の場合の保険料算出における前提条件を取得する。
     *
     * @param context コンテキスト
     * @return 前提条件
     */
    public static PreCondition lumpSumPreCondition(RatingContext context) {
	return new LumpSumPreCondition(context);
    }

    /**
     * 払込方法が「年払」の場合の保険料算出における前提条件を取得する。
     *
     * @param context コンテキスト
     * @return 前提条件
     */
    public static PreCondition longTermYearlyPaymentPreCondition(RatingContext context) {
	return new LongTermYearlyPaymentPreCondition(context);
    }

    /**
     * 払込方法が「分割払」の場合の保険料算出における前提条件を取得する。
     *
     * @param context コンテキスト
     * @return 前提条件
     */
    public static PreCondition installmentPaymentPreCondition(RatingContext context) {
	return new InstallmentPaymentPreCondition(context);
    }

    /**
     * 払込方法が「長期一括払い」の場合の保険料算出における前提条件を取得する。
     *
     * @param context コンテキスト
     * @return 前提条件
     */
    public static PreCondition longTermLumpSumPreCondition(RatingContext context) {
	return new LongTermLumpSumPreCondition(context);
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
	if (!expression) {
	    throw new IllegalArgumentException(String.valueOf(errorMessage));
	}
    }
}
