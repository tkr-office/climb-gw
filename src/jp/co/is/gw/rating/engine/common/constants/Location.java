package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 物件所在地
 *
 * @author t-kubo
 *
 */
public enum Location {

	NotSpecified("指定なし"), // 指定なし
	Sapporo("札幌"), // 札幌市
	Aomori("青森"), // 青森市
	Sendai("仙台市"), // 仙台市
	Utsunomiya("宇都宮市"), // 宇都宮市
	Maebashi("前橋市"), // 前橋市
	Saitama("さいたま市"), // さいたま市
	Kawaguchi("川口市"), // 川口市
	Hachioji("八王子市"); // 八王子市

	private String displayName;

	Location(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 物件所在地の表示名を取得する
	 *
	 * @return 表示名
	 */
	public String getDisplayName() {
		return displayName;
	}

}
