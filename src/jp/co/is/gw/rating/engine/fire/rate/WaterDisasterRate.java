package jp.co.is.gw.rating.engine.fire.rate;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.GetRate;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 水災保険料率
 *
 *
 * @author t-kubo
 *
 */
public class WaterDisasterRate implements GetRate {

	@Override
	public BigDecimal getRate(RatingContext contest) {
		return new BigDecimal(1.20);
	}

}
