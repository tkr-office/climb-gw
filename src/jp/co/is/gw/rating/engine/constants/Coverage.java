package jp.co.is.gw.rating.engine.constants;

/**
 *
 * 担保
 *
 * @author t-kubo
 *
 */
public enum Coverage {

	Building("建物"),					//建物
	HouseholdGoods("家財"),			//家財
	SpecifiedProperty("明記物件"),	//明記物件
	EquipmentFixtures("設備什器"),	//設備什器
	Products("商品製品");				//商品製品

	private String displayName;

	Coverage(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 担保表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

}
