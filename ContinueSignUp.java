import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ContinueSignUp extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField AnswertxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContinueSignUp frame = new ContinueSignUp();
					frame.setUndecorated(true);		//Gets rid of header
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContinueSignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 416);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {	//Can move page by press and drag
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
				 xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();

		        int y = e.getYOnScreen();

		        ContinueSignUp.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 367, 426);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(325, 22, 13, 16);
		panel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(UIManager.getColor("Button.select"));
		
//Labels
		
		JLabel lblUsername = new JLabel("Sign Up");
		lblUsername.setBounds(122, 22, 110, 34);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(255, 102, 102));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel lblEmail = new JLabel("Security Question:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(132, 77, 132, 16);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Answer:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(132, 177, 50, 16);
		panel.add(lblPhone);
		
		AnswertxtField = new JTextField();
		AnswertxtField.setColumns(10);
		AnswertxtField.setBounds(58, 204, 258, 26);
		panel.add(AnswertxtField);
		
		JComboBox SecurityComboBox = new JComboBox();
		SecurityComboBox.setMaximumRowCount(5);
		SecurityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Whats your favorite food?", "High School mascot?", "Home town?", "Favorite color?", "Favorite actor/actress?", "What's your middle name?", "What's your mother's maiden name?", "Favorite car?"}));
		SecurityComboBox.setBounds(58, 104, 258, 26);
		panel.add(SecurityComboBox);
		
		
//Buttons
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(35, 284, 95, 29);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(243, 284, 95, 29);
		panel.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(AnswertxtField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Fill in all information to continue.", "ERROR", JOptionPane.INFORMATION_MESSAGE);		//Calls 2nd page
				}
				else {
					Counselor.securityQuestion((String) SecurityComboBox.getSelectedItem(), AnswertxtField.getText());
					JOptionPane.showMessageDialog(null,"Thank you for signing up.", "CONFIRM", JOptionPane.INFORMATION_MESSAGE);	
					dispose();
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
			}
		});
		btnConfirm.setForeground(UIManager.getColor("Button.foreground"));
		btnConfirm.setBackground(Color.LIGHT_GRAY);
		
	}

	}

