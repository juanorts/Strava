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
import java.time.LocalTime;
import java.awt.Color;
import javax.swing.JTextField;

import es.deusto.ingenieria.sd.strava.client.controller.StravaController;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class CreateTrainingSessionWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField tfTitle;
	private JTextField tfDistance;
	private JTextField tfStartTime;
	private JTextField tfDuration;

	public CreateTrainingSessionWindow() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setSize(550, 350);
		setTitle("Strava - Create new training session");

		JLabel lStrava = new JLabel("STRAVA");
		lStrava.setForeground(new Color(255, 128, 0));
		lStrava.setFont(new Font("Arial", Font.BOLD, 40));
		lStrava.setBounds(10, 10, 180, 55);
		panel.add(lStrava);

		JLabel lCreateTrainingSession = new JLabel("Create Training Session");
		lCreateTrainingSession.setHorizontalAlignment(SwingConstants.RIGHT);
		lCreateTrainingSession.setFont(new Font("Arial", Font.BOLD, 30));
		lCreateTrainingSession.setForeground(new Color(0, 0, 0));
		lCreateTrainingSession.setBounds(187, 23, 357, 36);
		panel.add(lCreateTrainingSession);

		JLabel lStartDate = new JLabel("Title");
		lStartDate.setFont(new Font("Arial", Font.BOLD, 15));
		lStartDate.setBounds(47, 97, 72, 23);
		panel.add(lStartDate);

		JLabel lStartTime = new JLabel("Start Date *");
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
		lSport.setBounds(289, 97, 72, 23);
		panel.add(lSport);

		JLabel lStartTime_1 = new JLabel("Start Time *");
		lStartTime_1.setFont(new Font("Arial", Font.BOLD, 15));
		lStartTime_1.setBounds(288, 162, 93, 23);
		panel.add(lStartTime_1);

		tfTitle = new JTextField();
		tfTitle.setBounds(47, 122, 125, 19);
		panel.add(tfTitle);
		tfTitle.setColumns(10);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(47, 183, 125, 20);
		panel.add(dateChooser);

		tfDistance = new JTextField();
		tfDistance.setColumns(10);
		tfDistance.setBounds(47, 243, 125, 19);
		panel.add(tfDistance);

		tfStartTime = new JTextField();
		tfStartTime.setColumns(10);
		tfStartTime.setBounds(289, 183, 125, 19);
		panel.add(tfStartTime);

		tfDuration = new JTextField();
		tfDuration.setColumns(10);
		tfDuration.setBounds(289, 243, 125, 19);
		panel.add(tfDuration);

		JComboBox<String> cSport = new JComboBox<String>();
		cSport.setModel(new DefaultComboBoxModel<String>(new String[] { "CYCLING", "RUNNING", "BOTH" }));
		cSport.setBounds(289, 123, 125, 21);
		panel.add(cSport);

		JButton bCreate = new JButton("Create training session");
		bCreate.setBounds(47, 287, 180, 29);
		panel.add(bCreate);
		
		bCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tfDistance.getText().isEmpty() || tfDuration.getText().isEmpty() || dateChooser.getDate() == null
						|| tfTitle.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to to complete all the information.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if (StravaController.getInstance().createTrainingSession(tfTitle.getText(), cSport.getSelectedItem().toString(),
								Float.parseFloat(tfDistance.getText()), dateChooser.getDate(), Integer.parseInt(tfDuration.getText()),
								LocalTime.parse(tfStartTime.getText()))) {
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
