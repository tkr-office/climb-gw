package jp.co.is.gw.rating.demo.gui.listeners;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import jp.co.is.gw.rating.demo.gui.RatingDemoScreenHelper;

public class StartDateFocusAdapter extends FocusAdapter {

    private JFormattedTextField endDateInput;
    private JTextField termYearsInput;

    public StartDateFocusAdapter(JTextField termYearsInput, JFormattedTextField endDateInput) {
	this.termYearsInput = termYearsInput;
	this.endDateInput = endDateInput;
    }

    @Override
    public void focusLost(FocusEvent e) {

	String termYears = termYearsInput.getText();
	if (Strings.isNullOrEmpty(termYears) || //
		!CharMatcher.digit().matchesAllOf(termYears.subSequence(0, termYears.length()))) {
	    return;
	}

	JFormattedTextField startDateInput = (JFormattedTextField) e.getSource();

	try {
	    RatingDemoScreenHelper.setEndDate(termYears, startDateInput.getText(), endDateInput);
	} catch (ParseException e1) {
	    e1.printStackTrace();
	}

	super.focusLost(e);
    }

}
