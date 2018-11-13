package jp.co.is.gw.rating.engine.fire;

import static jp.co.is.gw.rating.engine.test.util.Assertions.*;

import org.junit.Test;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;
import jp.co.is.gw.rating.engine.fire.impl.BuildingBasicRatingOfResidentialSpec;
import jp.co.is.gw.rating.engine.fire.impl.RangeDiscountRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.TemporaryCostRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.WaterDisasterRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.WindHailstoneDisasterRatingSpec;

public class FireInsuranceSpecFactoryTest {

	/**
	 * 何も付帯なし
	 */
	@Test
	public void testCreateRatingSpecOfBuilding() {

		RatingSpec actual = FireInsuranceSpecFactory.createRatingSpecOfBuilding(new RatingContext());

		assertDepndOn(actual, BuildingBasicRatingOfResidentialSpec.class);

	}

	/**
	 * 風・雹災付帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseWindHailstoneDisaster() {

		RatingContext context = new RatingContext();
		context.setWindHailstoneDisaster(Incidental.YES);

		RatingSpec actual = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);

		assertDepndOn(actual, WindHailstoneDisasterRatingSpec.class);
	}

	/**
	 * 水災付帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseWaterDisaster() {

		RatingContext context = new RatingContext();
		context.setWaterDisaster(Incidental.YES);

		RatingSpec actual = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);

		assertDepndOn(actual, WaterDisasterRatingSpec.class);
	}

	/**
	 * 臨時費用帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseTemporaryCost() {

		RatingContext context = new RatingContext();
		context.setTemporaryCost(Incidental.YES);

		RatingSpec actual = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);

		assertDepndOn(actual, TemporaryCostRatingSpec.class);
	}

	/**
	 * 範囲割引適用あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseRangeDiscount() {

		RatingContext context = new RatingContext();
		context.setRangeDiscountType(RangeDiscountType.TwoByFour);

		RatingSpec actual = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);

		assertDepndOn(actual, RangeDiscountRatingSpec.class);

	}

}
