package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import com.google.common.base.Preconditions;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.fire.precondition.PreConditonsOfFireInsuranceRating;
import jp.co.is.gw.rating.engine.fire.rate.RateRepository;

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

		Preconditions.checkArgument(PreConditonsOfFireInsuranceRating.ratingOfResidentialProperty(context()).isMatch());

		return RateRepository.BASE_RATE_OF_RESIDENTIAL_PROPERTY.getRate(context());
	}

}
