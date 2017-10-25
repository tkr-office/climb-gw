package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.PreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

public final class PreConditonsOfFireInsuranceRating {

	private PreConditonsOfFireInsuranceRating() {
		// NOP
	}

	public static PreCondition  ratingOfResidentialProperty(RatingContext context) {
		return new RatingOfResidentialPropertyPreCondition(context);
	}


}
