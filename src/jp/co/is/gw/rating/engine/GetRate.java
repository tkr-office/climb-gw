package jp.co.is.gw.rating.engine;

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
     * @return 料率
     */

    BigDecimal getRate();

}
