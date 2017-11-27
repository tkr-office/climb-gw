package jp.co.is.gw.rating.engine.fire.impl;

import static com.google.common.base.Preconditions.*;
import static jp.co.is.gw.rating.engine.fire.precondition.PreConditonsOfFireInsuranceRating.*;
import static jp.co.is.gw.rating.engine.fire.rate.RateRepository.*;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 建物基本料率仕様
 *
 * @author t-kubo
 *
 */
public class BuildingBasicRatingSpec extends AbstractRatingSpec {

	public BuildingBasicRatingSpec(RatingContext context) {
		super(context);
	}

	/**
	 * 建物基本料率を適用する
	 *
	 *
	 * @return 建物基本料率
	 */
	@Override
	public BigDecimal apply() {

		checkArgument(ratingOfResidentialProperty(context()).isMatch());

		return BASE_RATE_OF_RESIDENTIAL_PROPERTY.getRate(context());
	}

}
