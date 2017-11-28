package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.IntegratedPayment;

/**
 * 分割割増率
 *
 *
 * @author t-kubo
 *
 */
public class IntegratedPaymentFactor implements GetRate {

	private static Map<IntegratedPayment, BigDecimal> FACTOR_TABLE = new HashMap<>();

	static {
		FACTOR_TABLE.put(IntegratedPayment.LumpSum, new BigDecimal(1.00));
		FACTOR_TABLE.put(IntegratedPayment.LongTermLumpSum, new BigDecimal(1.00));
		FACTOR_TABLE.put(IntegratedPayment.LongTermYearlyPayment, new BigDecimal(1.00));
		FACTOR_TABLE.put(IntegratedPayment.Installment6, new BigDecimal(1.03));
		FACTOR_TABLE.put(IntegratedPayment.Installment12, new BigDecimal(1.05));
	}

	@Override
	public BigDecimal getRate(RatingContext context) {
		return FACTOR_TABLE.get(context.getIntegratedPayment());
	}

}
