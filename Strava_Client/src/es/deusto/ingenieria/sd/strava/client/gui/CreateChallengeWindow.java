package es.deusto.ingenieria.sd.strava.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.Color;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.strava.client.controller.StravaController;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class CreateChallengeWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfName;
	private JTextField tfTargetDistance;
	private JTextField tfTargetTime;

	public CreateChallengeWindow() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(550, 350);
		setTitle("Strava - Create new challenge");

		JLabel logoStrava = new JLabel("STRAVA");
		logoStrava.setLabelFor(this);
		logoStrava.setForeground(new Color(255, 128, 0));
		logoStrava.setFont(new Font("Arial", Font.BOLD, 40));
		logoStrava.setBounds(10, 0, 169, 65);
		panel.add(logoStrava);

		JLabel lCreateChallenge = new JLabel("Create Challenge");
		lCreateChallenge.setFont(new Font("Arial", Font.BOLD, 30));
		lCreateChallenge.setBounds(287, 18, 257, 37);
		panel.add(lCreateChallenge);

		JLabel lName = new JLabel("Name");
		lName.setFont(new Font("Arial", Font.BOLD, 15));
		lName.setBounds(42, 75, 77, 25);
		panel.add(lName);

		JLabel lStartDate = new JLabel("Start Date");
		lStartDate.setFont(new Font("Arial", Font.BOLD, 15));
		lStartDate.setBounds(42, 131, 94, 25);
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
		lSport.setBounds(267, 75, 77, 25);
		panel.add(lSport);

		tfName = new JTextField();
		tfName.setBounds(42, 99, 137, 19);
		panel.add(tfName);
		tfName.setColumns(10);

		JDateChooser dateChooserSD = new JDateChooser();
		dateChooserSD.setDateFormatString("dd/MM/yyyy");
		dateChooserSD.setBounds(42, 162, 137, 20);
		panel.add(dateChooserSD);
		
		JDateChooser dateChooserED = new JDateChooser();
		dateChooserED.setDateFormatString("dd/MM/yyyy");
		dateChooserED.setBounds(267, 162, 137, 20);
		panel.add(dateChooserED);

		tfTargetDistance = new JTextField();
		tfTargetDistance.setColumns(10);
		tfTargetDistance.setBounds(42, 216, 137, 19);
		panel.add(tfTargetDistance);

		tfTargetTime = new JTextField();
		tfTargetTime.setColumns(10);
		tfTargetTime.setBounds(267, 216, 137, 19);
		panel.add(tfTargetTime);

		JComboBox<String> cSport = new JComboBox<String>();
		cSport.setModel(new DefaultComboBoxModel<String>(new String[] { "CYCLING", "RUNNING", "BOTH" }));
		cSport.setBounds(267, 98, 137, 21);
		panel.add(cSport);

		JButton bCreate = new JButton("Create new challenge");
		bCreate.setBounds(42, 261, 169, 29);
		panel.add(bCreate);


		bCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tfName.getText().isEmpty() || dateChooserSD.getDate() == null || dateChooserED.getDate() == null
						|| tfTargetDistance.getText().isEmpty() || tfTargetTime.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"You need to to complete all the information. If you only want to set a target distance/time, type 0 in the other one",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else if (dateChooserSD.getDate().compareTo(dateChooserED.getDate())>=0) {
					JOptionPane.showMessageDialog(null, "The start date must be before the end date", "Error",
							JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						if (StravaController.getInstance().createChallenge(tfName.getText(), dateChooserSD.getDate(), dateChooserED.getDate(),
								Float.parseFloat(tfTargetDistance.getText()), Integer.parseInt(tfTargetTime.getText()),
								cSport.getSelectedItem().toString())) {
							dispose();
						}
					} catch (NumberFormatException | RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		});
	}
}
