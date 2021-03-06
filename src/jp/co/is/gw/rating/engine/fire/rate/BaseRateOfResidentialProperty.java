package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Location;

/**
 * 住宅物件保険料率(基本料率)
 *
 *
 * @author t-kubo
 *
 */
public class BaseRateOfResidentialProperty implements GetRate {

	private static Table<Location, ClassOfResidentialProperty, BigDecimal> RATE_TABLE = HashBasedTable.create();

	static {
		RATE_TABLE.put(Location.Sapporo, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.61));
		RATE_TABLE.put(Location.Sapporo, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.45));
		RATE_TABLE.put(Location.Sapporo, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.29));

		RATE_TABLE.put(Location.Aomori, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.81));
		RATE_TABLE.put(Location.Aomori, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(2.03));
		RATE_TABLE.put(Location.Aomori, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.33));

		RATE_TABLE.put(Location.Sendai, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.53));
		RATE_TABLE.put(Location.Sendai, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.13));
		RATE_TABLE.put(Location.Sendai, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.28));

		RATE_TABLE.put(Location.Utsunomiya, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.53));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.35));
		RATE_TABLE.put(Location.Utsunomiya, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.27));

		RATE_TABLE.put(Location.Maebashi, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.53));
		RATE_TABLE.put(Location.Maebashi, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.36));
		RATE_TABLE.put(Location.Maebashi, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.27));

		RATE_TABLE.put(Location.Saitama, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.57));
		RATE_TABLE.put(Location.Saitama, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.20));
		RATE_TABLE.put(Location.Saitama, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.31));

		RATE_TABLE.put(Location.Kawaguchi, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.57));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.20));
		RATE_TABLE.put(Location.Kawaguchi, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.31));

		RATE_TABLE.put(Location.Hachioji, ClassOfResidentialProperty.ClassT, BigDecimal.valueOf(0.56));
		RATE_TABLE.put(Location.Hachioji, ClassOfResidentialProperty.ClassH, BigDecimal.valueOf(1.20));
		RATE_TABLE.put(Location.Hachioji, ClassOfResidentialProperty.ClassM, BigDecimal.valueOf(0.31));
	}

	@Override
	public BigDecimal getRate(RatingContext context) {

		return RATE_TABLE.get(context.getLocation(), context.getClassOfResidentialProperty());
	}

}
