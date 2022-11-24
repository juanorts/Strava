package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.*;

import es.deusto.ingenieria.sd.strava.client.controller.RegisterController;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import com.toedter.calendar.JDateChooser;

public class RegisterWindow extends JDialog {
	private static final long serialVersionUID = 1L;
	private JTextField tEmail;
	private JTextField tName;
	private JPasswordField passwordField;
	private JTextField tWeight;
	private JTextField tHeight;
	private JTextField tMaxBPM;
	private JTextField tRestBPM;

	public RegisterWindow() {
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
		tEmail.setBounds(146, 140, 202, 26);
		pMain.add(tEmail);

		JLabel lPass = new JLabel("Password **");
		lPass.setBounds(146, 177, 84, 16);
		pMain.add(lPass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(146, 205, 202, 26);
		pMain.add(passwordField);
		
		JButton bShow = new JButton("Show");
		bShow.setBounds(358, 207, 89, 23);
		pMain.add(bShow);
		
		JButton bHide = new JButton("Hide");
		bHide.setBounds(358, 207, 89, 23);
		bHide.setVisible(false);
		pMain.add(bHide);

		JLabel lBirthDate = new JLabel("Birth Date *");
		lBirthDate.setBounds(146, 242, 202, 16);
		pMain.add(lBirthDate);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(146, 269, 202, 20);
		pMain.add(dateChooser);

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
				if (tEmail.getText().isEmpty() || String.valueOf(passwordField.getPassword()).equals("") || tName.getText().isEmpty()
						|| dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "You need to type your email, password, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						RegisterController.getInstance().register(tEmail.getText(), String.valueOf(passwordField.getPassword()), tName.getText(), dateChooser.getDate(),  Float.parseFloat("0" + tWeight.getText()), Integer.parseInt("0" + tHeight.getText()), Integer.parseInt("0" + tMaxBPM.getText()), Integer.parseInt("0" + tRestBPM.getText()), "STRAVA");
						dispose();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

		
		bGoogle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tName.getText().isEmpty() || dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "You need to type your email, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
				        RegisterController.getInstance().register(tEmail.getText(), String.valueOf(passwordField.getPassword()), tName.getText(), dateChooser.getDate(),  Float.parseFloat("0" + tWeight.getText()), Integer.parseInt("0" + tHeight.getText()), Integer.parseInt("0" + tMaxBPM.getText()), Integer.parseInt("0" + tRestBPM.getText()), "GOOGLE");
				        dispose();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

		bFB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tEmail.getText().isEmpty() || tName.getText().isEmpty() || dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "You need to type your email, name and birthdate",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						RegisterController.getInstance().register(tEmail.getText(), String.valueOf(passwordField.getPassword()), tName.getText(), dateChooser.getDate(),  Float.parseFloat("0" + tWeight.getText()), Integer.parseInt("0" + tHeight.getText()), Integer.parseInt("0" + tMaxBPM.getText()), Integer.parseInt("0" + tRestBPM.getText()), "FACEBOOK");
						dispose();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});

	}
}
