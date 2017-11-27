package jp.co.is.gw.rating.engine.fire;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;
import jp.co.is.gw.rating.engine.fire.impl.BuildingBasicRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.FinalBuildingRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.Precision4DigitsSpec;
import jp.co.is.gw.rating.engine.fire.impl.RangeDiscountRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.TemporaryCostRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.WaterDisasterRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.WindHailstoneDisasterRatingSpec;

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

		RatingSpec spec = new BuildingBasicRatingSpec(context);

		if (context.getWindHailstoneDisaster() == Incidental.YES) {
			spec = new WindHailstoneDisasterRatingSpec(spec, context);
		}

		if (context.getWaterDisaster() == Incidental.YES) {
			spec = new WaterDisasterRatingSpec(spec, context);
		}

		if (context.getTemporaryCost() == Incidental.YES) {
			spec = new TemporaryCostRatingSpec(spec, context);
		}

		spec = new Precision4DigitsSpec(spec, context);

		if (context.getRangeDiscountType() != RangeDiscountType.None) {
			spec = new RangeDiscountRatingSpec(spec, context);
		}

		spec = new FinalBuildingRatingSpec(spec, context);

		return spec;
	}

}
