package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 短期係数
 *
 * @author t-kubo
 *
 */
public class ShortTermFactor implements GetRate {

	private static final BigDecimal BASE = new BigDecimal(12);
	private static Map<Integer, BigDecimal> FACTOR_TABLE = new HashMap<>();

	static {
		FACTOR_TABLE.put(1, new BigDecimal(1).multiply(BASE));
		FACTOR_TABLE.put(2, new BigDecimal(2).multiply(BASE));
		FACTOR_TABLE.put(3, new BigDecimal(3).multiply(BASE));
		FACTOR_TABLE.put(4, new BigDecimal(4).multiply(BASE));
		FACTOR_TABLE.put(5, new BigDecimal(5).multiply(BASE));
		FACTOR_TABLE.put(6, new BigDecimal(6).multiply(BASE));
		FACTOR_TABLE.put(7, new BigDecimal(7).multiply(BASE));
		FACTOR_TABLE.put(8, new BigDecimal(8).multiply(BASE));
		FACTOR_TABLE.put(9, new BigDecimal(9).multiply(BASE));
		FACTOR_TABLE.put(10, new BigDecimal(10).multiply(BASE));
		FACTOR_TABLE.put(11, new BigDecimal(11).multiply(BASE));
		FACTOR_TABLE.put(12, new BigDecimal(12).multiply(BASE));
	}

	@Override
	public BigDecimal getRate(RatingContext context) {
		return FACTOR_TABLE.get(context.getPolicyPeriodMonths());
	}

}
