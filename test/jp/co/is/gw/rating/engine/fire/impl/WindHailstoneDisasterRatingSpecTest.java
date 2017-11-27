package jp.co.is.gw.rating.engine.fire.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

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

	/**
	 * 建物物件における風・雹災付帯ありの場合の保険料率算出処理のユニットテスト<br/>
	 * <pre>
	 * 前提条件
	 * <li>物件種別：住宅物件</li>
	 * <li>所在地：札幌</li>
	 * <li>構造級別：H構造</li>
	 * <li>風・雹災：風・雹災：付帯あり</li>
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料率：1.45(建物基本料率) × 1.10(風・雹災保険料率) (丸めなし)の計算結果と同値となること</li>
	 * </pre>
	 */
	@Test
	public void testApply() {

		context.setBuildingType(BuildingType.ResidentialProperty);
		context.setLocation(Location.Sapporo);
		context.setClassOfResidentialProperty(ClassOfResidentialProperty.ClassH);
		context.setWindHailstoneDisaster(Incidental.YES);

		BigDecimal actual = testee.apply();

		assertThat(actual, is(expected()));

	}

	private static BigDecimal expected() {

		BigDecimal expected = new BigDecimal(1.45);

		return expected.multiply(new BigDecimal(1.10));
	}

}
