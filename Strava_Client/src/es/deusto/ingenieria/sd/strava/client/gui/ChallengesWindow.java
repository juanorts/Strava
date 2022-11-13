package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ChallengesWindow extends JFrame {
	public ChallengesWindow() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 95, 319, 185);
		panel.add(scrollPane);
		
		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setFont(new Font("Arial", Font.BOLD, 40));
		lStrava.setForeground(new Color(255, 128, 0));
		lStrava.setBounds(10, 10, 170, 34);
		panel.add(lStrava);
		
		JLabel lActiveChallenges = new JLabel("Active Challenges");
		lActiveChallenges.setFont(new Font("Arial", Font.BOLD, 30));
		lActiveChallenges.setBounds(210, 14, 275, 34);
		panel.add(lActiveChallenges);
	}
}
