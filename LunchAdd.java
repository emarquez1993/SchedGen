import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LunchAdd extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	private JTextField TimetxtField;
	private JTextField LunchNametxtField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LunchAdd frame = new LunchAdd();
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
	public LunchAdd() {
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

		        LunchAdd.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblNewLabel = new JLabel("Add Lunch");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel.setBounds(192, 21, 133, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Requirements:");
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.background"));
		lblNewLabel_1.setBounds(95, 103, 96, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(SystemColor.window);
		lblGender.setBounds(95, 142, 54, 16);
		panel.add(lblGender);
		
		JLabel lblGradeLevel = new JLabel("Grade Level:");
		lblGradeLevel.setForeground(SystemColor.window);
		lblGradeLevel.setBounds(95, 181, 96, 16);
		panel.add(lblGradeLevel);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setForeground(SystemColor.window);
		lblTime.setBounds(95, 260, 96, 16);
		panel.add(lblTime);
	
//ComboBoxes and textFields
		
		JComboBox RequirementscomboBox = new JComboBox();
		RequirementscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Gender", "Grade Level"}));
		RequirementscomboBox.setBounds(235, 99, 184, 27);
		panel.add(RequirementscomboBox);
		
		JComboBox GendercomboBox = new JComboBox();
		GendercomboBox.setModel(new DefaultComboBoxModel(new String[] {"N/A", "Male", "Female", "Unspecified"}));
		GendercomboBox.setBounds(235, 138, 184, 27);
		panel.add(GendercomboBox);
		
		JComboBox GradeLvlcomboBox1 = new JComboBox();
		GradeLvlcomboBox1.setModel(new DefaultComboBoxModel(new String[] {"N/A", "Freshmen", "Sophomore", "Junior", "Senior"}));
		GradeLvlcomboBox1.setBounds(235, 177, 184, 27);
		panel.add(GradeLvlcomboBox1);
		
		JComboBox GradeLvlcomboBox2 = new JComboBox();
		GradeLvlcomboBox2.setModel(new DefaultComboBoxModel(new String[] {"N/A", "Freshmen", "Sophomore", "Junior", "Senior"}));
		GradeLvlcomboBox2.setBounds(235, 216, 184, 27);
		panel.add(GradeLvlcomboBox2);
		
		TimetxtField = new JTextField();
		TimetxtField.setText("0:00 - 0:00");
		TimetxtField.setBounds(235, 255, 130, 26);
		panel.add(TimetxtField);
		TimetxtField.setColumns(10);
		
//Buttons
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(RequirementscomboBox.getSelectedItem().equals("Gender")){
					if(GendercomboBox.getSelectedItem().toString().equals("N/A")) {
						JOptionPane.showMessageDialog(null,"Select Gender.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					JOptionPane.showMessageDialog(null,"Lunch period has been added.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					//Add these to database
					String Requirement = RequirementscomboBox.getSelectedItem().toString();
					String Gender = GendercomboBox.getSelectedItem().toString();
					String Time = TimetxtField.getText();
					String LunchName = LunchNametxtField.getText();
					
					dispose();
					ClassesChoose frame = new ClassesChoose();
					frame.setUndecorated(true);
					frame.setVisible(true);
					}
				}
				else{
					if(GradeLvlcomboBox1.getSelectedItem().toString().equals("N/A") && GradeLvlcomboBox2.getSelectedItem().toString().equals("N/A")) {
						JOptionPane.showMessageDialog(null,"Select Grade Level.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
					JOptionPane.showMessageDialog(null,"Lunch period has been added.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					String Requirement = RequirementscomboBox.getSelectedItem().toString();
					String GradeLvl1 = GradeLvlcomboBox1.getSelectedItem().toString();
					
					if(GradeLvlcomboBox2.getSelectedItem().toString() != "N/A") {	
						//Only gets GradeLvl2 if the comboBox is not N/A
						String GradeLvl2 = GradeLvlcomboBox2.getSelectedItem().toString();
					}
					String Time = TimetxtField.getText();
					String LunchName = LunchNametxtField.getText();
					
					dispose();
					ClassesChoose frame = new ClassesChoose();
					frame.setUndecorated(true);
					frame.setVisible(true);
					}
				}
			}
		});
		btnAdd.setBounds(348, 342, 117, 29);
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClassesChoose frame = new ClassesChoose();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(95, 342, 117, 29);
		panel.add(btnCancel);
		
		JLabel lblLunchName = new JLabel("Lunch Name:");
		lblLunchName.setForeground(SystemColor.window);
		lblLunchName.setBounds(95, 298, 96, 16);
		panel.add(lblLunchName);
		
		LunchNametxtField = new JTextField();
		LunchNametxtField.setColumns(10);
		LunchNametxtField.setBounds(235, 293, 130, 26);
		panel.add(LunchNametxtField);
		
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

