package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 保険料率の小数点以下4桁丸め仕様
 *
 *
 * @author t-kubo
 *
 */
public class Precision4DigitsSpec extends AbstractRatingSpec {

	public Precision4DigitsSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 保険料率を小数点以下4桁で丸める。
	 *
	 * @return 丸め後の保険料率
	 */
	@Override
	public BigDecimal apply() {
		return getDependRate().round(new MathContext(4, RoundingMode.DOWN));
	}

}
