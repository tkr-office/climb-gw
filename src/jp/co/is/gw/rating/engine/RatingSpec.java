package jp.co.is.gw.rating.engine;

import java.math.BigDecimal;

/**
 * 適用料率仕様インタフェース
 *
 *
 * @author t-kubo
 *
 */
public interface RatingSpec {


	/**
	 * 保険料率を適用する
	 *
	 * @return 保険料率
	 */
	BigDecimal apply();

}
