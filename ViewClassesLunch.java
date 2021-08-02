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
import javax.swing.JEditorPane;

public class ViewClassesLunch extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClassesLunch frame = new ViewClassesLunch();
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
	public ViewClassesLunch() {
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

		        ViewClassesLunch.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblNewLabel = new JLabel("View Classes/Lunch");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel.setBounds(134, 21, 245, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Class:");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setBounds(48, 109, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblLunch = new JLabel("Lunch:");
		lblLunch.setForeground(Color.WHITE);
		lblLunch.setBounds(48, 161, 61, 16);
		panel.add(lblLunch);
		
//ComboBox and EditorPane
		
		JComboBox ClasscomboBox = new JComboBox();
		ClasscomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Algebra", "Calculus"}));
		ClasscomboBox.setBounds(174, 105, 154, 27);
		panel.add(ClasscomboBox);
		
		JComboBox LunchcomboBox = new JComboBox();
		LunchcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "A Lunch", "B Lunch"}));
		LunchcomboBox.setBounds(174, 157, 154, 27);
		panel.add(LunchcomboBox);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBounds(48, 215, 439, 123);
		panel.add(editorPane);
		
//Buttons
		
		JButton btnViewClass = new JButton("View Class");
		btnViewClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClasscomboBox.getSelectedItem().toString().equals("Select")) {
					 JOptionPane.showMessageDialog(null,"Select a Class Period to view.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				String ClassChosen = ClasscomboBox.getSelectedItem().toString();
				//Get information from the selected class and replace the following strings with information from the database
				String Name = "";
				String ID = "";
				String Category = "";
				String ClassLvl = "";
				String PriorityLvl = "";
				
				editorPane.setText(" Name: " + Name + "\n ID: " + ID + 
						"\n Category: " + Category + "\n Class Level: " + ClassLvl + "\n Priority Level: " + PriorityLvl);
				}
			}
		});
		btnViewClass.setBounds(377, 104, 117, 29);
		panel.add(btnViewClass);
		
		JButton btnViewLunch = new JButton("View Lunch");
		btnViewLunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LunchcomboBox.getSelectedItem().toString().equals("Select")) {
					 JOptionPane.showMessageDialog(null,"Select a Lunch Period to view.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
				String LunchChosen = LunchcomboBox.getSelectedItem().toString();
				//Get information from the selected lunch period and replace the following strings with information from the database
				String Requirements = "";
				String Gender = "";
				String GradeLvl1 = "";
				String GradeLvl2 = "";
				String Time = "";
				
				editorPane.setText(" Requirements: " + Requirements + "\n Gender: " + Gender + 
				"\n Grade Level 1: " + GradeLvl1 + "\n Grade Level 2: " + GradeLvl2 + "\n Time: " + Time);
				}
			}
		});
		btnViewLunch.setBounds(377, 156, 117, 29);
		panel.add(btnViewLunch);		
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClassesChoose frame = new ClassesChoose();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnDone.setBounds(377, 368, 117, 29);
		panel.add(btnDone);
		
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

