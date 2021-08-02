import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.tools.javac.util.List;

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
import java.util.ArrayList;
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

public class Classes extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField ClassNametxtField;
	private JTextField ClassIDtxtField;
	private JTextField capacityTextField;
	private JTextField roomNumTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classes frame = new Classes();
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
	public Classes() {
		ArrayList<String> mathTeachers = new ArrayList<String>();
		ArrayList<String> scienceTeachers = new ArrayList<String>();
		ArrayList<String> ssTeachers = new ArrayList<String>();
		ArrayList<String> englishTeachers = new ArrayList<String>();
		ArrayList<String> ecTeachers = new ArrayList<String>();
		ArrayList<String> otherTeachers = new ArrayList<String>();
		Teacher.getMathTeachers(mathTeachers);
		Teacher.getScienceTeachers(scienceTeachers);
		Teacher.getSsTeachers(ssTeachers);
		Teacher.getEnglishTeachers(englishTeachers);
		Teacher.getEcTeachers(ecTeachers);
		Teacher.getOtherTeachers(otherTeachers);
		if(mathTeachers.isEmpty())
			mathTeachers.add("NO TEACHER");
		if(scienceTeachers.isEmpty())
			scienceTeachers.add("NO TEACHER");
		if(ssTeachers.isEmpty())
			ssTeachers.add("NO TEACHER");
		if(englishTeachers.isEmpty())
			englishTeachers.add("NO TEACHER");
		if(ecTeachers.isEmpty())
			ecTeachers.add("NO TEACHER");
		if(otherTeachers.isEmpty())
			otherTeachers.add("NO TEACHER");
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

		        Classes.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblClasses = new JLabel("Classes");
		lblClasses.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblClasses.setForeground(Color.WHITE);
		lblClasses.setBounds(224, 5, 91, 38);
		panel.add(lblClasses);
		
		JLabel label = new JLabel("Name:");
		label.setForeground(Color.WHITE);
		label.setBounds(77, 43, 61, 16);
		panel.add(label);
		
		JLabel lblName = new JLabel("ID:");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(77, 80, 25, 16);
		panel.add(lblName);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(77, 190, 61, 16);
		panel.add(lblCategory);
		
		JLabel lblClassLvl = new JLabel("Class Lvl:");
		lblClassLvl.setForeground(Color.WHITE);
		lblClassLvl.setBounds(77, 232, 61, 16);
		panel.add(lblClassLvl);
		
		JLabel lblPriorityLvl = new JLabel("Priority Lvl:");
		lblPriorityLvl.setForeground(Color.WHITE);
		lblPriorityLvl.setBounds(77, 278, 71, 16);
		panel.add(lblPriorityLvl);
		
//Text fields and combo boxes
		
		ClassNametxtField = new JTextField();
		ClassNametxtField.setBounds(204, 38, 203, 26);
		panel.add(ClassNametxtField);
		ClassNametxtField.setColumns(10);
		
		ClassIDtxtField = new JTextField();
		ClassIDtxtField.setColumns(10);
		ClassIDtxtField.setBounds(204, 75, 203, 26);
		panel.add(ClassIDtxtField);
		
		JComboBox teacherComboBox = new JComboBox();
		teacherComboBox.setMaximumRowCount(100);
		teacherComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
		teacherComboBox.setBounds(182, 322, 133, 26);
		panel.add(teacherComboBox);
		
		JComboBox CategoryComboBox = new JComboBox();
		CategoryComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CategoryComboBox.getSelectedIndex() == 0)
					teacherComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select"}));
				if(CategoryComboBox.getSelectedIndex() == 1)
					teacherComboBox.setModel(new DefaultComboBoxModel(mathTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 2)
					teacherComboBox.setModel(new DefaultComboBoxModel(scienceTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 3)
					teacherComboBox.setModel(new DefaultComboBoxModel(ssTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 4)
					teacherComboBox.setModel(new DefaultComboBoxModel(englishTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 5)
					teacherComboBox.setModel(new DefaultComboBoxModel(ecTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 6)
					teacherComboBox.setModel(new DefaultComboBoxModel(otherTeachers.toArray()));
				if(CategoryComboBox.getSelectedIndex() == 7)
					teacherComboBox.setModel(new DefaultComboBoxModel(new String[] {"NO TEACHER"}));
			}
		});
		CategoryComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Math", "Science", "Social Studies", "English", "Extra Curricular", "Other", "N/A"}));
		CategoryComboBox.setBounds(204, 186, 203, 26);
		panel.add(CategoryComboBox);
		
		JComboBox ClassLvlComboBox = new JComboBox();
		ClassLvlComboBox.setMaximumRowCount(6);
		ClassLvlComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Freshmen", "Sophomore", "Junior", "Senior", "N/A"}));
		ClassLvlComboBox.setBounds(204, 228, 203, 26);
		panel.add(ClassLvlComboBox);
		
		JComboBox PriorityLvlComboBox = new JComboBox();
		PriorityLvlComboBox.setMaximumRowCount(3);
		PriorityLvlComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		PriorityLvlComboBox.setBounds(204, 274, 71, 26);
		panel.add(PriorityLvlComboBox);
		
		JComboBox periodComboBox = new JComboBox();
		periodComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"}));
		periodComboBox.setMaximumRowCount(9);
		periodComboBox.setBounds(406, 273, 71, 26);
		panel.add(periodComboBox);
		
		capacityTextField = new JTextField();
		capacityTextField.setColumns(10);
		capacityTextField.setBounds(204, 144, 203, 26);
		panel.add(capacityTextField);
		
//Pop-up message for confirmation
		
		JButton btnNewButton = new JButton("Add Class");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClassNametxtField.getText().equals("") || ClassIDtxtField.getText().equals("") || CategoryComboBox.getSelectedItem().toString().equals("Select")
						|| ClassLvlComboBox.getSelectedItem().toString().equals("Select") || capacityTextField.getText().equals("") || teacherComboBox.getSelectedItem().toString().equals("Select") || roomNumTextField.getText().equals("")) {
					 JOptionPane.showMessageDialog(null,"Enter all the needed information.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				int YesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to add class?", "CONFIRM", JOptionPane.YES_NO_OPTION);
				
				if(YesOrNo == 0) {
					
//Insert Java to MySQL connection here	
					String ClassName = ClassNametxtField.getText();
					String ClassId = ClassIDtxtField.getText();
					String Category = CategoryComboBox.getSelectedItem().toString();
					String ClassLvl = ClassLvlComboBox.getSelectedItem().toString();
					String PriorityLvl = PriorityLvlComboBox.getSelectedItem().toString();
					String classCapacity = capacityTextField.getText();
					String teacherId = Teacher.getTeacherId(teacherComboBox.getSelectedItem().toString());
					String classPeriod = periodComboBox.getSelectedItem().toString();
					String classLocation = roomNumTextField.getText();
					
					if(DBConnection.teacherIsAvailable(teacherId, classPeriod) || teacherComboBox.getSelectedItem().toString().equals("NO TEACHER"))
					{
						if(DBConnection.classIdIsUnique(ClassId))
						{
							if(DBConnection.roomIsVacant(classLocation, classPeriod))
							{
								Counselor.CreateClass(ClassId, ClassName, Category, classPeriod, teacherId, classCapacity, classLocation, ClassLvl, PriorityLvl);
								
								JFrame ClassAdded = new JFrame();
								JOptionPane.showMessageDialog(ClassAdded, "Class has been added.");
								dispose();
								Classes reframe = new Classes();						//Same frame 
								reframe.setUndecorated(true);
								reframe.setVisible(true);
							}
							
							else
								JOptionPane.showMessageDialog(null,"The room that you entered conflicts with another class during that period. Please enter a different room number.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
							
						}
						
						else
							JOptionPane.showMessageDialog(null,"The class ID that you entered is already being used. Please enter a unique class ID.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else
						JOptionPane.showMessageDialog(null,"The teacher that you are requesting is not available during that class period. Please select another teacher.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					
					
					
				}
				}
				
			}
		});
		btnNewButton.setBounds(360, 345, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblClassPeriod = new JLabel("Period:");
		lblClassPeriod.setForeground(Color.WHITE);
		lblClassPeriod.setBounds(325, 278, 71, 16);
		panel.add(lblClassPeriod);
		
		
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setForeground(Color.WHITE);
		lblCapacity.setBounds(77, 149, 61, 16);
		panel.add(lblCapacity);
		
		
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBounds(77, 117, 49, 16);
		panel.add(lblRoom);
		
		roomNumTextField = new JTextField();
		roomNumTextField.setColumns(10);
		roomNumTextField.setBounds(204, 107, 203, 26);
		panel.add(roomNumTextField);
		
		JLabel lblTeacher = new JLabel("Teacher:");
		lblTeacher.setForeground(Color.WHITE);
		lblTeacher.setBounds(77, 324, 71, 16);
		panel.add(lblTeacher);
		
		
		
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

