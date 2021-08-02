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

public class UpdateSchedules extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField StudentIDtxtField;
	private JTextField TeacherIDtxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSchedules frame = new UpdateSchedules();
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
	public UpdateSchedules() {
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

		        UpdateSchedules.this.setLocation(x - xx, y - xy);  
				
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
		
				JLabel lblViewProfiles_1 = new JLabel("Update Schedule");
				lblViewProfiles_1.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
				lblViewProfiles_1.setForeground(UIManager.getColor("Button.highlight"));
				lblViewProfiles_1.setBounds(176, 45, 193, 36);
				panel.add(lblViewProfiles_1);
				
				JLabel lblNewLabel = new JLabel("Student ID:");
				lblNewLabel.setForeground(UIManager.getColor("Button.highlight"));
				lblNewLabel.setBounds(236, 125, 79, 16);
				panel.add(lblNewLabel);
				
				JLabel lblTeacherId = new JLabel("Teacher ID:");
				lblTeacherId.setForeground(Color.WHITE);
				lblTeacherId.setBounds(236, 211, 79, 16);
				panel.add(lblTeacherId);
				
		//Text fields
				
			
				
		//Buttons
				
				JButton btnSearch = new JButton("Search");
				btnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(StudentIDtxtField.getText().equals("") && TeacherIDtxtField.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"Please enter an ID number in one of the categories.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						}
		//Enter Java/SQL connection here that can search for 
						else {
						dispose();
						Profiles frame = new Profiles();
						frame.setUndecorated(true);
						frame.setVisible(true);
						}
					}
				});
				btnSearch.setBounds(218, 314, 117, 29);
				panel.add(btnSearch);
				
				StudentIDtxtField = new JTextField();
				StudentIDtxtField.setBounds(205, 163, 130, 26);
				panel.add(StudentIDtxtField);
				StudentIDtxtField.setColumns(10);
				
				TeacherIDtxtField = new JTextField();
				TeacherIDtxtField.setBounds(205, 249, 130, 26);
				panel.add(TeacherIDtxtField);
				TeacherIDtxtField.setColumns(10);
		
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

