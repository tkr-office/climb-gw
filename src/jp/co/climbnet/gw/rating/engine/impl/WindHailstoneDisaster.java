package jp.co.climbnet.gw.rating.engine.impl;

import java.math.BigDecimal;

import jp.co.climbnet.gw.rating.engine.RatingSpec;

/**
 * 風・雹災仕様
 *
 *
 * @author t-kubo
 *
 */
public class WindHailstoneDisaster implements RatingSpec {

	private RatingSpec dependRating;

	public WindHailstoneDisaster(RatingSpec depend) {
		this.dependRating = depend;
	}

	/**
	 * 風・雹災の保険料率を適用する
	 *
	 *
	 * @return 建物基本料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = dependRating.apply();

		return null;
	}

}
