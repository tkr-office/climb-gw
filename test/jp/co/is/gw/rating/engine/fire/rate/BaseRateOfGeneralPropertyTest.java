package jp.co.is.gw.rating.engine.fire.rate;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.ClassOfGeneralProperty;
import jp.co.is.gw.rating.engine.common.constants.Location;

public class BaseRateOfGeneralPropertyTest {

	private BaseRateOfGeneralProperty testee;

	@Before
	public void setUp() throws Exception {
		testee = new BaseRateOfGeneralProperty();
	}

	@Test
	public void testGetRateCaseSapporo() {

		RatingContext context = new RatingContext();
		context.setLocation(Location.Sapporo);
		context.setClassOfGeneralProperty(ClassOfGeneralProperty.HighGrade);
		BigDecimal actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.29)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.FirstGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.45)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.SecondGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.65)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.ThirdGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.75)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.ForthGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(1.45)));

	}

	@Test
	public void testGetRateCaseAomori() {

		RatingContext context = new RatingContext();
		context.setLocation(Location.Aomori);
		context.setClassOfGeneralProperty(ClassOfGeneralProperty.HighGrade);
		BigDecimal actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.30)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.FirstGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.42)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.SecondGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.59)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.ThirdGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(0.68)));

		context.setClassOfGeneralProperty(ClassOfGeneralProperty.ForthGrade);
		actual = testee.getRate(context);

		assertThat(actual, CoreMatchers.is(BigDecimal.valueOf(1.30)));

	}
}
