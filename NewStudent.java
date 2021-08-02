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
import javax.swing.JTextArea;

public class NewStudent extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	JTextField FirstNametxtField;
	private JTextField LastNametxtField;
	private JTextField InitialtxtField;
	private JTextField SchoolIDtxtField;
	private JTextField EmailtxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudent frame = new NewStudent();
					frame.setUndecorated(true);		//Gets rid of header
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//Global variables that will be imported in file "NewStudentContinue0.java"
	
	public static String FName = "name";
	public static String IName = "name";
	public static String LName = "name";
	public static String Schoolid = "id";
	public static String Email = "email";
	public static String Gradelvl = "gradelvl";
	public static String Sex = "sex";

	public static void setInfo(String fname, String iname, String lname, String schoolid, String email, String gradelvl, String sex)
	{
		FName = fname;
		IName = iname;
		LName = lname;
		Schoolid = schoolid;
		Email = email;
		Gradelvl = gradelvl;
		Sex = sex;
	}
	/**
	 * Create the frame.
	 */
	public NewStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 439);
		contentPane = new JPanel();

//Can move page by press and drag
		
		contentPane.addMouseListener(new MouseAdapter() {	
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

		        NewStudent.this.setLocation(x - xx, y - xy);  
				
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
		
//Student must give the following information
		
//Labels
		
		JLabel lblNewStudent_1 = new JLabel("New Student");
		lblNewStudent_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewStudent_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewStudent_1.setBounds(195, 50, 146, 30);
		panel.add(lblNewStudent_1);
		
		JLabel lblSFirstName = new JLabel("First Name:");
		lblSFirstName.setForeground(UIManager.getColor("Button.highlight"));
		lblSFirstName.setBounds(76, 113, 78, 16);
		panel.add(lblSFirstName);
		
		JLabel Sasf = new JLabel("Initial:");
		Sasf.setForeground(Color.WHITE);
		Sasf.setBounds(250, 113, 78, 16);
		panel.add(Sasf);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(332, 113, 78, 16);
		panel.add(lblLastName);
		
		JLabel lblSchoolId = new JLabel("Student ID:");
		lblSchoolId.setForeground(Color.WHITE);
		lblSchoolId.setBounds(76, 195, 78, 16);
		panel.add(lblSchoolId);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setForeground(Color.WHITE);
		lblGradeLevel.setBounds(249, 195, 78, 16);
		panel.add(lblGradeLevel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(76, 281, 78, 16);
		panel.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(250, 281, 78, 16);
		panel.add(lblGender);
		
//Text fields and combo boxes
		
		FirstNametxtField = new JTextField();
		FirstNametxtField.setBounds(76, 141, 130, 26);
		panel.add(FirstNametxtField);
		FirstNametxtField.setColumns(10);
		
		LastNametxtField = new JTextField();
		LastNametxtField.setColumns(10);
		LastNametxtField.setBounds(332, 141, 130, 26);
		panel.add(LastNametxtField);
		
		InitialtxtField = new JTextField();
		InitialtxtField.setColumns(10);
		InitialtxtField.setBounds(250, 141, 42, 26);
		panel.add(InitialtxtField);
		
		SchoolIDtxtField = new JTextField();
		SchoolIDtxtField.setColumns(10);
		SchoolIDtxtField.setBounds(76, 223, 130, 26);
		panel.add(SchoolIDtxtField);
		
		EmailtxtField = new JTextField();
		EmailtxtField.setColumns(10);
		EmailtxtField.setBounds(76, 308, 130, 26);
		panel.add(EmailtxtField);
		
		JComboBox GradeLevelcomboBox = new JComboBox();
		GradeLevelcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Freshmen", "Sophomore", "Junior", "Senior"}));
		GradeLevelcomboBox.setBounds(241, 222, 117, 30);
		panel.add(GradeLevelcomboBox);
		
		JComboBox SexcomboBox = new JComboBox();
		SexcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		SexcomboBox.setBounds(250, 309, 108, 27);
		panel.add(SexcomboBox);
		
//Buttons
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Prevent continuation if any of the text fields are empty
				
				if(FirstNametxtField.getText().equals("") || LastNametxtField.getText().equals("")
					|| SchoolIDtxtField.getText().equals("") || EmailtxtField.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,"Fill in every information to continue.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
					
				else {
					
				//Display user input in the file "NewStudentContinue0.java"
					
				if(Student.stIdisUnique(SchoolIDtxtField.getText()))
				{
					NewStudent.setInfo(FirstNametxtField.getText(), InitialtxtField.getText(), LastNametxtField.getText(), SchoolIDtxtField.getText(), EmailtxtField.getText(), GradeLevelcomboBox.getSelectedItem().toString(), SexcomboBox.getSelectedItem().toString());
					
					dispose();
					NewStudentContinue0 frame = new NewStudentContinue0();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"The student ID you entered is already being used. Please enter a different student ID.", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		btnContinue.setBounds(393, 366, 101, 29);
		panel.add(btnContinue);
		
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

