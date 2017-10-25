package jp.co.is.gw.rating.engine.fire;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;
import jp.co.is.gw.rating.engine.constants.Incidental;
import jp.co.is.gw.rating.engine.constants.RangeDiscountType;
import jp.co.is.gw.rating.engine.fire.impl.AbstractRatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.BuildingBasicRatingSpec;
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

		RatingSpec ratingSpec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(new RatingContext());
		RatingSpec depended = ((AbstractRatingSpec) ratingSpec).getDependRating();

		assertThat(depended instanceof BuildingBasicRatingSpec, is(true));

	}

	/**
	 * 風・雹災付帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseWindHailstoneDisaster() {

		RatingContext context = new RatingContext();
		context.setWindHailstoneDisaster(Incidental.YES);

		RatingSpec ratingSpec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);
		RatingSpec depended = ((AbstractRatingSpec) ratingSpec).getDependRating();

		assertThat(depended instanceof WindHailstoneDisasterRatingSpec, is(true));

	}

	/**
	 * 水災付帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseWaterDisaster() {

		RatingContext context = new RatingContext();
		context.setWaterDisaster(Incidental.YES);

		RatingSpec ratingSpec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);
		RatingSpec depended = ((AbstractRatingSpec) ratingSpec).getDependRating();

		assertThat(depended instanceof WaterDisasterRatingSpec, is(true));

	}

	/**
	 * 臨時費用帯あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseTemporaryCost() {

		RatingContext context = new RatingContext();
		context.setTemporaryCost(Incidental.YES);

		RatingSpec ratingSpec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);
		RatingSpec depended = ((AbstractRatingSpec) ratingSpec).getDependRating();

		assertThat(depended instanceof TemporaryCostRatingSpec, is(true));

	}

	/**
	 * 範囲割引適用あり
	 */
	@Test
	public void testCreateRatingSpecOfBuildingCaseRangeDiscount() {

		RatingContext context = new RatingContext();
		context.setRangeDiscountType(RangeDiscountType.TwoByFour);

		RatingSpec ratingSpec = FireInsuranceSpecFactory.createRatingSpecOfBuilding(context);
		RatingSpec depended = ((AbstractRatingSpec) ratingSpec).getDependRating();

		assertThat(depended instanceof RangeDiscountRatingSpec, is(true));

	}

}
