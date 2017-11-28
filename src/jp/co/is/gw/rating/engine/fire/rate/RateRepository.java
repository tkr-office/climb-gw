package jp.co.is.gw.rating.engine.fire.rate;

import jp.co.is.gw.rating.engine.common.GetRate;

public final class RateRepository {

	public static final GetRate BASE_RATE_OF_RESIDENTIAL_PROPERTY = new BaseRateOfResidentialProperty();
	public static final GetRate WIND_HAILSTONE_DISASTER_RATE = new WindHailstoneDisasterRate();
	public static final GetRate WATER_DISASTER_RATE = new WaterDisasterRate();
	public static final GetRate RANGE_DISCOUNT_RATE = new RangeDiscountRate();
	public static final GetRate TEMPORARY_COST_RATE = new TemporaryCostRate();
	public static final GetRate LONG_TERM_FACTOR = new LongTermFactor();
	public static final GetRate INTEGRATED_PAYMENT_FACTOR = new IntegratedPaymentFactor();

}
