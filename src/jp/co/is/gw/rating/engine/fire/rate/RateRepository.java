package jp.co.is.gw.rating.engine.fire.rate;

import jp.co.is.gw.rating.engine.common.GetRate;

public final class RateRepository {

	public static final GetRate BASE_RATE_OF_RESIDENTIAL_PROPERTY = new BaseRateOfResidentialProperty();
	public static final GetRate WIND_HAILSTONE_DISASTER_RATE = new WindHailstoneDisasterRate();

}
