package jp.co.is.gw.rating.engine;

import java.math.BigDecimal;

import jp.co.is.gw.rating.engine.constants.ClassOfGeneralProperty;
import jp.co.is.gw.rating.engine.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.constants.Incidental;
import jp.co.is.gw.rating.engine.constants.IntegratedPayment;
import jp.co.is.gw.rating.engine.constants.RangeDiscountType;

/**
 *
 * 保険料計算コンテキスト 保険料計算の算出過程で必要となる各種の値を格納しておくためのコンテナクラス
 *
 * @author t-kubo
 *
 */
public class RatingContext {

	private BigDecimal buildingInsurance; // 建物保険金額
	private ClassOfGeneralProperty classOfGeneralProperty; // 一般物件における構造級別
	private ClassOfResidentialProperty classOfResidentialProperty; // 住宅物件における構造級別
	private Incidental windHailstoneDisaster = Incidental.NO; // 風・雹災付帯有無
	private Incidental waterDisaster = Incidental.NO; // 水災付帯有無
	private Incidental temporaryCost = Incidental.NO; // 臨時費用付帯有無
	private IntegratedPayment integratedPayment; // 払込方法
	private RangeDiscountType rangeDiscountType = RangeDiscountType.None; // 範囲割引

	public BigDecimal getBuildingInsurance() {
		return buildingInsurance;
	}

	public void setBuildingInsurance(BigDecimal buildingInsurance) {
		this.buildingInsurance = buildingInsurance;
	}

	public ClassOfGeneralProperty getClassOfGeneralProperty() {
		return classOfGeneralProperty;
	}

	public void setClassOfGeneralProperty(ClassOfGeneralProperty classOfGeneralProperty) {
		this.classOfGeneralProperty = classOfGeneralProperty;
	}

	public ClassOfResidentialProperty getClassOfResidentialProperty() {
		return classOfResidentialProperty;
	}

	public void setClassOfResidentialProperty(ClassOfResidentialProperty classOfResidentialProperty) {
		this.classOfResidentialProperty = classOfResidentialProperty;
	}

	public Incidental getWindHailstoneDisaster() {
		return windHailstoneDisaster;
	}

	public void setWindHailstoneDisaster(Incidental windHailstoneDisaster) {
		this.windHailstoneDisaster = windHailstoneDisaster;
	}

	public Incidental getWaterDisaster() {
		return waterDisaster;
	}

	public void setWaterDisaster(Incidental waterDisaster) {
		this.waterDisaster = waterDisaster;
	}

	public Incidental getTemporaryCost() {
		return temporaryCost;
	}

	public void setTemporaryCost(Incidental temporaryCost) {
		this.temporaryCost = temporaryCost;
	}

	public IntegratedPayment getIntegratedPayment() {
		return integratedPayment;
	}

	public void setIntegratedPayment(IntegratedPayment integratedPayment) {
		this.integratedPayment = integratedPayment;
	}

	public RangeDiscountType getRangeDiscountType() {
		return rangeDiscountType;
	}

	public void setRangeDiscountType(RangeDiscountType rangeDiscountType) {
		this.rangeDiscountType = rangeDiscountType;
	}

}
