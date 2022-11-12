package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class RegisterWindow extends JFrame {
	private JTextField tEmail;
	private JTextField tPassword;
	private JTextField tName;
	private JTextField tBirthDate;
	private JTextField tWeight;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public RegisterWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Strava - Register");
		getContentPane().setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		
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
		
		JLabel lblEmail = new JLabel("Email *");
		lblEmail.setBounds(146, 120, 61, 16);
		pMain.add(lblEmail);
		
		tEmail = new JTextField();
		tEmail.setColumns(10);
		tEmail.setBounds(146, 139, 202, 26);
		pMain.add(tEmail);
		
		JLabel lblPassword = new JLabel("Password **");
		lblPassword.setBounds(146, 177, 84, 16);
		pMain.add(lblPassword);
		
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
		
		JLabel lblNewLabel = new JLabel("Height");
		lblNewLabel.setBounds(146, 374, 61, 16);
		pMain.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(146, 402, 202, 26);
		pMain.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Maximum BPM");
		lblNewLabel_1.setBounds(146, 440, 104, 16);
		pMain.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 466, 202, 26);
		pMain.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rest BPM");
		lblNewLabel_2.setBounds(146, 504, 61, 16);
		pMain.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 532, 202, 26);
		pMain.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRegisterWithStrava = new JButton("Register with Strava");
		btnRegisterWithStrava.setBounds(6, 621, 154, 26);
		pMain.add(btnRegisterWithStrava);
		
		JButton btnRegisterWithGoogle = new JButton("Register with Google");
		btnRegisterWithGoogle.setBounds(153, 621, 161, 26);
		pMain.add(btnRegisterWithGoogle);
		
		JButton btnRegisterWithFacebook = new JButton("Register with Facebook");
		btnRegisterWithFacebook.setBounds(305, 621, 182, 26);
		pMain.add(btnRegisterWithFacebook);
		
		JLabel lblNewLabel_3 = new JLabel("* Field must be filled");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(146, 570, 202, 16);
		pMain.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("** Password is only necessary for Strava");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3_1.setBounds(109, 593, 283, 16);
		pMain.add(lblNewLabel_3_1);
	}
}