package jp.co.is.gw.rating.demo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.common.constants.IntegratedPayment;
import jp.co.is.gw.rating.engine.common.constants.Location;
import jp.co.is.gw.rating.engine.common.constants.RangeDiscountType;
import jp.co.is.gw.rating.engine.fire.FireInsuranceRatingCalculator;
import jp.co.is.gw.rating.engine.util.DateUtil;

public class RatingDemoMain extends JFrame {

    private JPanel contentPane;
    private JTextField termYearsInput;
    private JTextField termMonthsInput;
    private JComboBox<BuildingType> buildingTypeList;
    private JComboBox<Location> locationList;
    private JFormattedTextField startDateInput;
    private JFormattedTextField endDateInput;
    private JCheckBox windHailstoneDisaster;
    private JCheckBox waterDisaster;
    private JCheckBox temporaryCost;
    private JComboBox<ClassOfResidentialProperty> classOfProperty;
    private JComboBox<RangeDiscountType> rangeDiscount;
    private JFormattedTextField insuranceAmountInput;
    private JComboBox<IntegratedPayment> integratedPaymentList;
    private JFormattedTextField premiumAmountOutput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    RatingDemoMain frame = new RatingDemoMain();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public RatingDemoMain() {
	setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 676, 485);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));

	JLabel mainTitleLabel = new JLabel("メインタイトル");
	mainTitleLabel.setOpaque(true);
	mainTitleLabel.setFont(new Font("MS UI Gothic", Font.ITALIC, 12));
	mainTitleLabel.setBackground(new Color(173, 216, 230));
	contentPane.add(mainTitleLabel, BorderLayout.NORTH);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBackground(new Color(255, 255, 255));
	contentPane.add(scrollPane, BorderLayout.CENTER);

	JPanel mainPanel = new JPanel();
	mainPanel.setBackground(new Color(255, 255, 255));
	scrollPane.setViewportView(mainPanel);
	mainPanel.setLayout(new BorderLayout(0, 0));

	JPanel firePolicyPanel = new JPanel();
	firePolicyPanel.setBackground(new Color(255, 239, 213));
	mainPanel.add(firePolicyPanel);
	firePolicyPanel.setLayout(null);

	JLabel filePolicyTitleLabel = new JLabel("建物火災");
	filePolicyTitleLabel.setFont(new Font("MS UI Gothic", Font.ITALIC, 14));
	filePolicyTitleLabel.setBounds(12, 10, 57, 21);
	firePolicyPanel.add(filePolicyTitleLabel);

	JLabel startDateLabel = new JLabel("保険始期日");
	startDateLabel.setBounds(19, 54, 60, 13);
	firePolicyPanel.add(startDateLabel);

	JLabel endDateLabel = new JLabel("保険終期日");
	endDateLabel.setBounds(276, 54, 67, 13);
	firePolicyPanel.add(endDateLabel);

	JLabel policyTerm = new JLabel("契約期間");
	policyTerm.setBounds(19, 88, 60, 13);
	firePolicyPanel.add(policyTerm);

	termYearsInput = new JTextField();
	termYearsInput.setColumns(10);
	termYearsInput.setBorder(UIManager.getBorder("TextField.border"));
	termYearsInput.setBounds(87, 85, 29, 19);
	firePolicyPanel.add(termYearsInput);

	JLabel termYearsLabel = new JLabel("年");
	termYearsLabel.setBounds(123, 88, 12, 13);
	firePolicyPanel.add(termYearsLabel);

	termMonthsInput = new JTextField();
	termMonthsInput.setColumns(10);
	termMonthsInput.setBorder(UIManager.getBorder("TextField.border"));
	termMonthsInput.setBounds(142, 85, 29, 19);
	firePolicyPanel.add(termMonthsInput);

	JLabel termMonthsLabel = new JLabel("ヶ月");
	termMonthsLabel.setBounds(183, 88, 20, 13);
	firePolicyPanel.add(termMonthsLabel);

	JLabel buildingTypeLabel = new JLabel("物件種別");
	buildingTypeLabel.setBounds(19, 123, 60, 13);
	firePolicyPanel.add(buildingTypeLabel);

	buildingTypeList = new JComboBox<BuildingType>();
	buildingTypeList.setBackground(new Color(255, 255, 255));
	buildingTypeList.setModel(new DefaultComboBoxModel<BuildingType>(BuildingType.values()));
	buildingTypeList.setSize(new Dimension(10, 0));
	buildingTypeList.setBounds(87, 120, 96, 19);
	firePolicyPanel.add(buildingTypeList);

	JLabel locationLabel = new JLabel("所在地");
	locationLabel.setBounds(19, 159, 60, 13);
	firePolicyPanel.add(locationLabel);

	locationList = new JComboBox<Location>();
	locationList.setModel(new DefaultComboBoxModel<Location>(Location.values()));
	locationList.setSize(new Dimension(10, 0));
	locationList.setBackground(Color.WHITE);
	locationList.setBounds(87, 156, 96, 19);
	firePolicyPanel.add(locationList);

	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
	startDateInput = new JFormattedTextField(sdf1);
	startDateInput.setBounds(88, 51, 111, 19);
	firePolicyPanel.add(startDateInput);

	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
	endDateInput = new JFormattedTextField(sdf2);
	endDateInput.setBounds(343, 51, 111, 19);
	firePolicyPanel.add(endDateInput);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 239, 213));
	panel.setBorder(new TitledBorder(
		new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null,
			new Color(0, 0, 0)),
		"\u7279\u7D04", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panel.setBounds(12, 195, 191, 80);
	firePolicyPanel.add(panel);
	panel.setLayout(new GridLayout(0, 1, 0, 0));

	windHailstoneDisaster = new JCheckBox("風・雹災");
	windHailstoneDisaster.setOpaque(false);
	panel.add(windHailstoneDisaster);

	waterDisaster = new JCheckBox("水災");
	waterDisaster.setOpaque(false);
	panel.add(waterDisaster);

	temporaryCost = new JCheckBox("臨時費用");
	temporaryCost.setOpaque(false);
	panel.add(temporaryCost);

	JLabel classLabel = new JLabel("構造級別");
	classLabel.setBounds(276, 123, 60, 13);
	firePolicyPanel.add(classLabel);

	classOfProperty = new JComboBox<ClassOfResidentialProperty>();
	classOfProperty
		.setModel(new DefaultComboBoxModel<ClassOfResidentialProperty>(ClassOfResidentialProperty.values()));
	classOfProperty.setSize(new Dimension(10, 0));
	classOfProperty.setBackground(Color.WHITE);
	classOfProperty.setBounds(345, 120, 96, 19);
	firePolicyPanel.add(classOfProperty);

	JLabel rangeDiscountLabel = new JLabel("範囲割引");
	rangeDiscountLabel.setBounds(276, 195, 60, 13);
	firePolicyPanel.add(rangeDiscountLabel);

	rangeDiscount = new JComboBox<RangeDiscountType>();
	rangeDiscount.setModel(new DefaultComboBoxModel<RangeDiscountType>(RangeDiscountType.values()));
	rangeDiscount.setSize(new Dimension(10, 0));
	rangeDiscount.setBackground(Color.WHITE);
	rangeDiscount.setBounds(345, 192, 96, 19);
	firePolicyPanel.add(rangeDiscount);

	JLabel insuranceAmountLabel = new JLabel("保険金額");
	insuranceAmountLabel.setBounds(19, 291, 60, 13);
	firePolicyPanel.add(insuranceAmountLabel);

	DecimalFormat df1 = new DecimalFormat("\\#,###");
	insuranceAmountInput = new JFormattedTextField(df1);
	insuranceAmountInput.setBounds(87, 288, 111, 19);
	firePolicyPanel.add(insuranceAmountInput);

	JLabel insuranceAmountUnitLabel = new JLabel("千円");
	insuranceAmountUnitLabel.setBounds(209, 291, 60, 13);
	firePolicyPanel.add(insuranceAmountUnitLabel);

	JLabel integratedPaymentLabel = new JLabel("払込方法");
	integratedPaymentLabel.setBounds(19, 324, 60, 13);
	firePolicyPanel.add(integratedPaymentLabel);

	integratedPaymentList = new JComboBox<IntegratedPayment>();
	integratedPaymentList.setModel(new DefaultComboBoxModel<IntegratedPayment>(IntegratedPayment.values()));
	integratedPaymentList.setBounds(87, 324, 116, 19);
	firePolicyPanel.add(integratedPaymentList);

	JLabel premiumAmountLabel = new JLabel("建物保険料");
	premiumAmountLabel.setBounds(17, 379, 73, 13);
	firePolicyPanel.add(premiumAmountLabel);

	DecimalFormat df2 = new DecimalFormat("\\#,###");
	premiumAmountOutput = new JFormattedTextField(df2);
	premiumAmountOutput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	premiumAmountOutput.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
	premiumAmountOutput.setOpaque(false);
	premiumAmountOutput.setDisabledTextColor(new Color(0, 0, 0));
	premiumAmountOutput.setEditable(false);
	premiumAmountOutput.setBounds(87, 371, 122, 27);
	firePolicyPanel.add(premiumAmountOutput);

	JButton quateButton = new JButton("保険料見積");
	quateButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		try {
		    BigDecimal premiumAmount = quatePremiumAmount();
		    premiumAmountOutput.setText(premiumAmount.toPlainString());
		} catch (Exception e1) {
		    e1.printStackTrace();
		}

	    }
	});
	quateButton.setBounds(343, 370, 111, 21);
	firePolicyPanel.add(quateButton);
    }

    private BigDecimal quatePremiumAmount() throws Exception {

	RatingContext context = createContext();
	FireInsuranceRatingCalculator calculator = new FireInsuranceRatingCalculator(context);

	return calculator.calculate();
    }

    private RatingContext createContext() {

	RatingContext context = new RatingContext();
	context.setPolicyStartDate(DateUtil.stringDateToCalendar(startDateInput.getText()));
	context.setPolicyEndDate(DateUtil.stringDateToCalendar(endDateInput.getText()));
	context.setPolicyPeriodYears(Integer.parseInt(termYearsInput.getText()));
	context.setPolicyPeriodMonths(Integer.parseInt(termMonthsInput.getText()));
	context.setBuildingType((BuildingType) buildingTypeList.getModel().getSelectedItem());
	context.setClassOfResidentialProperty(
		(ClassOfResidentialProperty) classOfProperty.getModel().getSelectedItem());
	context.setLocation((Location) locationList.getModel().getSelectedItem());
	context.setRangeDiscountType((RangeDiscountType) rangeDiscount.getModel().getSelectedItem());
	context.setWindHailstoneDisaster(windHailstoneDisaster());
	context.setWaterDisaster(waterDisaster());
	context.setTemporaryCost(temporaryCost());
	context.setBuildingInsurance(buildingInsurance());
	context.setIntegratedPayment((IntegratedPayment) integratedPaymentList.getModel().getSelectedItem());

	return context;
    }

    private Incidental windHailstoneDisaster() {

	if (windHailstoneDisaster.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    private Incidental waterDisaster() {

	if (waterDisaster.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    private Incidental temporaryCost() {

	if (temporaryCost.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    private BigDecimal buildingInsurance() {

	String text = insuranceAmountInput.getText();
	if (text == null || insuranceAmountInput.getText() == "") {
	    return new BigDecimal(0);
	}

	return new BigDecimal(text).multiply(new BigDecimal(1000));
    }
}
