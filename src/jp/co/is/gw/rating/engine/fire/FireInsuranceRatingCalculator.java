package jp.co.is.gw.rating.engine.fire;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

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
	 */
	public BigDecimal calculate() {

		RatingSpec spaec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);
		BigDecimal rate = spaec.apply();

		return null;
	}

}
