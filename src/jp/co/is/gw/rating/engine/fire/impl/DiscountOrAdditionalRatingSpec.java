package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 割増引き
 *
 *
 * @author t-kubo
 *
 */
public class DiscountOrAdditionalRatingSpec extends AbstractRatingSpec {

	public DiscountOrAdditionalRatingSpec(RatingSpec dependRating, RatingContext context) {
		super(dependRating, context);
	}

	/**
	 * 割増引きを適用する
	 *
	 *
	 * @return 割増引き適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
