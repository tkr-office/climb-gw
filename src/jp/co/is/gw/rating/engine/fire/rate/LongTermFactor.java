package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 長期係数
 *
 * @author t-kubo
 *
 */
public class LongTermFactor implements GetRate {

	private static Map<Integer, BigDecimal> FACTOR_TABLE = new HashMap<>();

	static {
		FACTOR_TABLE.put(1, new BigDecimal(1.00));
		FACTOR_TABLE.put(2, new BigDecimal(1.85));
		FACTOR_TABLE.put(3, new BigDecimal(2.70));
		FACTOR_TABLE.put(4, new BigDecimal(3.55));
		FACTOR_TABLE.put(5, new BigDecimal(4.40));
		FACTOR_TABLE.put(6, new BigDecimal(5.20));
		FACTOR_TABLE.put(7, new BigDecimal(6.05));
		FACTOR_TABLE.put(8, new BigDecimal(6.85));
		FACTOR_TABLE.put(9, new BigDecimal(7.65));
		FACTOR_TABLE.put(10, new BigDecimal(8.50));
		FACTOR_TABLE.put(11, new BigDecimal(8.95));
		FACTOR_TABLE.put(12, new BigDecimal(9.70));
		FACTOR_TABLE.put(13, new BigDecimal(10.40));
		FACTOR_TABLE.put(14, new BigDecimal(11.15));
		FACTOR_TABLE.put(15, new BigDecimal(11.85));
		FACTOR_TABLE.put(16, new BigDecimal(12.55));
		FACTOR_TABLE.put(17, new BigDecimal(13.25));
		FACTOR_TABLE.put(18, new BigDecimal(13.90));
		FACTOR_TABLE.put(19, new BigDecimal(14.60));
		FACTOR_TABLE.put(20, new BigDecimal(15.250));
		FACTOR_TABLE.put(21, new BigDecimal(15.90));
		FACTOR_TABLE.put(22, new BigDecimal(16.55));
		FACTOR_TABLE.put(23, new BigDecimal(17.20));
		FACTOR_TABLE.put(24, new BigDecimal(17.80));
		FACTOR_TABLE.put(25, new BigDecimal(18.45));
		FACTOR_TABLE.put(26, new BigDecimal(19.05));
		FACTOR_TABLE.put(27, new BigDecimal(19.65));
		FACTOR_TABLE.put(28, new BigDecimal(20.25));
		FACTOR_TABLE.put(29, new BigDecimal(20.85));
		FACTOR_TABLE.put(30, new BigDecimal(21.45));
		FACTOR_TABLE.put(31, new BigDecimal(22.00));
		FACTOR_TABLE.put(32, new BigDecimal(22.60));
		FACTOR_TABLE.put(33, new BigDecimal(23.15));
		FACTOR_TABLE.put(34, new BigDecimal(23.70));
		FACTOR_TABLE.put(35, new BigDecimal(24.25));
		FACTOR_TABLE.put(36, new BigDecimal(24.80));
	}

	@Override
	public BigDecimal getRate(RatingContext context) {
		return FACTOR_TABLE.get(context.getPolicyPeriodYears());
	}

}
