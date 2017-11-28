package jp.co.is.gw.rating.engine.fire;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 火災保険料計算
 *
 * @author t-kubo
 *
 */
public class FireInsuranceRatingCalculator {

	private RatingContext context;

	public FireInsuranceRatingCalculator(RatingContext context) {
		this.context = context;
	}

	/**
	 * 火災保険料を算出する
	 *
	 * @return 火災保険料
	 * @throws Exception
	 */
	public BigDecimal calculate() throws Exception {

		return FireInsuranceSpecFactory.createRatingSpecOfBuilding(context).apply();
	}

}
