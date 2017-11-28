package jp.co.is.gw.rating.engine.fire.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.RatingSpec;
import jp.co.is.gw.rating.engine.common.constants.IntegratedPayment;

public class IntegratedPaymentRatingSpecTest extends EasyMockSupport {

    private IntegratedPaymentRatingSpec testee;
	private RatingSpec mockDepenedSpec;
	private RatingContext context;

	@Before
	public void setUp() throws Exception {
		mockDepenedSpec = createMock(RatingSpec.class);
		context = new RatingContext();
		testee = new IntegratedPaymentRatingSpec(mockDepenedSpec, context);
	}

	/**
	 * 保険期間1年、一時払の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>保険期間：1年</li>l
	 * <li>払込方法：一時払</li>l
	 * <li>暫定保健料：\1234</li>l
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料が\1230であること</li>l
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApplyCaseLumpSumOnOneYear() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.LumpSum);
		context.setPolicyPeriodYears(1);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(1234));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("1230"));
	}

}
