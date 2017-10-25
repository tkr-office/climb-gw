package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 建物最終適用料率
 *
 *
 * @author t-kubo
 *
 */
public class FinalBuildingRatingSpec extends AbstractRatingSpec {

	public FinalBuildingRatingSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 建物最終適用料率を算出する
	 *
	 *
	 * @return 建物最終適用料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
