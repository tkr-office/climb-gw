package jp.co.is.gw.rating.engine.common;

import java.math.BigDecimal;

/**
 * 料率取得インタフェース
 *
 *
 * @author Seth
 *
 */

public interface GetRate {
    /**
     * 料率を取得する
     *
     * @param 保険料率計算コンテキスト
     *
     * @return 料率
     */

    BigDecimal getRate(RatingContext context);

}
