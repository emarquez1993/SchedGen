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
import javax.swing.SwingConstants;

public class TeacherSchedule extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSchedule frame = new TeacherSchedule();
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
	public TeacherSchedule() {
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

		        TeacherSchedule.this.setLocation(x - xx, y - xy);  
				
			}
		});
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(174, 0, 714, 507);
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
		
		JLabel Name = new JLabel("Schedule");
		Name.setBackground(UIManager.getColor("Button.darkShadow"));
		Name.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		Name.setForeground(UIManager.getColor("Button.select"));
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBounds(64, 21, 405, 52);
		panel.add(Name);
		
		JLabel label = new JLabel("1.");
		label.setForeground(UIManager.getColor("Button.highlight"));
		label.setBounds(106, 85, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(106, 113, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(106, 141, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(106, 169, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(106, 197, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("6.");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(106, 225, 61, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("7.");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(106, 253, 61, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("8.");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(106, 281, 61, 16);
		panel.add(label_7);
		
//ComboBoxes
//The "N/A", "Conference", "Calculus" etc.. is just a test to see if the update button works. IT WORKS!
//You can replace those with real
		
		JTextField OnecomboBox = new JTextField();
		OnecomboBox.setText(Teacher.getFirstPeriod(ViewSchedules.teacherId));
		OnecomboBox.setEditable(false);
		OnecomboBox.setBounds(176, 81, 233, 27);
		panel.add(OnecomboBox);
		
		JTextField TwocomboBox = new JTextField();
		TwocomboBox.setText(Teacher.getSecondPeriod(ViewSchedules.teacherId));
		TwocomboBox.setEditable(false);
		TwocomboBox.setBounds(176, 109, 233, 27);
		panel.add(TwocomboBox);
		
		JTextField ThreecomboBox = new JTextField();
		ThreecomboBox.setText(Teacher.getThirdPeriod(ViewSchedules.teacherId));
		ThreecomboBox.setEditable(false);
		ThreecomboBox.setBounds(176, 137, 233, 27);
		panel.add(ThreecomboBox);
		
		JTextField FourcomboBox = new JTextField();
		FourcomboBox.setText(Teacher.getFourthPeriod(ViewSchedules.teacherId));
		FourcomboBox.setEditable(false);
		FourcomboBox.setBounds(176, 165, 233, 27);
		panel.add(FourcomboBox);
		
		JTextField FivecomboBox = new JTextField();
		FivecomboBox.setText(Teacher.getFifthPeriod(ViewSchedules.teacherId));
		FivecomboBox.setEditable(false);
		FivecomboBox.setBounds(176, 193, 233, 27);
		panel.add(FivecomboBox);
		
		JTextField SixcomboBox = new JTextField();
		SixcomboBox.setText(Teacher.getSixthPeriod(ViewSchedules.teacherId));
		SixcomboBox.setEditable(false);
		SixcomboBox.setBounds(176, 221, 233, 27);
		panel.add(SixcomboBox);
		
		JTextField SevencomboBox = new JTextField();
		SevencomboBox.setText(Teacher.getSeventhPeriod(ViewSchedules.teacherId));
		SevencomboBox.setEditable(false);
		SevencomboBox.setBounds(176, 249, 233, 27);
		panel.add(SevencomboBox);
		
		JTextField EightcomboBox = new JTextField();
		EightcomboBox.setText(Teacher.getEighthPeriod(ViewSchedules.teacherId));
		EightcomboBox.setEditable(false);
		EightcomboBox.setBounds(176, 277, 233, 27);
		panel.add(EightcomboBox);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProfiles.setTeacherId(ViewSchedules.teacherId);
				dispose();
				TeacherProfiles frame = new TeacherProfiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
				//View profile of the same person
			}
		});
		btnViewProfile.setBounds(203, 368, 117, 29);
		panel.add(btnViewProfile);
		
		
//Side menu
		
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

