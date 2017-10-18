package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 水災仕様
 *
 *
 * @author t-kubo
 *
 */
public class WaterDisaster extends AbstractRatingSpec {

	public WaterDisaster(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 水災の保険料率を適用する
	 *
	 *
	 * @return 水災適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
