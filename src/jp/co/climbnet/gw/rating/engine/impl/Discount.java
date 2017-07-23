package jp.co.climbnet.gw.rating.engine.impl;

import java.math.BigDecimal;

import jp.co.climbnet.gw.rating.engine.RatingSpec;

/**
 * 割増引き
 *
 *
 * @author t-kubo
 *
 */
public class Discount implements RatingSpec {

	private RatingSpec dependRating;

	public Discount(RatingSpec depend) {
		this.dependRating = depend;
	}

	/**
	 * 割増引きを適用する
	 *
	 *
	 * @return 割増引き適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = dependRating.apply();

		return null;
	}

}
