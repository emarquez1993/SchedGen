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
import javax.swing.JMenuItem;
import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class UserPassConfirmation extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField UsernametxtField;
	private JTextField PasswordtxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPassConfirmation frame = new UserPassConfirmation();
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
	public UserPassConfirmation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 241);
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

		        UserPassConfirmation.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-134, 0, 630, 507);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(481, 21, 13, 16);
		panel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(UIManager.getColor("Button.select"));
		
		JLabel lblDeleteThisProfile = new JLabel("Delete This Profile");
		lblDeleteThisProfile.setForeground(UIManager.getColor("Button.select"));
		lblDeleteThisProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblDeleteThisProfile.setBounds(212, 21, 217, 38);
		panel.add(lblDeleteThisProfile);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(UIManager.getColor("CheckBoxMenuItem.background"));
		lblUsername.setBounds(178, 81, 91, 16);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(UIManager.getColor("CheckBoxMenuItem.background"));
		lblPassword.setBounds(178, 122, 77, 16);
		panel.add(lblPassword);
		
		JButton Confirmbtn = new JButton("Confirm");
		Confirmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Profiles frame = new Profiles();
				frame.dispose();
				ViewProfiles again = new ViewProfiles();
				again.setUndecorated(true);
				again.setVisible(true);
				
			}
		});
		Confirmbtn.setBounds(355, 171, 117, 29);
		panel.add(Confirmbtn);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancelbtn.setBounds(178, 171, 117, 29);
		panel.add(Cancelbtn);
		
		UsernametxtField = new JTextField();
		UsernametxtField.setBounds(299, 76, 177, 26);
		panel.add(UsernametxtField);
		UsernametxtField.setColumns(10);
		
		PasswordtxtField = new JTextField();
		PasswordtxtField.setBounds(299, 117, 177, 26);
		panel.add(PasswordtxtField);
		PasswordtxtField.setColumns(10);
	}
	}

