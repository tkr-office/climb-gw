package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 付帯あり・なし
 *
 * @author t-kubo
 *
 */
public enum Incidental {

	YES("付帯あり"),		//付帯あり
	NO("付帯なし");			//付帯なし

	private String displayName;

	Incidental(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 付帯あり・なしの表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

}
