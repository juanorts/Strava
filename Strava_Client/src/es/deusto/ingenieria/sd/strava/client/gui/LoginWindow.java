package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.*;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tEmail;
	private JPasswordField passwordField;

	public LoginWindow() {

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
		tEmail.setBounds(125, 84, 202, 26);
		pPrin.add(tEmail);
		tEmail.setColumns(10);

		JLabel lPass = new JLabel("Password");
		lPass.setBounds(125, 121, 61, 16);
		pPrin.add(lPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 147, 202, 26);
		pPrin.add(passwordField);
		
		JButton bShow = new JButton("Show");
		bShow.setBounds(337, 149, 89, 23);
		pPrin.add(bShow);
		
		JButton bHide = new JButton("Hide");
		bHide.setBounds(337, 149, 89, 23);
		pPrin.add(bHide);

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

		bShow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setEchoChar((char) 0);
				bShow.setVisible(false);
				bHide.setVisible(true);
			}
			
		});
		
		bHide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setEchoChar('*');
				bHide.setVisible(false);
				bShow.setVisible(true);
			}
			
		});
		
		bStrava.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || String.valueOf(passwordField.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = LoginController.getInstance().login(tEmail.getText(), String.valueOf(passwordField.getPassword()), "STRAVA");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow();
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
				if (tEmail.getText().isEmpty() || String.valueOf(passwordField.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = LoginController.getInstance().login(tEmail.getText(), String.valueOf(passwordField.getPassword()), "GOOGLE");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow();
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
				if (tEmail.getText().isEmpty() || String.valueOf(passwordField.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "You need to type an email and a password", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean login = LoginController.getInstance().login(tEmail.getText(), String.valueOf(passwordField.getPassword()), "FACEBOOK");
					if (login) {
						ChallengesWindow cw = new ChallengesWindow();
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
				RegisterWindow rw = new RegisterWindow();
				rw.setVisible(true);
			}

		});

	}

}
