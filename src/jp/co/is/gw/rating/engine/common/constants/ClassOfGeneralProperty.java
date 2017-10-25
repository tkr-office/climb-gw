package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 一般物件における構造級別
 *
 * @author t-kubo
 *
 */
public enum ClassOfGeneralProperty {

	NotSpecified("指定なし"),				//指定なし
	HighGrade("特級"),						//A特級
	FirstGrade("1級"),						//1級
	SecondGrade("2級"),					//2級
	ThirdGrade("3級"),						//3級
	ForthGrade("4級");						//4級

	private String displayName;

	ClassOfGeneralProperty(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 一般物件における構造級別の表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

}
