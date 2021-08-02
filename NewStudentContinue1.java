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

public class NewStudentContinue1 extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStudentContinue1 frame = new NewStudentContinue1();
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
	public NewStudentContinue1() {
		ArrayList<String> coreList = new ArrayList<String>();
		ArrayList<String> electiveList = new ArrayList<String>();
		ArrayList<String> lunchList = new ArrayList<String>();
		DBConnection.getCoreClasses(coreList);
		DBConnection.getElectiveClasses(electiveList);
		DBConnection.getLunches(lunchList);
		if(coreList.isEmpty())
			coreList.add("NONE");
		if(electiveList.isEmpty())
			electiveList.add("NONE");
		if(lunchList.isEmpty())
			lunchList.add("NONE");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 508);
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

		        NewStudentContinue1.this.setLocation(x - xx, y - xy);  
				
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
		lblX.setBounds(535, 21, 13, 16);
		panel.add(lblX);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(UIManager.getColor("Button.select"));
		
//Labels
		
		JLabel lblChooseClasses = new JLabel("Choose Classes");
		lblChooseClasses.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblChooseClasses.setForeground(Color.WHITE);
		lblChooseClasses.setBounds(209, 21, 189, 44);
		panel.add(lblChooseClasses);
		
		JLabel lblNewLabel = new JLabel("Core:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(81, 112, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblExtraCurricular = new JLabel("Extra Curricular:");
		lblExtraCurricular.setForeground(Color.WHITE);
		lblExtraCurricular.setBounds(321, 112, 109, 16);
		panel.add(lblExtraCurricular);
		
		JLabel lblhighestPriorityFirst = new JLabel("(Highest Priority First)");
		lblhighestPriorityFirst.setForeground(Color.WHITE);
		lblhighestPriorityFirst.setBounds(229, 63, 143, 16);
		panel.add(lblhighestPriorityFirst);
		
//Insert classes the student will want/need to take
		
		JComboBox core1ComboBox = new JComboBox();
		core1ComboBox.setBounds(80, 160, 170, 27);
		core1ComboBox.setModel(new DefaultComboBoxModel(coreList.toArray()));
		panel.add(core1ComboBox);
		
		JComboBox core2ComboBox = new JComboBox();
		core2ComboBox.setBounds(80, 215, 170, 27);
		core2ComboBox.setModel(new DefaultComboBoxModel(coreList.toArray()));
		panel.add(core2ComboBox);
		
		JComboBox core3ComboBox = new JComboBox();
		core3ComboBox.setBounds(80, 270, 170, 27);
		core3ComboBox.setModel(new DefaultComboBoxModel(coreList.toArray()));
		panel.add(core3ComboBox);
		
		JComboBox core4ComboBox = new JComboBox();
		core4ComboBox.setBounds(80, 325, 170, 27);
		core4ComboBox.setModel(new DefaultComboBoxModel(coreList.toArray()));
		panel.add(core4ComboBox);
		
		JComboBox lunchComboBox = new JComboBox();
		lunchComboBox.setBounds(81, 390, 170, 27);
		lunchComboBox.setModel(new DefaultComboBoxModel(lunchList.toArray()));
		panel.add(lunchComboBox);
		
		JComboBox elective1ComboBox = new JComboBox();
		elective1ComboBox.setBounds(321, 160, 170, 27);
		elective1ComboBox.setModel(new DefaultComboBoxModel(electiveList.toArray()));
		panel.add(elective1ComboBox);
		
		JComboBox elective2ComboBox = new JComboBox();
		elective2ComboBox.setBounds(321, 215, 170, 27);
		elective2ComboBox.setModel(new DefaultComboBoxModel(electiveList.toArray()));
		panel.add(elective2ComboBox);
		
		JComboBox elective3ComboBox = new JComboBox();
		elective3ComboBox.setBounds(321, 270, 170, 27);
		elective3ComboBox.setModel(new DefaultComboBoxModel(electiveList.toArray()));
		panel.add(elective3ComboBox);
		
		JButton btnContinue = new JButton("Generate");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coreClass1 = core1ComboBox.getSelectedItem().toString();
				String coreClass2 = core2ComboBox.getSelectedItem().toString();
				String coreClass3 = core3ComboBox.getSelectedItem().toString();
				String coreClass4 = core4ComboBox.getSelectedItem().toString();
				String lunch = lunchComboBox.getSelectedItem().toString();
				String electiveClass1 = elective1ComboBox.getSelectedItem().toString();
				String electiveClass2 = elective2ComboBox.getSelectedItem().toString();
				String electiveClass3 = elective3ComboBox.getSelectedItem().toString();
				String id = NewStudent.Schoolid;
				Counselor.CreateSchedule(id, electiveClass1, electiveClass2, electiveClass3, lunch, coreClass1, coreClass2, coreClass3, coreClass4);
				
				JOptionPane.showMessageDialog(null,"The schedule was created successfully.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				ViewSchedules.setStId(id);
				dispose();
				Schedule frame = new Schedule();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnContinue.setBounds(390, 379, 101, 29);
		panel.add(btnContinue);
		
//Confirmation pop up message
		
		JButton Skipbtn = new JButton("Skip");
		Skipbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Would you like to skip this process?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {

				dispose();
				NewStudent frame = new NewStudent();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
			}
		});
		Skipbtn.setBounds(390, 433, 101, 29);
		panel.add(Skipbtn);
		
		JLabel lblLunch = new JLabel("Lunch:");
		lblLunch.setForeground(Color.WHITE);
		lblLunch.setBounds(81, 363, 61, 16);
		panel.add(lblLunch);
		
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

