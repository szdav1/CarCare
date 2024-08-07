package com.silentsoft.application.dialogs;

import java.awt.GridLayout;

import javax.swing.*;

import com.silentsoft.util.appdata.Dimensions;
import com.silentsoft.util.appdata.Log;
import com.silentsoft.util.appdata.RuntimeOnlyLog;

public final class ErrorDialog extends JDialog {
	private final JLabel errorMessageLabel;
	private final JTextArea adminMessageArea;

	public ErrorDialog() {
		this.errorMessageLabel = new JLabel(UIManager.getIcon("OptionPane.errorIcon"));
		this.adminMessageArea = new JTextArea();
		this.adminMessageArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(this.adminMessageArea);

		this.setLayout(new GridLayout(2, 1));
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setSize(Dimensions.ERROR_DIALOG_DIMENSION);
		this.setLocationRelativeTo(null);

		this.add(this.errorMessageLabel);
		this.add(scrollPane);
	}

	private String mergeStackTraceElements(final StackTraceElement[] stackTraceElements) {
		StringBuilder builder = new StringBuilder();

		for (StackTraceElement stackTraceElement : stackTraceElements) {
			builder.append(stackTraceElement.toString()).append("\n");
		}

		return builder.toString();
	}

	public void displayErrorMessage(final Exception exception, final ErrorMessage errorMessage, final Log log) {
		RuntimeOnlyLog.appendLog(log);
		this.setTitle(exception.getMessage());
		this.errorMessageLabel.setText(errorMessage.getMessage());

		if (RuntimeOnlyLog.contains(Log.RUNNING_AS_ADMIN)) {
			this.adminMessageArea.setText(this.mergeStackTraceElements(exception.getStackTrace()));
			this.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(null, errorMessage.getMessage(), exception.getMessage(), JOptionPane.ERROR_MESSAGE);
	}
}
