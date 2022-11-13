package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.*;

import es.deusto.ingenieria.sd.strava.client.controller.RegisterController;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow extends JDialog {
	private JTextField tEmail;
	private JTextField tPassword;
	private JTextField tName;
	private JTextField tBirthDate;
	private JTextField tWeight;
	private JTextField tHeight;
	private JTextField tMaxBPM;
	private JTextField tRestBPM;

	public RegisterWindow(RegisterController controller) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Strava - Register");
		getContentPane().setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setSize(490, 690);

		JPanel pMain = new JPanel();
		pMain.setBackground(SystemColor.window);
		getContentPane().add(pMain, BorderLayout.CENTER);
		pMain.setLayout(null);

		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setBounds(21, 6, 450, 57);
		pMain.add(lStrava);
		lStrava.setHorizontalAlignment(SwingConstants.CENTER);
		lStrava.setForeground(new Color(255, 137, 0));
		lStrava.setFont(new Font("Arial Black", Font.BOLD, 40));

		JLabel lName = new JLabel("Name *");
		lName.setBounds(146, 63, 61, 16);
		pMain.add(lName);

		tName = new JTextField();
		tName.setColumns(10);
		tName.setBounds(146, 82, 202, 26);
		pMain.add(tName);

		JLabel lEmail = new JLabel("Email *");
		lEmail.setBounds(146, 120, 61, 16);
		pMain.add(lEmail);

		tEmail = new JTextField();
		tEmail.setColumns(10);
		tEmail.setBounds(146, 139, 202, 26);
		pMain.add(tEmail);

		JLabel lPass = new JLabel("Password **");
		lPass.setBounds(146, 177, 84, 16);
		pMain.add(lPass);

		tPassword = new JTextField();
		tPassword.setColumns(10);
		tPassword.setBounds(146, 204, 202, 26);
		pMain.add(tPassword);

		JLabel lBirthDate = new JLabel("Birth Date *");
		lBirthDate.setBounds(146, 242, 74, 16);
		pMain.add(lBirthDate);

		tBirthDate = new JTextField();
		tBirthDate.setBounds(146, 270, 202, 26);
		pMain.add(tBirthDate);
		tBirthDate.setColumns(10);

		JLabel lWeight = new JLabel("Weight");
		lWeight.setBounds(146, 308, 61, 16);
		pMain.add(lWeight);

		tWeight = new JTextField();
		tWeight.setBounds(146, 336, 202, 26);
		pMain.add(tWeight);
		tWeight.setColumns(10);

		JLabel lHeight = new JLabel("Height");
		lHeight.setBounds(146, 374, 61, 16);
		pMain.add(lHeight);

		tHeight = new JTextField();
		tHeight.setBounds(146, 402, 202, 26);
		pMain.add(tHeight);
		tHeight.setColumns(10);

		JLabel lMaxBPM = new JLabel("Maximum BPM");
		lMaxBPM.setBounds(146, 440, 104, 16);
		pMain.add(lMaxBPM);

		tMaxBPM = new JTextField();
		tMaxBPM.setBounds(146, 466, 202, 26);
		pMain.add(tMaxBPM);
		tMaxBPM.setColumns(10);

		JLabel lRestBPM = new JLabel("Rest BPM");
		lRestBPM.setBounds(146, 504, 61, 16);
		pMain.add(lRestBPM);

		tRestBPM = new JTextField();
		tRestBPM.setBounds(146, 532, 202, 26);
		pMain.add(tRestBPM);
		tRestBPM.setColumns(10);

		JButton bStrava = new JButton("Register with Strava");
		bStrava.setBounds(6, 621, 154, 26);
		pMain.add(bStrava);

		JButton bGoogle = new JButton("Register with Google");
		bGoogle.setBounds(153, 621, 161, 26);
		pMain.add(bGoogle);

		JButton bFB = new JButton("Register with Facebook");
		bFB.setBounds(305, 621, 182, 26);
		pMain.add(bFB);

		JLabel lMessage1 = new JLabel("* Field must be filled");
		lMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		lMessage1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lMessage1.setBounds(146, 570, 202, 16);
		pMain.add(lMessage1);

		JLabel lMessage2 = new JLabel("** Password is only necessary for Strava");
		lMessage2.setHorizontalAlignment(SwingConstants.CENTER);
		lMessage2.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lMessage2.setBounds(109, 593, 283, 16);
		pMain.add(lMessage2);

		// Actions

		bStrava.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tPassword.getText().isEmpty() || tName.getText().isEmpty()
						|| tBirthDate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type your email, password, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {

				}
			}

		});

		bGoogle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tName.getText().isEmpty() || tBirthDate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type your email, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {

				}
			}

		});

		bFB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tName.getText().isEmpty() || tBirthDate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type your email, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {

				}
			}

		});

	}
}
