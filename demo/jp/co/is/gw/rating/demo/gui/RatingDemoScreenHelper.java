package jp.co.is.gw.rating.demo.gui;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jp.co.is.gw.rating.engine.common.constants.Incidental;
import jp.co.is.gw.rating.engine.util.DateUtil;

public class RatingDemoScreenHelper {

    public static Incidental windHailstoneDisaster(JCheckBox windHailstoneDisaster) {

	if (windHailstoneDisaster.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    public static Incidental waterDisaster(JCheckBox waterDisaster) {

	if (waterDisaster.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    public static Incidental temporaryCost(JCheckBox temporaryCost) {

	if (temporaryCost.isSelected()) {
	    return Incidental.YES;
	}

	return Incidental.NO;
    }

    public static BigDecimal buildingInsurance(JFormattedTextField insuranceAmountInput) {

	Long amount = (Long) insuranceAmountInput.getValue();
	if (amount == null) {
	    return new BigDecimal(0);
	}

	return new BigDecimal(amount).multiply(new BigDecimal(1000));
    }

    public static void setEndDate(String termYears, String startDate, JFormattedTextField endDateInput) throws ParseException {

	Calendar calendar = DateUtil.stringDateToCalendar(startDate);
	Calendar endDate = DateUtil.addYesrs(calendar, Integer.parseInt(termYears));
	endDateInput.setValue(DateUtil.calendarToString(endDate));
    }

    public static void displayMessage(JPanel messagePanel, JLabel messageLabel, String message) {
	messageLabel.setText(message);
	messagePanel.setVisible(true);
    }

}
