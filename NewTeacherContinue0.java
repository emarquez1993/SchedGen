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
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class NewTeacherContinue0 extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTeacherContinue0 frame = new NewTeacherContinue0();
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
	public NewTeacherContinue0() {
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

		        NewTeacherContinue0.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblNewLabel_1 = new JLabel("(Make sure that the following information is correct)");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(96, 75, 340, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Confirm");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setBounds(107, 21, 292, 42);
		panel.add(lblNewLabel);
		
		//Import user input from file "NewTeacher.java"
		
				String fname = NewTeacher.FName;
				String iname = NewTeacher.IName;
				String lname = NewTeacher.LName;
				String name = fname + " " + iname + " " + lname;
				String id = NewTeacher.Schoolid;
				String email = NewTeacher.Email;
				String phonenum = NewTeacher.PhoneNum;
				String subject = NewTeacher.Subject;
				JEditorPane textPane = new JEditorPane();
				textPane.setEditable(false);
		
//Confirmation Button
		
		JButton btnContinue = new JButton("Confirm");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Is the following information correct?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {

				Counselor.CreateTeacher(id, name, subject, email, phonenum);
				JOptionPane.showMessageDialog(null,"The teacher was added successfully.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				NewTeacher frame = new NewTeacher();
				frame.setUndecorated(true);
				frame.setVisible(true);
				}
			}
		});
		btnContinue.setBounds(365, 366, 101, 29);
		panel.add(btnContinue);
		
		

		
//Diplayed on textfield
		
		textPane.setText(" Teacher Name: " + fname + " " + iname + " " + lname + "\n School ID: " + id +
				"\n Email: " + email + "\n Phone Number: " + phonenum + "\n Subject: " + subject);		
		textPane.setBounds(25, 111, 441, 218);
		panel.add(textPane);
		
		JButton Cancelbtn = new JButton("Cancel");
		Cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewTeacher frame = new NewTeacher();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		Cancelbtn.setBounds(25, 366, 101, 29);
		panel.add(Cancelbtn);
		
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

