package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 住宅物件における構造級別
 *
 * @author t-kubo
 *
 */
public enum ClassOfResidentialProperty {

	NotSpecified("指定なし"),				//指定なし
	ClassT("T構造"),						//T構造
	ClassH("H構造"),						//H構造
	ClassM("M構造");						//M構造

	private String displayName;

	ClassOfResidentialProperty(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 住宅物件における構造級別の表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
	    return getDisplayName();
	}

}
