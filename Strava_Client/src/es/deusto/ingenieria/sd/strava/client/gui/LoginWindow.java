package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.*;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.RegisterController;
import es.deusto.ingenieria.sd.strava.client.controller.StravaController;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
	private JTextField tEmail;
	private JTextField tPass;

	public LoginWindow(LoginController lController, RegisterController rController, StravaController sController) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Strava - Login");
		setSize(450, 310);

		JPanel pPrin = new JPanel();
		pPrin.setBackground(SystemColor.window);
		getContentPane().add(pPrin, BorderLayout.CENTER);
		pPrin.setLayout(null);

		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setFont(new Font("Arial Black", Font.BOLD, 40));
		lStrava.setHorizontalAlignment(SwingConstants.CENTER);
		lStrava.setForeground(new Color(255, 137, 0));
		lStrava.setBounds(125, 6, 202, 46);
		pPrin.add(lStrava);

		JLabel lEmail = new JLabel("Email");
		lEmail.setBounds(125, 64, 61, 16);
		pPrin.add(lEmail);

		tEmail = new JTextField();
		tEmail.setBounds(125, 83, 202, 26);
		pPrin.add(tEmail);
		tEmail.setColumns(10);

		JLabel lPass = new JLabel("Password");
		lPass.setBounds(125, 121, 61, 16);
		pPrin.add(lPass);

		tPass = new JTextField();
		tPass.setBounds(125, 148, 202, 26);
		pPrin.add(tPass);
		tPass.setColumns(10);

		JButton bStrava = new JButton("Login with Strava");
		bStrava.setBounds(6, 204, 135, 26);
		pPrin.add(bStrava);

		JButton bGoogle = new JButton("Login with Google");
		bGoogle.setBounds(145, 204, 144, 26);
		pPrin.add(bGoogle);

		JButton bFB = new JButton("Login with Facebook");
		bFB.setBounds(290, 204, 154, 26);
		pPrin.add(bFB);

		JLabel lRegister = new JLabel("No account?");
		lRegister.setBounds(125, 242, 85, 16);
		pPrin.add(lRegister);

		JButton bRegister = new JButton("Register");
		bRegister.setForeground(new Color(41, 118, 239));
		bRegister.setBounds(210, 237, 117, 29);
		pPrin.add(bRegister);

		// Actions

		bStrava.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tPass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = lController.login(tEmail.getText(), tPass.getText(), "STRAVA");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow(sController);
						cw.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect credentials", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		bGoogle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tPass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = lController.login(tEmail.getText(), tPass.getText(), "GOOGLE");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow(sController);
						cw.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect credentials", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		bFB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tPass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = lController.login(tEmail.getText(), tPass.getText(), "FACEBOOK");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow(sController);
						cw.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect credentials", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				RegisterWindow rw = new RegisterWindow(rController);
				rw.setVisible(true);
			}

		});

	}

}
