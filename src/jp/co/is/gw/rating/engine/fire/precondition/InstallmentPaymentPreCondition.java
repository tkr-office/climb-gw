package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 分割払における前提条件
 *
 * @author t-kubo
 *
 */
public class InstallmentPaymentPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public InstallmentPaymentPreCondition(RatingContext context) {
		this.context = context;
	}

	/**
	 * 契約期間が1年
	 *
	 * @see jp.co.is.gw.rating.engine.common.PreCondition#isMatch()
	 */
	@Override
	public boolean isMatch() {

	    return context.getPolicyPeriodYears() == 1 && context.getPolicyPeriodMonths() == 0;
	}

}
