package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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
	 */
	@Override
	public BigDecimal apply() {

		return getDependRate().multiply(rate(), new MathContext(4, RoundingMode.DOWN));
	}

	private BigDecimal rate() {
		return RateRepository.WIND_HAILSTONE_DISASTER_RATE.getRate(context());
	}

}
