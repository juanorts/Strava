package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CreateChallengeWindow extends JFrame {
	private JTextField tfName;
	private JTextField tfStartDate;
	private JTextField tfEndDate;
	private JTextField tfTargetDistance;
	private JTextField tfTargetTime;
	public CreateChallengeWindow() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel logoStrava = new JLabel("STRAVA");
		logoStrava.setLabelFor(this);
		logoStrava.setForeground(new Color(255, 128, 0));
		logoStrava.setFont(new Font("Arial", Font.BOLD, 40));
		logoStrava.setBounds(10, 0, 169, 65);
		panel.add(logoStrava);
		
		JLabel lCreateChallenge = new JLabel("Create Challenge");
		lCreateChallenge.setFont(new Font("Arial", Font.BOLD, 30));
		lCreateChallenge.setBounds(208, 18, 257, 37);
		panel.add(lCreateChallenge);
		
		JLabel lName = new JLabel("Name");
		lName.setFont(new Font("Arial", Font.BOLD, 15));
		lName.setBounds(42, 75, 77, 25);
		panel.add(lName);
		
		JLabel lStartDate = new JLabel("Start Date");
		lStartDate.setFont(new Font("Arial", Font.BOLD, 15));
		lStartDate.setBounds(42, 131, 77, 25);
		panel.add(lStartDate);
		
		JLabel lEndDate = new JLabel("End Date");
		lEndDate.setFont(new Font("Arial", Font.BOLD, 15));
		lEndDate.setBounds(267, 131, 77, 25);
		panel.add(lEndDate);
		
		JLabel lTargetDistance = new JLabel("Target Distance");
		lTargetDistance.setFont(new Font("Arial", Font.BOLD, 15));
		lTargetDistance.setBounds(42, 193, 118, 25);
		panel.add(lTargetDistance);
		
		JLabel lTargetTime = new JLabel("Target Time");
		lTargetTime.setFont(new Font("Arial", Font.BOLD, 15));
		lTargetTime.setBounds(267, 193, 118, 25);
		panel.add(lTargetTime);
		
		JLabel lSport = new JLabel("Sport");
		lSport.setFont(new Font("Arial", Font.BOLD, 15));
		lSport.setBounds(42, 261, 77, 25);
		panel.add(lSport);
		
		tfName = new JTextField();
		tfName.setBounds(42, 99, 137, 19);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfStartDate = new JTextField();
		tfStartDate.setColumns(10);
		tfStartDate.setBounds(42, 154, 137, 19);
		panel.add(tfStartDate);
		
		tfEndDate = new JTextField();
		tfEndDate.setColumns(10);
		tfEndDate.setBounds(267, 154, 137, 19);
		panel.add(tfEndDate);
		
		tfTargetDistance = new JTextField();
		tfTargetDistance.setColumns(10);
		tfTargetDistance.setBounds(42, 216, 137, 19);
		panel.add(tfTargetDistance);
		
		tfTargetTime = new JTextField();
		tfTargetTime.setColumns(10);
		tfTargetTime.setBounds(267, 216, 137, 19);
		panel.add(tfTargetTime);
		
		JComboBox cSport = new JComboBox();
		cSport.setBounds(42, 288, 137, 21);
		panel.add(cSport);
	}
}
