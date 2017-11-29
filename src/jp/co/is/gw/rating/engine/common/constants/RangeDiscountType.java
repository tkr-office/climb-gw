package jp.co.is.gw.rating.engine.common.constants;

/**
 *
 * 範囲割引
 *
 * @author t-kubo
 *
 */
public enum RangeDiscountType {

	None("適用なし"), // 適用なし
	ElectronicSecurityDiscount("機械警備割引"), 									// 機械警備割引
	TwoByFour("2×4工法建物・木質プレハブ建物割引"), 									// 2×4工法建物・木質プレハブ建物割引
	ResidentialPropertiesOpenSpaceDiscount("住宅物件空地割引"), 					// 住宅物件空地割引
	AStructureHousingTenantsTheOwnerDiscount("Ａ構造住宅入居者・所有者割引"),		// Ａ構造住宅入居者・所有者割引
	PriceAgreementAuthorizedIncidentalDiscount("価額協定特約付帯割引"); 			// 価額協定特約付帯割引

	private String displayName;

	RangeDiscountType(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * 範囲割引の表示名を取得する
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
