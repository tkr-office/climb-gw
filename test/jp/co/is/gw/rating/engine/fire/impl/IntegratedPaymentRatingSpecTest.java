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
	 * 一時払、保険期間1年の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：一時払</li>l
	 * <li>保険期間：1年</li>l
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

	/**
	 * 一時払、保険期間1年未満の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：一時払</li>l
	 * <li>保険期間：3ヶ月</li>l
	 * <li>暫定保健料：\1234</li>l
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料が\300であること</li>l
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApplyCaseLumpSumOnLessThanOneYear() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.LumpSum);
		context.setPolicyPeriodMonths(3);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(1234));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("300"));
	}

	/**
	 * 年払、保険期間1年上の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：年払</li>l
	 * <li>保険期間：10年</li>l
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
	public void testApplyCaseLongTermYearlyPayment() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.LongTermYearlyPayment);
		context.setPolicyPeriodYears(10);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(1234));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("1230"));
	}

	/**
	 * 分割6回払い、保険期間1年の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：分割6回払い</li>l
	 * <li>保険期間：1年</li>l
	 * <li>暫定保健料：\3234</li>l
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料が\550であること</li>l
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApplyCaseInstallment6Payment() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.Installment6);
		context.setPolicyPeriodYears(1);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(3234));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("550"));
	}

	/**
	 * 分割12回払い、保険期間1年の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：分割12回払い</li>l
	 * <li>保険期間：1年</li>l
	 * <li>暫定保健料：\3234</li>l
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料が\280であること</li>l
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApplyCaseInstallment12Payment() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.Installment12);
		context.setPolicyPeriodYears(1);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(3234));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("280"));
	}

	/**
	 * 長期一括払い、保険期間20年の場合の分割割増引適用保健料算出のユニットテスト
	 *
	 * <pre>
	 * 前提条件
	 * <li>払込方法：長期一括払い</li>l
	 * <li>保険期間：20年</li>l
	 * <li>暫定保健料：\5324</li>l
	 * </pre>
	 *
	 * <pre>
	 * 確認項目
	 * <li>保険料が\81190であること</li>l
	 * </pre>
	 * @throws Exception
	 */
	@Test
	public void testApplyCaselongTermLumpSumPayment() throws Exception {

		context.setIntegratedPayment(IntegratedPayment.LongTermLumpSum);
		context.setPolicyPeriodYears(20);

		mockDepenedSpec.apply();
		EasyMock.expectLastCall().andReturn(new BigDecimal(5324));

		replayAll();
		BigDecimal actual = testee.apply();
		verifyAll();

		assertThat(actual.toPlainString(), is("81190"));
	}
}
