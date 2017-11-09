package pacecalc.pacecalc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PaceCalcUI extends JFrame {

	JButton btnCalc;
	JButton btnExit;
	JPanel panelMain;
	JTextField txtTime;
	JTextField txtDistance;
	JTextField txtPace;
	ButtonGroup bgSelect;
	JRadioButton rbPace;
	JRadioButton rbTime;
	JRadioButton rbDistance;
	JLabel lblTime;
	JLabel lblPace;
	JLabel lblDistance;
	JOptionPane exitMessage;
	JOptionPane errorMessage;

	public PaceCalcUI() {

		this.setSize(360, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMain = new JPanel();
		panelMain.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnCalc = new JButton("Calculate");

		btnExit = new JButton("Exit");

		lblPace = new JLabel("Enter pace in format mm:ss");
		lblTime = new JLabel("Enter time in format hh:mm:ss");
		lblDistance = new JLabel("Enter distance in meters(should be integer value)");

		txtTime = new JTextField(20);
		txtPace = new JTextField(20);
		txtDistance = new JTextField(20);
		txtPace.setEnabled(false);

		rbPace = new JRadioButton("Calculate pace based on time and distance:");
		rbPace.setActionCommand("pace");

		rbTime = new JRadioButton("Calculate time based on pace and distance:");
		rbTime.setActionCommand("time");

		rbDistance = new JRadioButton("Calculate distance based on pace and time:");
		rbDistance.setActionCommand("distance");

		ListenerForRadioButton lForRadioButton = new ListenerForRadioButton();

		rbPace.addActionListener(lForRadioButton);
		rbTime.addActionListener(lForRadioButton);
		rbDistance.addActionListener(lForRadioButton);

		bgSelect = new ButtonGroup();
		bgSelect.add(rbPace);
		bgSelect.add(rbTime);
		bgSelect.add(rbDistance);
		rbPace.setSelected(true);

		panelMain.add(lblTime);
		panelMain.add(txtTime);
		panelMain.add(lblDistance);
		panelMain.add(txtDistance);
		panelMain.add(lblPace);
		panelMain.add(txtPace);

		panelMain.add(rbPace);
		panelMain.add(rbTime);
		panelMain.add(rbDistance);
		panelMain.add(btnCalc);
		panelMain.add(btnExit);

		this.add(panelMain);

		this.setTitle("Pace Calculator");
		this.setVisible(true);

	}

	void addCalcListener(ActionListener lForButton) {
		btnCalc.addActionListener(lForButton);

	}

	void addExitListener(ActionListener ExitButton) {
		btnExit.addActionListener(ExitButton);
	}

	int showExitMessage() {
		Object[] options = { "Yes", "No" };
		int userChoice = JOptionPane.showOptionDialog(this, "Are you sure you would like to exit PaceCalculator?",
				"Confirm please", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		return userChoice;
	}

	void showErrorMessage() {
		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(this, "Your input was wrong, please enter correct values in correct format",
				"Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);
	}

	String getTime() {
		return txtTime.getText();
	}

	String getPace() {

		return txtPace.getText();
	}

	String getDistance() {
		return txtDistance.getText();
	}

	void setTime(String time) {
		txtTime.setText(time);
	}

	void setDistance(String distance) {
		txtDistance.setText(distance);
	}

	void setPace(String pace) {
		txtPace.setText(pace);
	}

	int getCalcSelection() {
		int userCalcSelecton = 1;
		if (rbPace.isSelected()) {
			userCalcSelecton = 1;
		} else if (rbTime.isSelected()) {
			userCalcSelecton = 2;
		} else if (rbDistance.isSelected()) {
			userCalcSelecton = 3;
		}
		return userCalcSelecton;
	}

	class ListenerForRadioButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == rbPace) {
				txtPace.setEnabled(false);
				txtTime.setEnabled(true);
				txtDistance.setEnabled(true);
			} else if (e.getSource() == rbTime) {
				txtPace.setEnabled(true);
				txtTime.setEnabled(false);
				txtDistance.setEnabled(true);
			} else if (e.getSource() == rbDistance) {
				txtPace.setEnabled(true);
				txtTime.setEnabled(true);
				txtDistance.setEnabled(false);
			}
		}

	}
}
