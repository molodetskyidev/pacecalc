package pacecalc.pacecalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

	public PaceCalcUI() {

		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMain = new JPanel();

		btnCalc = new JButton("Calculate");

		btnExit = new JButton("Exit");

		lblPace = new JLabel("Enter pace in format mm:ss");
		lblTime = new JLabel("Enter time in format hh:mm:ss");
		lblDistance = new JLabel("Enter distance in meters(should be integer value");

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
		ListenerForExitButton lForExitButton = new ListenerForExitButton();
		btnExit.addActionListener(lForExitButton);
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
		btnExit.addActionListener(lForButton);

	}

	class ListenerForExitButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnExit) {
				System.exit(0);
			}
		}

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