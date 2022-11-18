package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JButton;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import javax.swing.ScrollPaneConstants;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.controller.StravaController;
import es.deusto.ingenieria.sd.strava.server.data.dto.ChallengeDTO;

public class ChallengesWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	public ChallengesWindow() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(520, 390);
		
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
		
		JButton bC = new JButton("Create new challenge");
		bC.setBounds(157, 321, 161, 29);
		panel.add(bC);
		
		JButton bTS = new JButton("Create training session");
		bTS.setBounds(312, 321, 170, 29);
		panel.add(bTS);
		
		JButton bLogout = new JButton("Log Out");
		bLogout.setBounds(10, 54, 117, 29);
		panel.add(bLogout);
		
		JPanel pChallenges = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane(pChallenges);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(37, 95, 448, 214);
		panel.add(scrollPane);
		
		bRefresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//	Get all active challenges
				try {
					
					int rows = StravaController.getInstance().getActiveChallenges().size();
					pChallenges.setLayout(new GridLayout(rows, 1));
					pChallenges.removeAll();
					for(ChallengeDTO c : StravaController.getInstance().getActiveChallenges()) {
						JPanel pChallenge = new JPanel(new FlowLayout());
						JLabel lChallenge = new JLabel(c.getName() + " - " + c.getSport());
						JButton bAccept = new JButton("Accept challenge");
						bAccept.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent arg0) {
								try {
									StravaController.getInstance().acceptChallenge(c.getName());
								} catch (RemoteException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						});
						pChallenge.add(lChallenge);
						pChallenge.add(bAccept);
						pChallenges.add(pChallenge);
					}
					scrollPane.setVisible(true);
					scrollPane.repaint();
					scrollPane.revalidate();
					
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		bLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginController.getInstance().logout();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
			
		});
		
		bC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CreateChallengeWindow ccw = new CreateChallengeWindow();
				ccw.setVisible(true);
			}
			
		});
		
		bTS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CreateTrainingSessionWindow cts = new CreateTrainingSessionWindow();
				cts.setVisible(true);
			}
			
		});
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stud
				try {
					LoginController.getInstance().logout();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
	}
}
