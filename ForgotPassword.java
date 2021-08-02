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

public class ForgotPassword extends Login {

	private JPanel contentPane;
	private JTextField UsernametxtField;
	private JTextField EmailtxtField;
	int xx, xy;
	private JTextField PhoneNotxtField;
	private JTextField AnswertxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 367);
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

		        ForgotPassword.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 429, 384);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setBounds(136, 17, 147, 34);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(255, 102, 102));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setForeground(UIManager.getColor("Button.highlight"));
		label_1.setBounds(23, 89, 82, 16);
		panel.add(label_1);
		
		UsernametxtField = new JTextField();
		UsernametxtField.setBounds(161, 84, 204, 26);
		panel.add(UsernametxtField);
		UsernametxtField.setColumns(10);
		
		EmailtxtField = new JTextField();
		EmailtxtField.setBounds(161, 122, 204, 26);
		panel.add(EmailtxtField);
		EmailtxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Email:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(23, 127, 82, 16);
		panel.add(lblPassword);
		
		JButton btnSignUp = new JButton("Cancel");
		btnSignUp.setBounds(91, 310, 95, 29);
		panel.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBackground(Color.BLACK);
		
		JButton btnLogin = new JButton("Next");
		btnLogin.setBounds(244, 310, 95, 29);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();										//Gets rid of 1st page
				Password frame = new Password();
				frame.setUndecorated(true);
				frame.setVisible(true);							//Calls 2nd page
			}
		});
		btnLogin.setForeground(UIManager.getColor("Button.foreground"));
		btnLogin.setBackground(Color.BLACK);
		
		PhoneNotxtField = new JTextField();
		PhoneNotxtField.setColumns(10);
		PhoneNotxtField.setBounds(161, 160, 204, 26);
		panel.add(PhoneNotxtField);
		
		JLabel lblConfirmPassword = new JLabel("Phone #:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(23, 165, 118, 21);
		panel.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Security Question:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(23, 204, 118, 16);
		panel.add(lblEmail);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(364, 17, 13, 16);
		panel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(UIManager.getColor("Button.select"));
		
		AnswertxtField = new JTextField();
		AnswertxtField.setColumns(10);
		AnswertxtField.setBounds(161, 238, 204, 26);
		panel.add(AnswertxtField);
		
		JLabel lblPhone = new JLabel("Answer");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(23, 243, 82, 16);
		panel.add(lblPhone);
		
		JComboBox SecurityComboBox = new JComboBox();
		SecurityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Whats your favorite food?", "High School mascot?", "Home town?", "Favorite color?", "Favorite actor/actress?", "What's your middle name?", "What's your mother's maiden name?", "Favorite car?"}));
		SecurityComboBox.setBounds(151, 200, 226, 20);
		panel.add(SecurityComboBox);
	}
	}

