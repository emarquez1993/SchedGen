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
import javax.swing.JPasswordField;

public class SignUp extends Login {

	private JPanel contentPane;
	private JTextField usernametxtField;
	private JPasswordField PasswordtxtField;
	int xx, xy;
	private JPasswordField ConfirmPasswordtxtField;
	private JTextField EmailtxtField;
	private JTextField PhoneNotxtField;
	private JTextField fNameTextBox;
	private JTextField lNameTextBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 367);
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

		        SignUp.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 367, 384);
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
		lblUsername.setBounds(120, 6, 110, 34);
		panel.add(lblUsername);
		lblUsername.setForeground(new Color(255, 102, 102));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setForeground(UIManager.getColor("Button.highlight"));
		label_1.setBounds(23, 130, 82, 16);
		panel.add(label_1);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(23, 167, 82, 16);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setBounds(23, 202, 118, 21);
		panel.add(lblConfirmPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(23, 241, 82, 16);
		panel.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone #:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(23, 278, 82, 16);
		panel.add(lblPhone);
		
//Text fields
		
		usernametxtField = new JTextField();
		usernametxtField.setBounds(151, 125, 204, 26);
		panel.add(usernametxtField);
		usernametxtField.setColumns(10);
		
		PasswordtxtField = new JPasswordField();
		PasswordtxtField.setBounds(151, 162, 204, 26);
		panel.add(PasswordtxtField);
		PasswordtxtField.setColumns(10);
		
		ConfirmPasswordtxtField = new JPasswordField();
		ConfirmPasswordtxtField.setColumns(10);
		ConfirmPasswordtxtField.setBounds(151, 199, 204, 26);
		panel.add(ConfirmPasswordtxtField);
		
		EmailtxtField = new JTextField();
		EmailtxtField.setColumns(10);
		EmailtxtField.setBounds(151, 236, 204, 26);
		panel.add(EmailtxtField);
		
		PhoneNotxtField = new JTextField();
		PhoneNotxtField.setColumns(10);
		PhoneNotxtField.setBounds(151, 273, 204, 26);
		panel.add(PhoneNotxtField);
		
//Buttons
		
		JButton btnSignUp = new JButton("Cancel");
		btnSignUp.setBounds(60, 310, 95, 29);
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
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		
		JButton btnLogin = new JButton("Next");
		btnLogin.setBounds(221, 310, 95, 29);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PasswordtxtField.getText().equals(ConfirmPasswordtxtField.getText()))
					if(usernametxtField.getText().equals("") || lNameTextBox.getText().equals("") || fNameTextBox.getText().equals("") || PasswordtxtField.getText().equals("") || ConfirmPasswordtxtField.getText().equals("") 
						|| EmailtxtField.getText().equals("") || PhoneNotxtField.getText().equals("")){ 
						 JOptionPane.showMessageDialog(null,"Fill in all information to continue.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					if(DBConnection.uniqueCouUser(usernametxtField.getText()))
					{
						JOptionPane.showMessageDialog(null,"The username you entered is already taken. Please enter a different username.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						Counselor.CreateCounselor(usernametxtField.getText(), fNameTextBox.getText(), lNameTextBox.getText(), EmailtxtField.getText(), PhoneNotxtField.getText(), ConfirmPasswordtxtField.getText());
						dispose();										//Gets rid of current page
						ContinueSignUp frame = new ContinueSignUp();
						frame.setUndecorated(true);
						frame.setVisible(true);	//Displays next page
					}
						 
					}
				else
					JOptionPane.showMessageDialog(null,"The password you entered in the Confirm Password text field does not match your password entered in the previous text field. Please try again.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLogin.setForeground(UIManager.getColor("Button.foreground"));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(23, 54, 82, 16);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(23, 93, 82, 16);
		panel.add(lblLastName);
		
		fNameTextBox = new JTextField();
		fNameTextBox.setColumns(10);
		fNameTextBox.setBounds(151, 49, 204, 26);
		panel.add(fNameTextBox);
		
		lNameTextBox = new JTextField();
		lNameTextBox.setColumns(10);
		lNameTextBox.setBounds(151, 88, 204, 26);
		panel.add(lNameTextBox);
		
	}
}

