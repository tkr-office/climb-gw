package jp.co.is.gw.rating.engine.test.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.fire.impl.AbstractRatingSpec;

public class Assertions {

	public static void assertDepndOn(RatingSpec actual, Class<? extends RatingSpec> expect) {

		RatingSpec depends = actual;
		while ((depends = ((AbstractRatingSpec) depends).getDependRating()) != null) {
			try {

				assertThat(depends, instanceOf(expect));
				return;
			} catch (AssertionError e) {
				continue;
			}
		}

		throw new AssertionError("Actual has not depend Class of expect");
	}

}
