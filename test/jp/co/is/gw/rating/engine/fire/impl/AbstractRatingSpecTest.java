package jp.co.is.gw.rating.engine.fire.impl;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

public class AbstractRatingSpecTest extends EasyMockSupport {

	private static final BigDecimal EXPECTED_VALUE = new BigDecimal(100d);

	@Mock
	private RatingSpec mockerdRatingSpec;

	private RatingContext context;
	private AbstractRatingSpec testee;

	@Before
	public void setUp() throws Exception {

		context = new RatingContext();
		testee = partialMockBuilder(AbstractRatingSpec.class).withConstructor(mockerdRatingSpec, context).createMock();
	}

	@Test
	public void testGetDependRate() {

		mockerdRatingSpec.apply();
		expectLastCall().andReturn(EXPECTED_VALUE);

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual, is(EXPECTED_VALUE));

	}

	@Test
	public void testContext() {

		RatingContext actual = testee.context();
		assertThat(actual, is(context));

	}

}
