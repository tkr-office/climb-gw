package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 払込方法
 *
 * @author t-kubo
 *
 */
public enum IntegratedPayment {

	NotSpecified("指定なし", -1),				// 指定なし
	LumpSum("一時払", 1),						// 一時払
	LongTermLumpSum("長期一括払", 1),			// 長期一括払
	LongTermYearlyPayment("長期年払", -1),	// 長期年払
	Installment6("分割6回払い", 6),			// 分割6回払い
	Installment12("分割12回払い", 12);		// 分割12回払い

	private String displayName;
	private int paymentNum;

	IntegratedPayment(String displayName, int paymentNum) {
		this.displayName = displayName;
		this.paymentNum = paymentNum;
	}

	/**
	 * 払込方法の表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 払込回数を取得する
	 *
	 * @return 払込回数
	 */
	public int getPaymentNum() {
		return paymentNum;
	}

	@Override
	public String toString() {
	    return getDisplayName();
	}

}
