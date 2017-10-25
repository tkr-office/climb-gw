package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Location;

public class RatingOfResidentialPropertyPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public RatingOfResidentialPropertyPreCondition(RatingContext context) {
		this.context = context;
	}

	@Override
	public boolean isMatch() {

		return context.getBuildingType() == BuildingType.ResidentialProperty &&
				context.getClassOfResidentialProperty() != ClassOfResidentialProperty.NotSpecified  &&
				context.getLocation() != Location.NotSpecified;
	}

}
