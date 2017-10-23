package jp.co.is.gw.rating.engine.fire;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;
import jp.co.is.gw.rating.engine.constants.Incidental;
import jp.co.is.gw.rating.engine.constants.RangeDiscountType;
import jp.co.is.gw.rating.engine.fire.impl.BuildingBasicRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.FinalBuildingRating;
import jp.co.is.gw.rating.engine.fire.impl.TemporaryCost;
import jp.co.is.gw.rating.engine.fire.impl.WaterDisaster;
import jp.co.is.gw.rating.engine.fire.impl.WindHailstoneDisaster;

/**
 * 火災保険料算出仕様ファクトリ
 *
 * @author t-kubo
 *
 */
public class FireInsuranceSpecFactory {

	/**
	 * 建物保険料算出仕様を構築する
	 *
	 * @param context
	 *            保険料計算コンテキスト
	 * @return 保険料算出仕様
	 */
	public static RatingSpec createRatingSpecOfBuilding(RatingContext context) {

		RatingSpec spec = new BuildingBasicRatingSpec(null, context);

		if (context.getWindHailstoneDisaster() == Incidental.YES) {
			spec = new WindHailstoneDisaster(spec, context);
		}

		if (context.getWaterDisaster() == Incidental.YES) {
			spec = new WaterDisaster(spec, context);
		}

		if (context.getTemporaryCost() == Incidental.YES) {
			spec = new TemporaryCost(spec, context);
		}

		if (context.getRangeDiscountType() != RangeDiscountType.None) {
			spec = new TemporaryCost(spec, context);
		}

		spec = new FinalBuildingRating(spec, context);

		return spec;
	}

}
