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
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;

public class RangeDiscountRatingSpecTest {

	private RatingSpec testee;
	private RatingContext context;

	@Before
	public void setUp() throws Exception {
		context = new RatingContext();
		testee = new RangeDiscountRatingSpec(new BuildingBasicRatingOfResidentialSpec(context), context);
	}

	/**
	 * 建物物件における臨時費用付帯ありの場合の保険料率算出処理のユニットテスト<br/>
	 * <pre>
	 * 前提条件
	 * <li>物件種別：住宅物件</li>
	 * <li>所在地：札幌</li>
	 * <li>構造級別：H構造</li>
	 * <li>範囲割引：価額協定特約付帯割引(15%)</li>
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料率：1.45(建物基本料率) × (1.00 - 0.15(範囲割引率)) (丸めなし)の計算結果と同値となること</li>
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApply() throws Exception {

		context.setBuildingType(BuildingType.ResidentialProperty);
		context.setLocation(Location.Sapporo);
		context.setClassOfResidentialProperty(ClassOfResidentialProperty.ClassH);
		context.setRangeDiscountType(RangeDiscountType.PriceAgreementAuthorizedIncidentalDiscount);

		BigDecimal actual = testee.apply();

		assertThat(actual, is(expected()));

	}

	private static BigDecimal expected() {

		BigDecimal baseRate = new BigDecimal(1.45);
		BigDecimal rageDiscountRate = new BigDecimal(1.00).subtract(new BigDecimal(0.15));

		return baseRate.multiply(rageDiscountRate);
	}


}
