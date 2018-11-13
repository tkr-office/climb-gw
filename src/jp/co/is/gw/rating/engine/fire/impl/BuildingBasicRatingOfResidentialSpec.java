package jp.co.is.gw.rating.engine.fire.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static jp.co.is.gw.rating.engine.fire.precondition.PreConditons.*;
import static jp.co.is.gw.rating.engine.fire.rate.RateRepository.*;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 住宅物件基本料率仕様
 *
 * @author t-kubo
 *
 */
public class BuildingBasicRatingOfResidentialSpec extends AbstractRatingSpec {

	public BuildingBasicRatingOfResidentialSpec(RatingContext context) {
		super(context);
	}

	/**
	 * 住宅物件基本料率を適用する
	 *
	 *
	 * @return 住宅物件基本料率
	 */
	@Override
	public BigDecimal apply() {

		checkArgument(ratingOfResidentialProperty(context()).isMatch(), "物件種別、構造級別、所在地は省略できません。");

		return BASE_RATE_OF_RESIDENTIAL_PROPERTY.getRate(context());
	}

}
