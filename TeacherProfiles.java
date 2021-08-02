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

public class TeacherProfiles extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField NametxtField;
	private JTextField IDtxtField;
	private JTextField EmailtxtField;
	private JTextField PhoneNumbertxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherProfiles frame = new TeacherProfiles();
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
	public TeacherProfiles() {
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

		        TeacherProfiles.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblNewLabel = new JLabel("Teacher Profile");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel.setBounds(178, 38, 181, 39);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(UIManager.getColor("Button.highlight"));
		lblName.setBounds(116, 131, 61, 16);
		panel.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(116, 181, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblGradeLevel = new JLabel("Phone Number:");
		lblGradeLevel.setForeground(Color.WHITE);
		lblGradeLevel.setBounds(116, 231, 96, 16);
		panel.add(lblGradeLevel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(116, 280, 61, 16);
		panel.add(lblEmail);

//Text Fields and ComboBoxes

		NametxtField = new JTextField();
		NametxtField.setBounds(237, 126, 175, 26);
		NametxtField.setText(Teacher.getName(ViewProfiles.teacherId));
		panel.add(NametxtField);
		NametxtField.setColumns(10);
		
		IDtxtField = new JTextField();
		IDtxtField.setBounds(237, 176, 175, 26);
		IDtxtField.setText(ViewProfiles.teacherId);
		panel.add(IDtxtField);
		IDtxtField.setColumns(10);
		
		EmailtxtField = new JTextField();
		EmailtxtField.setBounds(237, 275, 175, 26);
		EmailtxtField.setText(Teacher.getEmail(ViewProfiles.teacherId));
		panel.add(EmailtxtField);
		EmailtxtField.setColumns(10);
		
		PhoneNumbertxtField = new JTextField();
		PhoneNumbertxtField.setColumns(10);
		PhoneNumbertxtField.setText(Teacher.getPhone(ViewProfiles.teacherId));
		PhoneNumbertxtField.setBounds(237, 226, 175, 26);
		panel.add(PhoneNumbertxtField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Math", "Science", "Social Studies", "English", "Extra Curricular", "Other", "N/A"}));
		comboBox.setMaximumRowCount(7);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("Math"))
			comboBox.setSelectedIndex(0);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("Science"))
			comboBox.setSelectedIndex(1);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("Social Studies"))
			comboBox.setSelectedIndex(2);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("English"))
			comboBox.setSelectedIndex(3);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("Extra Curricular"))
			comboBox.setSelectedIndex(4);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("Other"))
			comboBox.setSelectedIndex(5);
		if(Teacher.getSubject(ViewProfiles.teacherId).toString().equals("N/A"))
			comboBox.setSelectedIndex(6);
		comboBox.setBounds(237, 319, 175, 26);
		panel.add(comboBox);
		
//Update and Delete buttons
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to update the information?", "CONFIRM", JOptionPane.YES_NO_OPTION);
				
				if(YesOrNo == 0) {
					
				//Get strings from these variables and update database
				String Name = NametxtField.getText();
				String ID = IDtxtField.getText();
				String Email = EmailtxtField.getText();
				String PhoneNum = PhoneNumbertxtField.getText();
				String Subject = comboBox.getSelectedItem().toString();
				Teacher.updateTeacher(ID, Name, Subject, Email, PhoneNum);
				JOptionPane.showMessageDialog(null,"The information was successfully updated.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnSaveChanges.setBounds(365, 372, 117, 29);
		panel.add(btnSaveChanges);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this profile?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {
				Teacher.deleteTeacher(ViewProfiles.teacherId);
				JOptionPane.showMessageDialog(null,"Profile has been deleted.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				

				
				dispose();
				ViewProfiles frame = new ViewProfiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
				}
			}
		});
		btnDelete.setBounds(49, 372, 117, 29);
		panel.add(btnDelete);
		
		JButton btnViewSchedule = new JButton("View Schedule");
		btnViewSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSchedules.setTeacherId(ViewProfiles.teacherId);
				dispose(); 
				TeacherSchedule frame = new TeacherSchedule();  
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnViewSchedule.setBounds(212, 372, 117, 29);
		panel.add(btnViewSchedule);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setForeground(Color.WHITE);
		lblSubject.setBounds(116, 324, 77, 16);
		panel.add(lblSubject);
		

		
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

