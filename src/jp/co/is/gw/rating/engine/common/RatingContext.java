package jp.co.is.gw.rating.engine.common;

import java.math.BigDecimal;
import java.util.Calendar;

import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfGeneralProperty;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.common.constants.IntegratedPayment;
import jp.co.is.gw.rating.engine.common.constants.Location;
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;

/**
 *
 * 保険料計算コンテキスト<br/>
 * 保険料計算の算出過程で必要となる各種の値を格納しておくためのコンテナクラス
 *
 * @author t-kubo
 *
 */
public class RatingContext {

	private Calendar policyStartDate; // 保険始期日
	private Calendar policyEndDate;   // 保険終期日
	private int policyPeriodYears;    // 保険期間(年)
	private BigDecimal buildingInsurance = BigDecimal.ZERO; // 建物保険金額
	private BuildingType buildingType = BuildingType.NotSpecified; //建物物件種別
	private ClassOfGeneralProperty classOfGeneralProperty = ClassOfGeneralProperty.NotSpecified; // 一般物件における構造級別
	private ClassOfResidentialProperty classOfResidentialProperty = ClassOfResidentialProperty.NotSpecified; // 住宅物件における構造級別
	private Incidental windHailstoneDisaster = Incidental.NO; // 風・雹災付帯有無
	private Incidental waterDisaster = Incidental.NO; // 水災付帯有無
	private Incidental temporaryCost = Incidental.NO; // 臨時費用付帯有無
	private IntegratedPayment integratedPayment = IntegratedPayment.NotSpecified; // 払込方法
	private RangeDiscountType rangeDiscountType = RangeDiscountType.None; // 範囲割引
	private Location location = Location.NotSpecified; // 物件所在地

	public Calendar getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(Calendar policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public Calendar getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(Calendar policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public int getPolicyPeriodYears() {
		return policyPeriodYears;
	}

	public void setPolicyPeriodYears(int policyPeriodYears) {
		this.policyPeriodYears = policyPeriodYears;
	}

	public BigDecimal getBuildingInsurance() {
		return buildingInsurance;
	}

	public void setBuildingInsurance(BigDecimal buildingInsurance) {
		this.buildingInsurance = buildingInsurance;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
