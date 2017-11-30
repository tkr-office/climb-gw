package jp.co.is.gw.rating.demo.gui.listeners;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;

import jp.co.is.gw.rating.demo.gui.RatingDemoScreenHelper;

public class TermYearsFocusAdapter extends FocusAdapter {

    private JFormattedTextField startDateInput;
    private JFormattedTextField endDateInput;

    public TermYearsFocusAdapter(JFormattedTextField startDateInput, JFormattedTextField endDateInput) {
	this.startDateInput = startDateInput;
	this.endDateInput = endDateInput;
    }

    @Override
    public void focusLost(FocusEvent e) {

	JTextField termYearsInput = (JTextField) e.getSource();
	String termYears = termYearsInput.getText();
	if (Strings.isNullOrEmpty(termYears) || //
		!CharMatcher.digit().matchesAllOf(termYears.subSequence(0, termYears.length()))) {
	    return;
	}

	try {
	    RatingDemoScreenHelper.setEndDate(termYears, startDateInput.getText(), endDateInput);
	} catch (ParseException e1) {
	    e1.printStackTrace();
	}

	super.focusLost(e);
    }

}
