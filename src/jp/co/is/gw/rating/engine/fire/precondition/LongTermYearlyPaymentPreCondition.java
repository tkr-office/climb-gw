package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 年払における前提条件
 *
 * @author t-kubo
 *
 */
public class LongTermYearlyPaymentPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public LongTermYearlyPaymentPreCondition(RatingContext context) {
		this.context = context;
	}

	/**
	 * 契約期間が1年以上
	 *
	 * @see jp.co.is.gw.rating.engine.common.PreCondition#isMatch()
	 */
	@Override
	public boolean isMatch() {
	    return context.getPolicyPeriodYears() >= 1 && context.getPolicyPeriodMonths() == 0;
	}

}
