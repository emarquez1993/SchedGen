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
import javax.swing.JEditorPane;

public class ClassesDelete extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassesDelete frame = new ClassesDelete();
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
	public ClassesDelete() {
		ArrayList<String> allClasses = new ArrayList<String>();
		DBConnection.getAllClasses(allClasses);
		if(allClasses.isEmpty())
			allClasses.add("NO CLASSES AVAILABLE");
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

		        ClassesDelete.this.setLocation(x - xx, y - xy);  
				
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
		
		JLabel lblNewLabel = new JLabel("Delete Class");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel.setForeground(UIManager.getColor("Button.select"));
		lblNewLabel.setBounds(180, 23, 174, 49);
		panel.add(lblNewLabel);
		
		JLabel lblSelectClassTo = new JLabel("Select Class to Delete:");
		lblSelectClassTo.setForeground(UIManager.getColor("Button.highlight"));
		lblSelectClassTo.setBounds(66, 130, 174, 16);
		panel.add(lblSelectClassTo);
		
		JLabel lblLunchInfo = new JLabel("Class Infromation:");
		lblLunchInfo.setForeground(Color.WHITE);
		lblLunchInfo.setBounds(66, 193, 174, 16);
		panel.add(lblLunchInfo);
		
//ComboBox and EditorPane
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = comboBox.getSelectedItem().toString();
				String Name = DBConnection.getClassName(ID);
				//Get information from the selected lunch period and replace the following strings with information from the database
				String Category = DBConnection.getClassCategory(ID);
				String ClassLvl = DBConnection.getClassLvl(ID);
				String PriorityLvl = DBConnection.getClassPriorityLvl(ID);
				editorPane.setText(" Name: " + Name + "\n ID: " + ID + 
						"\n Category: " + Category + "\n Class Level: " + ClassLvl + "\n Priority Level: " + PriorityLvl);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(allClasses.toArray()));
		comboBox.setBounds(267, 126, 208, 27);
		panel.add(comboBox);
		
		String ID = comboBox.getSelectedItem().toString();
		String Name = DBConnection.getClassName(ID);
		//Get information from the selected lunch period and replace the following strings with information from the database
		String Category = DBConnection.getClassCategory(ID);
		String ClassLvl = DBConnection.getClassLvl(ID);
		String PriorityLvl = DBConnection.getClassPriorityLvl(ID);
		

		editorPane.setText(" Name: " + Name + "\n ID: " + ID + 
				"\n Category: " + Category + "\n Class Level: " + ClassLvl + "\n Priority Level: " + PriorityLvl);
		editorPane.setBounds(267, 193, 208, 117);
		panel.add(editorPane);
		
//Buttons
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Select")) {
					 JOptionPane.showMessageDialog(null,"Select a Lunch Period to delete.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this class?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {
					DBConnection.deleteClass(ID);
					JOptionPane.showMessageDialog(null,"Class has been deleted.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				
					//SQL delete code
				
					dispose();
					ClassesChoose frame = new ClassesChoose();
					frame.setUndecorated(true);
					frame.setVisible(true);
				}
				}
			}
		});
		btnDelete.setBounds(347, 356, 117, 29);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClassesChoose frame = new ClassesChoose();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnCancel.setBounds(66, 356, 117, 29);
		panel.add(btnCancel);
		
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

