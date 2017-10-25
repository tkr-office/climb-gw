package jp.co.is.gw.rating.engine.common;

/**
 * 前提条件インタフェース
 *
 * @author t-kubo
 *
 */
public interface PreCondition {

	boolean isMatch();

	boolean isNotMatch();
}
