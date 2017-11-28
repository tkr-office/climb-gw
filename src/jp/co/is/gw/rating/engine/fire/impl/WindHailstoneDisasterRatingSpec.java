package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.fire.rate.RateRepository;

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
	 * @throws Exception
	 */
	@Override
	public BigDecimal apply() throws Exception {

		return getDependRate().multiply(rate());
	}

	private BigDecimal rate() {
		return RateRepository.WIND_HAILSTONE_DISASTER_RATE.getRate(context());
	}

}
