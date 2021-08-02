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
import javax.swing.JOptionPane;

import java.awt.Canvas;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

public class ProfileUpdateSave extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField NametxtField;
	private JTextField IDtxtField;
	private JTextField GradeLeveltxtField;
	private JTextField GendertxtField;
	private JTextField EmailtxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileUpdateSave frame = new ProfileUpdateSave();
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
	public ProfileUpdateSave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 439);
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

		        ProfileUpdateSave.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(174, -11, 714, 507);
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
		
//Labels
		
		JLabel lblNewLabel = new JLabel("Profiles");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel.setBounds(214, 37, 104, 39);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(UIManager.getColor("Button.highlight"));
		lblName.setBounds(116, 112, 61, 16);
		panel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(116, 154, 61, 16);
		panel.add(lblNewLabel_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Would you like to save these changes?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {

				dispose();
				Profiles frame = new Profiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
			}
		});
		btnSave.setBounds(214, 372, 117, 29);
		panel.add(btnSave);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setForeground(Color.WHITE);
		lblGradeLevel.setBounds(116, 192, 83, 16);
		panel.add(lblGradeLevel);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(116, 230, 61, 16);
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(116, 268, 61, 16);
		panel.add(lblEmail);

//Text Fields
		
		NametxtField = new JTextField();
		NametxtField.setEditable(true);
		NametxtField.setBounds(237, 107, 175, 26);
		panel.add(NametxtField);
		NametxtField.setColumns(10);
		
		IDtxtField = new JTextField();
		IDtxtField.setEditable(true);
		IDtxtField.setBounds(237, 149, 175, 26);
		panel.add(IDtxtField);
		IDtxtField.setColumns(10);
		
		EmailtxtField = new JTextField();
		EmailtxtField.setEditable(true);
		EmailtxtField.setBounds(237, 263, 175, 26);
		panel.add(EmailtxtField);
		EmailtxtField.setColumns(10);
		
		GradeLeveltxtField = new JTextField();
		GradeLeveltxtField.setEditable(true);
		GradeLeveltxtField.setBounds(237, 187, 175, 26);
		panel.add(GradeLeveltxtField);
		GradeLeveltxtField.setColumns(10);
		
		GendertxtField = new JTextField();
		GendertxtField.setEditable(true);
		GendertxtField.setColumns(10);
		GendertxtField.setBounds(237, 225, 175, 26);
		panel.add(GendertxtField);
		
//Update and Delete buttons
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NametxtField.setEditable(true);
				IDtxtField.setEditable(true);
				EmailtxtField.setEditable(true);
				GradeLeveltxtField.setEditable(true);
				GendertxtField.setEditable(true);
			
			}
		});
		btnUpdate.setBounds(365, 372, 117, 29);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this profile??", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {
				JOptionPane.showMessageDialog(null,"Profile has been deleted.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				
//SQL delete code
				
				dispose();
				ViewProfiles frame = new ViewProfiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
				}
			}
		});
		btnDelete.setBounds(49, 372, 117, 29);
		panel.add(btnDelete);
		
//Side Menu
		
		JLabel lblNewStudent = new JLabel("New Student");
		lblNewStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				NewStudent frame = new NewStudent();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblNewStudent.setBounds(45, 180, 80, 16);
		contentPane.add(lblNewStudent);
		
		JLabel lblNewTeacher = new JLabel("New Teacher");
		lblNewTeacher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				NewTeacher frame = new NewTeacher();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblNewTeacher.setBounds(45, 135, 80, 16);
		contentPane.add(lblNewTeacher);
		
		JLabel lblViewProfiles = new JLabel("View Profiles");
		lblViewProfiles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ViewProfiles frame = new ViewProfiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblViewProfiles.setBounds(45, 226, 85, 16);
		contentPane.add(lblViewProfiles);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainMenu frame = new MainMenu();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblHome.setBounds(66, 44, 44, 16);
		contentPane.add(lblHome);
		
		JLabel lbViewSchedules = new JLabel(" View Schedules");
		lbViewSchedules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ViewSchedules frame = new ViewSchedules();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lbViewSchedules.setBounds(34, 274, 107, 16);
		contentPane.add(lbViewSchedules);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login frame = new Login();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblLogout.setBounds(66, 320, 44, 16);
		contentPane.add(lblLogout);
		
		JLabel lblManageClasses = new JLabel("Manage Classes");
		lblManageClasses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				ClassesChoose frame = new ClassesChoose();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		lblManageClasses.setBounds(34, 90, 107, 16);
		contentPane.add(lblManageClasses);
	}
	}

