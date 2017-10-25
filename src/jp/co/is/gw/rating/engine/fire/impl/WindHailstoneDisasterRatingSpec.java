package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 風・雹災仕様
 *
 *
 * @author t-kubo
 *
 */
public class WindHailstoneDisasterRatingSpec extends AbstractRatingSpec {

	public WindHailstoneDisasterRatingSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 風・雹災の保険料率を適用する
	 *
	 *
	 * @return 風・雹災適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
