package jp.co.climbnet.gw.rating.engine.impl;

import java.math.BigDecimal;

import jp.co.climbnet.gw.rating.engine.RatingSpec;

/**
 * 建物最終適用料率
 *
 *
 * @author t-kubo
 *
 */
public class FinalBuildingRating implements RatingSpec {

	private RatingSpec dependRating;

	public FinalBuildingRating(RatingSpec depend) {
		this.dependRating = depend;
	}

	/**
	 * 建物最終適用料率を算出する
	 *
	 *
	 * @return 建物最終適用料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = dependRating.apply();

		return null;
	}

}
