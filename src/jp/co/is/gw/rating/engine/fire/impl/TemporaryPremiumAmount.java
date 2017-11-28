package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 暫定保険料(払込方法未適用)算出仕様
 *
 * @author t-kubo
 *
 */
public class TemporaryPremiumAmount extends AbstractRatingSpec {

	public TemporaryPremiumAmount(RatingSpec dependRating, RatingContext context) {
		super(dependRating, context);
	}

	/**
	 * 暫定保険料を算出する。<br/>
	 * （保険金額 × 最終適用料率） ÷ １０００
	 * @throws Exception
	 */
	@Override
	public BigDecimal apply() throws Exception {

		return context().getBuildingInsurance().multiply(getDependRate()).divide(new BigDecimal(1000));
	}

}
