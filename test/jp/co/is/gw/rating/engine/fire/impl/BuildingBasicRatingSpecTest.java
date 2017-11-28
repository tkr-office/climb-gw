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
import jp.co.is.gw.rating.engine.common.constants.Location;

public class BuildingBasicRatingSpecTest {

	private RatingSpec testee;
	private RatingContext context;

	@Before
	public void setUp() throws Exception {
		context = new RatingContext();
		testee = new BuildingBasicRatingSpec(context);
	}

	/**
	 * 建物物件に建物基本料率算出処理のユニットテスト<br/>
	 * <pre>
	 * 前提条件
	 * <li>物件種別：住宅物件</li>
	 * <li>所在地：札幌</li>
	 * <li>構造級別：H構造</li>
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料率：1.45(建物基本料率)となること</li>
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApply() throws Exception {

		context.setBuildingType(BuildingType.ResidentialProperty);
		context.setLocation(Location.Sapporo);
		context.setClassOfResidentialProperty(ClassOfResidentialProperty.ClassH);

		BigDecimal actual = testee.apply();

		assertThat(actual, is(new BigDecimal(1.45)));
	}

}
