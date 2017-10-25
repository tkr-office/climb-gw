package jp.co.is.gw.rating.engine.common;

public abstract class AbstractPreCondition implements PreCondition {

	@Override
	public boolean isNotMatch() {
		return !isMatch();
	}

}
