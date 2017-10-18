package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 * 建物基本料率仕様
 *
 * @author t-kubo
 *
 */
public class BuildingBasicRatingSpec extends AbstractRatingSpec {

	public BuildingBasicRatingSpec(RatingSpec dependRating, RatingContext context) {
		super(dependRating, context);
	}

	/**
	 * 建物基本料率を適用する
	 *
	 *
	 * @return 建物基本料率
	 */
	@Override
	public BigDecimal apply() {

		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
