package jp.co.is.gw.rating.engine.fire.impl;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

public class AbstractRatingSpecTest extends EasyMockSupport {

	private static final BigDecimal EXPECTED_VALUE = new BigDecimal(100d);

	private RatingSpec mockedRatingSpec;

	private RatingContext context;
	private AbstractRatingSpec testee;

	@Before
	public void setUp() throws Exception {

		resetAll();
		mockedRatingSpec = createMock(RatingSpec.class);
		context = new RatingContext();
		testee = createMockBuilder(AbstractRatingSpec.class).withConstructor(mockedRatingSpec, context).createMock();
	}

	@Test
	public void testGetDependRate() {

		expect(mockedRatingSpec.apply()).andReturn(EXPECTED_VALUE);

		replayAll();
		BigDecimal actual = testee.getDependRate();
		verifyAll();

		assertThat(actual, is(EXPECTED_VALUE));

	}

	@Test
	public void testContext() {

		RatingContext actual = testee.context();
		assertThat(actual, is(context));

	}

}
