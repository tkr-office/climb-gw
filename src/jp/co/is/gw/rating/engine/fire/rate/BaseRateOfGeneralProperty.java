package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.ClassOfGeneralProperty;
import jp.co.is.gw.rating.engine.common.constants.Location;

/**
 * 一般物件保険料率(基本料率)
 *
 *
 * @author t-kubo
 *
 */
public class BaseRateOfGeneralProperty implements GetRate {

	private static Table<Location, ClassOfGeneralProperty, BigDecimal> RATE_TABLE = HashBasedTable.create();

	static {
		RATE_TABLE.put(Location.Sapporo, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.29));
		RATE_TABLE.put(Location.Sapporo, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.45));
		RATE_TABLE.put(Location.Sapporo, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.65));
		RATE_TABLE.put(Location.Sapporo, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.75));
		RATE_TABLE.put(Location.Sapporo, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.45));

		RATE_TABLE.put(Location.Aomori, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.30));
		RATE_TABLE.put(Location.Aomori, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.42));
		RATE_TABLE.put(Location.Aomori, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.59));
		RATE_TABLE.put(Location.Aomori, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.68));
		RATE_TABLE.put(Location.Aomori, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.30));

		RATE_TABLE.put(Location.Sendai, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.30));
		RATE_TABLE.put(Location.Sendai, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.42));
		RATE_TABLE.put(Location.Sendai, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.59));
		RATE_TABLE.put(Location.Sendai, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.68));
		RATE_TABLE.put(Location.Sendai, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.30));

		RATE_TABLE.put(Location.Utsunomiya, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.40));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.52));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.69));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.78));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.40));

		RATE_TABLE.put(Location.Maebashi, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.45));
		RATE_TABLE.put(Location.Maebashi, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.50));
		RATE_TABLE.put(Location.Maebashi, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.64));
		RATE_TABLE.put(Location.Maebashi, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.76));
		RATE_TABLE.put(Location.Maebashi, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.60));

		RATE_TABLE.put(Location.Saitama, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.53));
		RATE_TABLE.put(Location.Saitama, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.62));
		RATE_TABLE.put(Location.Saitama, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.79));
		RATE_TABLE.put(Location.Saitama, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(0.95));
		RATE_TABLE.put(Location.Saitama, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.78));

		RATE_TABLE.put(Location.Kawaguchi, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.78));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.98));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(1.27));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(1.35));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.75));

		RATE_TABLE.put(Location.Hachioji, ClassOfGeneralProperty.HighGrade, BigDecimal.valueOf(0.60));
		RATE_TABLE.put(Location.Hachioji, ClassOfGeneralProperty.FirstGrade, BigDecimal.valueOf(0.82));
		RATE_TABLE.put(Location.Hachioji, ClassOfGeneralProperty.SecondGrade, BigDecimal.valueOf(0.97));
		RATE_TABLE.put(Location.Hachioji, ClassOfGeneralProperty.ThirdGrade, BigDecimal.valueOf(1.34));
		RATE_TABLE.put(Location.Hachioji, ClassOfGeneralProperty.ForthGrade, BigDecimal.valueOf(1.78));

	}

	@Override
	public BigDecimal getRate(RatingContext context) {

		return RATE_TABLE.get(context.getLocation(), context.getClassOfGeneralProperty());
	}

}
