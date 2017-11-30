package jp.co.is.gw.rating.engine.fire.precondition;

import jp.co.is.gw.rating.engine.common.AbstractPreCondition;
import jp.co.is.gw.rating.engine.common.RatingContext;

/**
 * 長期一括払いにおける前提条件
 *
 * @author t-kubo
 *
 */
public class LongTermLumpSumPreCondition extends AbstractPreCondition {

	private RatingContext context;

	public LongTermLumpSumPreCondition(RatingContext context) {
		this.context = context;
	}

	/**
	 * 契約期間が1年以上、36年以下
	 *
	 * @see jp.co.is.gw.rating.engine.common.PreCondition#isMatch()
	 */
	@Override
	public boolean isMatch() {

	    return (context.getPolicyPeriodYears() > 0 && context.getPolicyPeriodYears() < 37) && context.getPolicyPeriodMonths() == 0;
	}

}
