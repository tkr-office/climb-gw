package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.fire.rate.RateRepository;

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

		return getDependRate().multiply(rate());
	}

	private BigDecimal rate() {
		return RateRepository.TEMPORARY_COST_RATE.getRate(context());
	}

}
