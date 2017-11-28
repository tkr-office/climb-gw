package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.PreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 火災保健料算出時の前提条件
 *
 * @author t-kubo
 *
 */
public final class PreConditonsOfFireInsuranceRating {

	private PreConditonsOfFireInsuranceRating() {
		// NOP
	}

	/**
	 * 建物を担保とした保健料算出ににおける前提条件を取得する。
	 *
	 * @param context コンテキスト
	 * @return 前提条件
	 */
	public static PreCondition  ratingOfResidentialProperty(RatingContext context) {
		return new RatingOfResidentialPropertyPreCondition(context);
	}


}
