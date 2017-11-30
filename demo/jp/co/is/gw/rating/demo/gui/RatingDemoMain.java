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
import javax.swing.text.MaskFormatter;

import jp.co.is.gw.rating.demo.gui.listeners.MessageCloseButtonActionListener;
import jp.co.is.gw.rating.demo.gui.listeners.StartDateFocusAdapter;
import jp.co.is.gw.rating.demo.gui.listeners.TermYearsFocusAdapter;
import jp.co.is.gw.rating.engine.common.RatingContext;
import jp.co.is.gw.rating.engine.common.constants.BuildingType;
import jp.co.is.gw.rating.engine.common.constants.ClassOfResidentialProperty;
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
    private final JLabel messageLabel = new JLabel("");
    private JPanel messageAreaPanel;

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
    public RatingDemoMain() throws Exception {
	setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 689, 535);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));

	JLabel mainTitleLabel = new JLabel("保険料見積もりデモ");
	mainTitleLabel.setOpaque(true);
	mainTitleLabel.setFont(new Font("MS UI Gothic", Font.ITALIC, 14));
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
	startDateLabel.setBounds(19, 54, 89, 13);
	firePolicyPanel.add(startDateLabel);

	JLabel endDateLabel = new JLabel("保険終期日");
	endDateLabel.setBounds(365, 55, 89, 13);
	firePolicyPanel.add(endDateLabel);

	JLabel policyTerm = new JLabel("契約期間");
	policyTerm.setBounds(19, 88, 89, 13);
	firePolicyPanel.add(policyTerm);

	MaskFormatter sdf1 = new MaskFormatter("####/##/##");
	sdf1.setPlaceholderCharacter('_');
	startDateInput = new JFormattedTextField(sdf1);
	startDateInput.setBounds(145, 54, 136, 19);
	firePolicyPanel.add(startDateInput);

	MaskFormatter sdf2 = new MaskFormatter("####/##/##");
	sdf2.setPlaceholderCharacter('_');
	endDateInput = new JFormattedTextField(sdf2);
	endDateInput.setOpaque(false);
	endDateInput.setEditable(false);
	endDateInput.setBounds(497, 54, 136, 19);
	firePolicyPanel.add(endDateInput);

	termYearsInput = new JTextField();
	termYearsInput.setColumns(10);
	termYearsInput.setBorder(UIManager.getBorder("TextField.border"));
	termYearsInput.setBounds(144, 88, 29, 19);
	termYearsInput.setText("1");
	firePolicyPanel.add(termYearsInput);

	JLabel termYearsLabel = new JLabel("年");
	termYearsLabel.setBounds(187, 88, 24, 13);
	firePolicyPanel.add(termYearsLabel);

	termMonthsInput = new JTextField();
	termMonthsInput.setColumns(10);
	termMonthsInput.setBorder(UIManager.getBorder("TextField.border"));
	termMonthsInput.setBounds(223, 88, 29, 19);
	termMonthsInput.setText("0");
	firePolicyPanel.add(termMonthsInput);

	JLabel termMonthsLabel = new JLabel("ヶ月");
	termMonthsLabel.setBounds(264, 91, 29, 13);
	firePolicyPanel.add(termMonthsLabel);

	JLabel buildingTypeLabel = new JLabel("物件種別");
	buildingTypeLabel.setBounds(19, 123, 89, 13);
	firePolicyPanel.add(buildingTypeLabel);

	buildingTypeList = new JComboBox<BuildingType>();
	buildingTypeList.setBackground(new Color(255, 255, 255));
	buildingTypeList.setModel(new DefaultComboBoxModel<BuildingType>(BuildingType.values()));
	buildingTypeList.setSize(new Dimension(10, 0));
	buildingTypeList.setBounds(144, 123, 137, 19);
	firePolicyPanel.add(buildingTypeList);

	JLabel locationLabel = new JLabel("所在地");
	locationLabel.setBounds(19, 159, 89, 13);
	firePolicyPanel.add(locationLabel);

	locationList = new JComboBox<Location>();
	locationList.setModel(new DefaultComboBoxModel<Location>(Location.values()));
	locationList.setSize(new Dimension(10, 0));
	locationList.setBackground(Color.WHITE);
	locationList.setBounds(144, 159, 137, 19);
	firePolicyPanel.add(locationList);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 239, 213));
	panel.setBorder(new TitledBorder(
		new TitledBorder(new LineBorder(new Color(0, 0, 0)), "", TitledBorder.LEADING, TitledBorder.TOP, null,
			new Color(0, 0, 0)),
		"\u7279\u7D04", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
	panel.setBounds(12, 195, 248, 80);
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
	classLabel.setBounds(365, 124, 89, 13);
	firePolicyPanel.add(classLabel);

	classOfProperty = new JComboBox<ClassOfResidentialProperty>();
	classOfProperty
		.setModel(new DefaultComboBoxModel<ClassOfResidentialProperty>(ClassOfResidentialProperty.values()));
	classOfProperty.setSize(new Dimension(10, 0));
	classOfProperty.setBackground(Color.WHITE);
	classOfProperty.setBounds(499, 123, 96, 19);
	firePolicyPanel.add(classOfProperty);

	JLabel rangeDiscountLabel = new JLabel("範囲割引");
	rangeDiscountLabel.setBounds(365, 196, 89, 13);
	firePolicyPanel.add(rangeDiscountLabel);

	rangeDiscount = new JComboBox<RangeDiscountType>();
	rangeDiscount.setModel(new DefaultComboBoxModel<RangeDiscountType>(RangeDiscountType.values()));
	rangeDiscount.setSize(new Dimension(10, 0));
	rangeDiscount.setBackground(Color.WHITE);
	rangeDiscount.setBounds(499, 195, 96, 19);
	firePolicyPanel.add(rangeDiscount);

	JLabel insuranceAmountLabel = new JLabel("保険金額");
	insuranceAmountLabel.setBounds(19, 291, 89, 13);
	firePolicyPanel.add(insuranceAmountLabel);

	DecimalFormat df1 = new DecimalFormat("\u00A4#,###,###,###.######");
	insuranceAmountInput = new JFormattedTextField(df1);
	insuranceAmountInput.setBounds(144, 291, 137, 19);
	insuranceAmountInput.setValue(Double.valueOf(0d));
	firePolicyPanel.add(insuranceAmountInput);

	JLabel insuranceAmountUnitLabel = new JLabel("千円");
	insuranceAmountUnitLabel.setBounds(286, 291, 60, 13);
	firePolicyPanel.add(insuranceAmountUnitLabel);

	JLabel integratedPaymentLabel = new JLabel("払込方法");
	integratedPaymentLabel.setBounds(19, 324, 89, 13);
	firePolicyPanel.add(integratedPaymentLabel);

	integratedPaymentList = new JComboBox<IntegratedPayment>();
	integratedPaymentList.setModel(new DefaultComboBoxModel<IntegratedPayment>(IntegratedPayment.values()));
	integratedPaymentList.setBounds(144, 327, 137, 19);
	firePolicyPanel.add(integratedPaymentList);

	JLabel premiumAmountLabel = new JLabel("建物保険料");
	premiumAmountLabel.setBounds(17, 379, 91, 13);
	firePolicyPanel.add(premiumAmountLabel);

	DecimalFormat df2 = new DecimalFormat("\u00A4#,###,###,###");
	premiumAmountOutput = new JFormattedTextField(df2);
	premiumAmountOutput.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	premiumAmountOutput.setFont(new Font("MS UI Gothic", Font.PLAIN, 14));
	premiumAmountOutput.setOpaque(false);
	premiumAmountOutput.setDisabledTextColor(new Color(0, 0, 0));
	premiumAmountOutput.setEditable(false);
	premiumAmountOutput.setBounds(144, 374, 137, 27);
	premiumAmountOutput.setValue(Long.valueOf(0L));
	firePolicyPanel.add(premiumAmountOutput);

	JButton quateButton = new JButton("保険料見積");
	quateButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {

		try {
		    BigDecimal premiumAmount = quatePremiumAmount();
		    premiumAmountOutput.setValue(premiumAmount.longValue());
		} catch (Exception e) {
		    RatingDemoScreenHelper.displayMessage(messageAreaPanel, messageLabel, e.getMessage());
		    e.printStackTrace();
		}

	    }
	});
	quateButton.setBounds(497, 401, 111, 21);
	firePolicyPanel.add(quateButton);

	startDateInput.addFocusListener(new StartDateFocusAdapter(termYearsInput, endDateInput));
	termYearsInput.addFocusListener(new TermYearsFocusAdapter(startDateInput, endDateInput));

	messageAreaPanel = new JPanel();
	messageAreaPanel.setVisible(false);
	messageAreaPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	messageAreaPanel.setOpaque(false);
	messageAreaPanel.setBackground(new Color(255, 255, 255));
	contentPane.add(messageAreaPanel, BorderLayout.SOUTH);
	messageAreaPanel.setLayout(new BorderLayout(0, 0));
	messageLabel.setForeground(new Color(255, 0, 0));
	messageLabel.setFont(new Font("MS UI Gothic", Font.ITALIC, 14));
	messageAreaPanel.add(messageLabel, BorderLayout.NORTH);

	JButton messageOkButton = new JButton("OK");
	messageOkButton.addActionListener(new MessageCloseButtonActionListener(messageAreaPanel));
	messageAreaPanel.add(messageOkButton, BorderLayout.EAST);
    }

    private BigDecimal quatePremiumAmount() throws Exception {

	RatingContext context = createContext();
	FireInsuranceRatingCalculator calculator = new FireInsuranceRatingCalculator(context);
	return calculator.calculate();
    }

    private RatingContext createContext() throws Exception {

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
	context.setWindHailstoneDisaster(RatingDemoScreenHelper.windHailstoneDisaster(windHailstoneDisaster));
	context.setWaterDisaster(RatingDemoScreenHelper.waterDisaster(waterDisaster));
	context.setTemporaryCost(RatingDemoScreenHelper.temporaryCost(temporaryCost));
	context.setBuildingInsurance(RatingDemoScreenHelper.buildingInsurance(insuranceAmountInput));
	context.setIntegratedPayment((IntegratedPayment) integratedPaymentList.getModel().getSelectedItem());

	System.out.println(context);

	return context;
    }
}
