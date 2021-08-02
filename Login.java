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
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField UsernametxtField;
	private JPasswordField PasswordtxtField;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnection.connection();
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 364);
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

		        Login.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, -12, 292, 396);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		
		JLabel label = new JLabel("");
		
		JLabel lblX = new JLabel("X");							//Terminates program
		lblX.setBounds(556, 16, 13, 16);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(UIManager.getColor("Button.select"));
		contentPane.add(lblX);
		
//Insert Image
		
		label.setIcon(new ImageIcon(Login.class.getResource("/images/Screen Shot 2019-02-06 at 1.15.31 PM.png")));
		panel.add(label);	
		
//Labels
		
		JLabel lblUsername = new JLabel("Login");							
		lblUsername.setForeground(new Color(255, 102, 102));
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblUsername.setBounds(401, 26, 82, 50);
		contentPane.add(lblUsername);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(325, 175, 82, 16);
		contentPane.add(lblPassword_1);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setBounds(325, 117, 82, 16);
		contentPane.add(label_1);
		
//Text Fields
		
		UsernametxtField = new JTextField();
		UsernametxtField.setBounds(325, 137, 231, 26);
		contentPane.add(UsernametxtField);
		UsernametxtField.setColumns(10);
		
		PasswordtxtField = new JPasswordField();
		PasswordtxtField.setBounds(325, 192, 231, 26);
		PasswordtxtField.setColumns(10);
		contentPane.add(PasswordtxtField);
		
//Buttons
		
		JButton btnLogin = new JButton("Login");				//Goes back to Main Menu
		btnLogin.setBounds(450, 286, 95, 29);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DBConnection.login(UsernametxtField.getText(), PasswordtxtField.getText()))
				{
					dispose();
					MainMenu frame = new MainMenu();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}	
				else
					JOptionPane.showMessageDialog(null,"The username or password you entered is not correct. Please try again.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLogin.setForeground(UIManager.getColor("Button.foreground"));
		btnLogin.setBackground(Color.LIGHT_GRAY);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();										//Goes to Sign Up Page
				SignUp frame = new SignUp();
				frame.setUndecorated(true);
				frame.setVisible(true);	
			}
		});
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBackground(Color.LIGHT_GRAY);
		btnSignUp.setBounds(325, 286, 95, 29);
		contentPane.add(btnSignUp);
	}
}
