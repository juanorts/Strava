package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CreateTrainingSessionWindow extends JFrame{
	private JTextField tfTitle;
	private JTextField tfStartDate;
	private JTextField tfDistance;
	private JTextField tfStartTime;
	private JTextField tfDistance_1;
	public CreateTrainingSessionWindow() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setForeground(new Color(255, 128, 0));
		lStrava.setFont(new Font("Arial", Font.BOLD, 40));
		lStrava.setBounds(10, 10, 180, 55);
		panel.add(lStrava);
		
		JLabel lCreateTrainingSession = new JLabel("Create Training Session");
		lCreateTrainingSession.setFont(new Font("Arial", Font.BOLD, 30));
		lCreateTrainingSession.setForeground(new Color(0, 0, 0));
		lCreateTrainingSession.setBounds(187, 23, 385, 36);
		panel.add(lCreateTrainingSession);
		
		JLabel lStartDate = new JLabel("Title");
		lStartDate.setFont(new Font("Arial", Font.BOLD, 15));
		lStartDate.setBounds(47, 97, 72, 23);
		panel.add(lStartDate);
		
		JLabel lStartTime = new JLabel("Start Date");
		lStartTime.setFont(new Font("Arial", Font.BOLD, 15));
		lStartTime.setBounds(47, 162, 87, 23);
		panel.add(lStartTime);
		
		JLabel lDistance = new JLabel("Distance");
		lDistance.setFont(new Font("Arial", Font.BOLD, 15));
		lDistance.setBounds(47, 222, 72, 23);
		panel.add(lDistance);
		
		JLabel lDuration = new JLabel("Duration");
		lDuration.setFont(new Font("Arial", Font.BOLD, 15));
		lDuration.setBounds(289, 222, 72, 23);
		panel.add(lDuration);
		
		JLabel lSport = new JLabel("Sport");
		lSport.setFont(new Font("Arial", Font.BOLD, 15));
		lSport.setBounds(47, 285, 72, 23);
		panel.add(lSport);
		
		JLabel lStartTime_1 = new JLabel("Start Time");
		lStartTime_1.setFont(new Font("Arial", Font.BOLD, 15));
		lStartTime_1.setBounds(288, 162, 93, 23);
		panel.add(lStartTime_1);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(47, 122, 125, 19);
		panel.add(tfTitle);
		tfTitle.setColumns(10);
		
		tfStartDate = new JTextField();
		tfStartDate.setColumns(10);
		tfStartDate.setBounds(47, 183, 125, 19);
		panel.add(tfStartDate);
		
		tfDistance = new JTextField();
		tfDistance.setColumns(10);
		tfDistance.setBounds(47, 243, 125, 19);
		panel.add(tfDistance);
		
		tfStartTime = new JTextField();
		tfStartTime.setColumns(10);
		tfStartTime.setBounds(289, 183, 125, 19);
		panel.add(tfStartTime);
		
		tfDistance_1 = new JTextField();
		tfDistance_1.setColumns(10);
		tfDistance_1.setBounds(289, 243, 125, 19);
		panel.add(tfDistance_1);
		
		JComboBox cSport = new JComboBox();
		cSport.setBounds(47, 318, 125, 21);
		panel.add(cSport);
	}

}
