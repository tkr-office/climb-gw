package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;

/**
 * 家財基本料率仕様
 *
 * @author t-kubo
 *
 */
public class HouseholdGoodsBasicRatingSpec extends AbstractRatingSpec {

	public HouseholdGoodsBasicRatingSpec(RatingSpec dependRating, RatingContext context) {
		super(dependRating, context);
	}

	/**
	 * 家財基本料率を適用する
	 *
	 *
	 * @return 家財基本料率
	 */
	@Override
	public BigDecimal apply() {

		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
