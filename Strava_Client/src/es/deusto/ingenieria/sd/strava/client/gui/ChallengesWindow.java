package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

import es.deusto.ingenieria.sd.strava.client.controller.StravaController;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;

public class ChallengesWindow extends JFrame {
	public ChallengesWindow(StravaController sController) {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(520, 390);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(90, 95, 338, 214);
		panel.add(scrollPane);
		
		JPanel pChallenges = new JPanel();
		scrollPane.add(pChallenges);
		
		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setFont(new Font("Arial", Font.BOLD, 40));
		lStrava.setForeground(new Color(255, 128, 0));
		lStrava.setBounds(10, 10, 170, 34);
		panel.add(lStrava);
		
		JLabel lActiveChallenges = new JLabel("Active Challenges");
		lActiveChallenges.setFont(new Font("Arial", Font.BOLD, 30));
		lActiveChallenges.setBounds(210, 14, 275, 34);
		panel.add(lActiveChallenges);
		
		JButton bRefresh = new JButton("Refresh list");
		bRefresh.setBounds(37, 321, 117, 29);
		panel.add(bRefresh);
		
		JButton btnNewButton_1 = new JButton("Create new challenge");
		btnNewButton_1.setBounds(157, 321, 161, 29);
		panel.add(btnNewButton_1);
		
		JButton bC = new JButton("Create training session");
		bC.setBounds(312, 321, 170, 29);
		panel.add(bC);
		
		JButton bLogout = new JButton("Log Out");
		bLogout.setBounds(10, 54, 117, 29);
		panel.add(bLogout);
		
		bRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//	Get all active challenges
				try {
					int rows = sController.getActiveChallenges().size();
					System.out.println(rows);
					pChallenges.setLayout(new FlowLayout());
					for(ChallengeDTO c : sController.getActiveChallenges()) {
						System.out.println(c.getName());
						JPanel pChallenge = new JPanel();
						JLabel lChallenge = new JLabel();
						pChallenge.add(lChallenge);
						pChallenges.add(pChallenge);
					}
					scrollPane.add(pChallenges);
					pChallenges.setVisible(true);
					scrollPane.setVisible(true);
					repaint();
					revalidate();
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		
	}
}
