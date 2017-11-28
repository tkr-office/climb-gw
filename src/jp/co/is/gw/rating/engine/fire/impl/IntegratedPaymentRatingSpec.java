package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

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
	 *
	 * @see jp.co.is.gw.rating.engine.common.RatingSpec#apply()
	 */
	@Override
	public BigDecimal apply() {



		return null;
	}

}
