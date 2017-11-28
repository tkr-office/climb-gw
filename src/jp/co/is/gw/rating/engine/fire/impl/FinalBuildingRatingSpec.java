package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 建物最終適用料率
 *
 *
 * @author t-kubo
 *
 */
public class FinalBuildingRatingSpec extends Precision2DigitsSpec {

	public FinalBuildingRatingSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 建物最終適用料率を算出する
	 *
	 *
	 * @return 建物最終適用料率
	 * @throws Exception
	 */
	@Override
	public BigDecimal apply() throws Exception {

		return super.apply();
	}

}
