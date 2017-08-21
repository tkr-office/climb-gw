package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 臨時費用
 *
 *
 * @author t-kubo
 *
 */
public class TemporaryCost implements RatingSpec {

	private RatingSpec dependRating;

	public TemporaryCost(RatingSpec depend) {
		this.dependRating = depend;
	}

	/**
	 * 臨時費用を適用する
	 *
	 *
	 * @return 臨時費用適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = dependRating.apply();

		return null;
	}

}
