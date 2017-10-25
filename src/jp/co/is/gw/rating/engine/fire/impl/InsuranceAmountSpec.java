package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 保険金額
 *
 *
 * @author t-kubo
 *
 */
public class InsuranceAmountSpec extends AbstractRatingSpec {

	public InsuranceAmountSpec(RatingSpec depend, RatingContext context) {
		super(depend, context);
	}

	/**
	 * 保険金額を適用する
	 *
	 *
	 * @return 保険金額適用後の保険料
	 */
	@Override
	public BigDecimal apply() {

		BigDecimal rating = getDependRate();

		return null;
	}

}
