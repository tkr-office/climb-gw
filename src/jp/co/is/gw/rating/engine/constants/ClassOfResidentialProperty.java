package jp.co.is.gw.rating.engine.constants;

/**
 *
 * 住宅物件における構造級別
 *
 * @author t-kubo
 *
 */
public enum ClassOfResidentialProperty {

	ClassA("A構造"),						//A構造
	ClassB("B構造"),						//B構造
	ClassC("C構造"),						//C構造
	ClassD("D構造");						//D構造

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

}
