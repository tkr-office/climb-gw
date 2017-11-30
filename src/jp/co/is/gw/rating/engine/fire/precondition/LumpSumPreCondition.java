package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 一時払における前提条件
 *
 * @author t-kubo
 *
 */
public class LumpSumPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public LumpSumPreCondition(RatingContext context) {
		this.context = context;
	}

	/**
	 * 契約期間が1年または、1年未満
	 *
	 * @see jp.co.is.gw.rating.engine.common.PreCondition#isMatch()
	 */
	@Override
	public boolean isMatch() {

	    if(context.getPolicyPeriodYears() == 1 && context.getPolicyPeriodMonths() == 0) {
		// 契約期間1年
		return true;
	    }

	    if(context.getPolicyPeriodYears() == 0 && context.getPolicyPeriodMonths() > 0) {
		// 契約期間1年未満(0ヶ月を除く)
		return true;
	    }

	    return false;
	}

}
