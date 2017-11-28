package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 払込方法
 *
 * @author t-kubo
 *
 */
public enum IntegratedPayment {

	NotSpecified("指定なし"),				//指定なし
	LumpSum("一時払"),						//一時払
	LongTermLumpSum("長期一括払"),		//長期一括払
	LongTermYearlyPayment("長期年払"),	//長期年払
	Installment6("分割6回払い"),			//分割6回払い
	Installment12("分割12回払い");		//分割12回払い

	private String displayName;

	IntegratedPayment(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 払込方法の表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

}
