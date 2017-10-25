package jp.co.is.gw.rating.engine.fire.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.common.constants.Location;

public class WindHailstoneDisasterRatingSpecTest {

	private RatingSpec testee;
	private RatingContext context;

	@Before
	public void setUp() throws Exception {
		context = new RatingContext();
		testee = new WindHailstoneDisasterRatingSpec(new BuildingBasicRatingSpec(context), context);
	}

	@Test
	public void testApply() {

		context.setBuildingType(BuildingType.ResidentialProperty);
		context.setLocation(Location.Sapporo);
		context.setClassOfResidentialProperty(ClassOfResidentialProperty.ClassH);
		context.setWindHailstoneDisaster(Incidental.YES);

		BigDecimal actual = testee.apply();

		BigDecimal expected = new BigDecimal("1.5950");
		expected = expected.round(new MathContext(4, RoundingMode.DOWN));

		assertThat(actual, is(expected));

	}

}
