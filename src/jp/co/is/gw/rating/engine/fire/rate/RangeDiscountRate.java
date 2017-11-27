package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;

/**
 * 範囲割引率
 *
 *
 * @author t-kubo
 *
 */
public class RangeDiscountRate implements GetRate {

	private static Map<RangeDiscountType, BigDecimal> RATE_TABLE = new HashMap<>();

	static {
		RATE_TABLE.put(RangeDiscountType.ElectronicSecurityDiscount, new BigDecimal(0.10));
		RATE_TABLE.put(RangeDiscountType.TwoByFour, new BigDecimal(0.10));
		RATE_TABLE.put(RangeDiscountType.ResidentialPropertiesOpenSpaceDiscount, new BigDecimal(0.10));
		RATE_TABLE.put(RangeDiscountType.AStructureHousingTenantsTheOwnerDiscount, new BigDecimal(0.10));
		RATE_TABLE.put(RangeDiscountType.PriceAgreementAuthorizedIncidentalDiscount, new BigDecimal(0.15));
	}

	@Override
	public BigDecimal getRate(RatingContext context) {
		return RATE_TABLE.get(context.getRangeDiscountType());
	}

}
