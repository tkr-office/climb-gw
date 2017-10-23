package jp.co.is.gw.rating.engine.fire.impl;

import java.math.BigDecimal;

import com.google.common.annotations.VisibleForTesting;

import jp.co.is.gw.rating.engine.RatingContext;
import jp.co.is.gw.rating.engine.RatingSpec;

/**
 *
 * 保険料率計算仕様の抽象クラス
 *
 * @author t-kubo
 *
 */
public abstract class AbstractRatingSpec implements RatingSpec {

	private RatingSpec dependRating;
	private RatingContext context;

	public AbstractRatingSpec(RatingSpec dependRating, RatingContext context) {
		this.dependRating = dependRating;
		this.context = context;
	}

	/**
	 * この保険料率の適用元となる保険料率を取得する
	 *
	 * @return 適用元となる保険料率
	 */
	protected BigDecimal getDependRate() {

		if (dependRating == null) {
			throw new AssertionError("Depend RatingSpec is not specified/");
		}

		return dependRating.apply();
	}

	/**
	 * Ratingコンテキストを取得する
	 *
	 * @return コンテキスト
	 */
	protected RatingContext context() {
		return context;
	}

	@VisibleForTesting
	public RatingSpec getDependRating() {
		return dependRating;
	}

}