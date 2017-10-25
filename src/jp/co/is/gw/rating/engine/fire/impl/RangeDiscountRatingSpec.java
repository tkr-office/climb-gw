package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 範囲割引
 *
 *
 * @author t-kubo
 *
 */
public class RangeDiscountRatingSpec extends AbstractRatingSpec {

	public RangeDiscountRatingSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 範囲割引を適用する
	 *
	 *
	 * @return 範囲割引適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
