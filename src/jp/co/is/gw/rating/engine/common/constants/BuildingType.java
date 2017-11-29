package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 建物物件種別
 *
 * @author t-kubo
 *
 */
public enum BuildingType {

	NotSpecified("指定なし"), // 指定なし
	ResidentialProperty("住宅物件"), // 住宅物件
	GeneralProperty("一般物件"); // 一般物件

	private String displayName;

	BuildingType(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 建物物件種別の表示名を取得する
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
