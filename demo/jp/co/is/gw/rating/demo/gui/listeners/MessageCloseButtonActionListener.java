package jp.co.is.gw.rating.demo.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MessageCloseButtonActionListener implements ActionListener {

    private JPanel messageAreaPanel;

    public MessageCloseButtonActionListener(JPanel messageAreaPanel) {
	this.messageAreaPanel = messageAreaPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	messageAreaPanel.setVisible(false);
    }

}
