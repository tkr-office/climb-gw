package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 臨時費用
 *
 *
 * @author t-kubo
 *
 */
public class TemporaryCostRatingSpec extends AbstractRatingSpec {

	public TemporaryCostRatingSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 臨時費用を適用する
	 *
	 *
	 * @return 臨時費用適用後の料率
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
