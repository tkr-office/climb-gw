package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Location;

/**
 * 建物を担保とした保健料算出ににおける前提条件
 *
 * @author t-kubo
 *
 */
public class RatingOfResidentialPropertyPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public RatingOfResidentialPropertyPreCondition(RatingContext context) {
		this.context = context;
	}

	/**
	 * 建物物件種別指定あり、かつ構造級別指定あり、かつ所在地指定あり
	 *
	 * @see jp.co.is.gw.rating.engine.common.PreCondition#isMatch()
	 */
	@Override
	public boolean isMatch() {

		return context.getBuildingType() == BuildingType.ResidentialProperty &&
				context.getClassOfResidentialProperty() != ClassOfResidentialProperty.NotSpecified  &&
				context.getLocation() != Location.NotSpecified;
	}

}
