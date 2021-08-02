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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

public class Schedule extends SignUp {

	private JPanel contentPane;
	int xx, xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
					frame.setUndecorated(true);		//Gets rid of header
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	String Name = "Name";

	/**
	 * Create the frame.
	 */
	public Schedule() {
		ArrayList<String> firstPeriodList = new ArrayList<String>();
		ArrayList<String> secondPeriodList = new ArrayList<String>();
		ArrayList<String> thirdPeriodList = new ArrayList<String>();
		ArrayList<String> fourthPeriodList = new ArrayList<String>();
		ArrayList<String> fifthPeriodList = new ArrayList<String>();
		ArrayList<String> sixthPeriodList = new ArrayList<String>();
		ArrayList<String> seventhPeriodList = new ArrayList<String>();
		ArrayList<String> eighthPeriodList = new ArrayList<String>();
		
		DBConnection.getFirstPeriodClasses(firstPeriodList);
		DBConnection.getSecondPeriodClasses(secondPeriodList);
		DBConnection.getThirdPeriodClasses(thirdPeriodList);
		DBConnection.getFourthPeriodClasses(fourthPeriodList);
		DBConnection.getFifthPeriodClasses(fifthPeriodList);
		DBConnection.getSixthPeriodClasses(sixthPeriodList);
		DBConnection.getSeventhPeriodClasses(seventhPeriodList);
		DBConnection.getEighthPeriodClasses(eighthPeriodList);
		
		if(firstPeriodList.isEmpty())
			firstPeriodList.add("NO CLASSES");
		if(secondPeriodList.isEmpty())
			secondPeriodList.add("NO CLASSES");
		if(thirdPeriodList.isEmpty())
			thirdPeriodList.add("NO CLASSES");
		if(fourthPeriodList.isEmpty())
			fourthPeriodList.add("NO CLASSES");
		if(fifthPeriodList.isEmpty())
			fifthPeriodList.add("NO CLASSES");
		if(sixthPeriodList.isEmpty())
			sixthPeriodList.add("NO CLASSES");
		if(seventhPeriodList.isEmpty())
			seventhPeriodList.add("NO CLASSES");
		if(eighthPeriodList.isEmpty())
			eighthPeriodList.add("NO CLASSES");
		
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

		        Schedule.this.setLocation(x - xx, y - xy);  
				
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
		
//Label 
		
		JLabel Name = new JLabel("Schedule");
		Name.setBackground(UIManager.getColor("Button.darkShadow"));
		Name.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		Name.setForeground(UIManager.getColor("Button.select"));
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setBounds(64, 21, 405, 52);
		panel.add(Name);
		
		JLabel label = new JLabel("1.");
		label.setForeground(UIManager.getColor("Button.highlight"));
		label.setBounds(10, 84, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(10, 111, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(10, 138, 61, 16);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(10, 165, 61, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(10, 192, 61, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("6.");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(10, 219, 61, 16);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("7.");
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(10, 246, 61, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("8.");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(10, 273, 61, 16);
		panel.add(label_7);
		
//ComboBoxes
//The "Math", "Science", English" is just a test to see if the update button works. IT WORKS!
//You can replace those with real
		
		JComboBox OnecomboBox = new JComboBox();
		OnecomboBox.setMaximumRowCount(100);
		OnecomboBox.setBounds(51, 79, 233, 27);
		OnecomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getFirstPeriod(ViewSchedules.stId)}));
		panel.add(OnecomboBox);
		
		JComboBox TwocomboBox = new JComboBox();
		TwocomboBox.setMaximumRowCount(100);
		TwocomboBox.setBounds(51, 106, 233, 27);
		TwocomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getSecondPeriod(ViewSchedules.stId)}));
		panel.add(TwocomboBox);
		
		JComboBox ThreecomboBox = new JComboBox();
		ThreecomboBox.setMaximumRowCount(100);
		ThreecomboBox.setBounds(51, 133, 233, 27);
		ThreecomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getThirdPeriod(ViewSchedules.stId)}));
		panel.add(ThreecomboBox);
		
		JComboBox FourcomboBox = new JComboBox();
		FourcomboBox.setMaximumRowCount(100);
		FourcomboBox.setBounds(51, 160, 233, 27);
		FourcomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getFourthPeriod(ViewSchedules.stId)}));
		panel.add(FourcomboBox);
		
		JComboBox FivecomboBox = new JComboBox();
		FivecomboBox.setMaximumRowCount(100);
		FivecomboBox.setBounds(51, 187, 233, 27);
		FivecomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getFifthPeriod(ViewSchedules.stId)}));
		panel.add(FivecomboBox);
		
		JComboBox SixcomboBox = new JComboBox();
		SixcomboBox.setMaximumRowCount(100);
		SixcomboBox.setBounds(51, 214, 233, 27);
		SixcomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getSixthPeriod(ViewSchedules.stId)}));
		panel.add(SixcomboBox);
		
		JComboBox SevencomboBox = new JComboBox();
		SevencomboBox.setMaximumRowCount(100);
		SevencomboBox.setBounds(51, 241, 233, 27);
		SevencomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getSeventhPeriod(ViewSchedules.stId)}));
		panel.add(SevencomboBox);
		
		JComboBox EightcomboBox = new JComboBox();
		EightcomboBox.setMaximumRowCount(100);
		EightcomboBox.setBounds(51, 268, 233, 27);
		EightcomboBox.setModel(new DefaultComboBoxModel(new String[] {Student.getEighthPeriod(ViewSchedules.stId)}));
		panel.add(EightcomboBox);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this schedule?", "CONFIRMATION", JOptionPane.OK_OPTION);
				
				if(YesOrNo == 0) {
				Counselor.deleteSchedule(ViewSchedules.stId);
				JOptionPane.showMessageDialog(null,"Schedule has been deleted.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
				
				//SQL delete code
				
				dispose();
				ViewSchedules frame = new ViewSchedules();
				frame.setUndecorated(true);
				frame.setVisible(true);
				}
			
			}
		});
		btnDelete.setBounds(51, 368, 117, 29);
		panel.add(btnDelete);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProfiles.setStId(ViewSchedules.stId);
				dispose();
				Profiles frame = new Profiles();
				frame.setUndecorated(true);
				frame.setVisible(true);
				//View profile of the same person
			}
		});
		btnViewProfile.setBounds(203, 368, 117, 29);
		panel.add(btnViewProfile);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OnecomboBox.setModel(new DefaultComboBoxModel(firstPeriodList.toArray()));
			}
		});
		btnNewButton.setBounds(294, 81, 61, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Edit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwocomboBox.setModel(new DefaultComboBoxModel(secondPeriodList.toArray()));
			}
		});
		button.setBounds(294, 108, 61, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThreecomboBox.setModel(new DefaultComboBoxModel(thirdPeriodList.toArray()));
			}
		});
		button_1.setBounds(294, 135, 61, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FourcomboBox.setModel(new DefaultComboBoxModel(fourthPeriodList.toArray()));
			}
		});
		button_2.setBounds(294, 162, 61, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Edit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FivecomboBox.setModel(new DefaultComboBoxModel(fifthPeriodList.toArray()));
			}
		});
		button_3.setBounds(294, 189, 61, 23);
		panel.add(button_3);
		
		JButton button_4 = new JButton("Edit");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SixcomboBox.setModel(new DefaultComboBoxModel(sixthPeriodList.toArray()));
			}
		});
		button_4.setBounds(294, 216, 61, 23);
		panel.add(button_4);
		
		JButton button_5 = new JButton("Edit");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SevencomboBox.setModel(new DefaultComboBoxModel(seventhPeriodList.toArray()));
			}
		});
		button_5.setBounds(294, 243, 61, 23);
		panel.add(button_5);
		
		JButton button_6 = new JButton("Edit");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EightcomboBox.setModel(new DefaultComboBoxModel(eighthPeriodList.toArray()));
			}
		});
		button_6.setBounds(294, 270, 61, 23);
		panel.add(button_6);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateFirstPeriod(ViewSchedules.stId, OnecomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSave.setBounds(365, 81, 76, 23);
		panel.add(btnSave);
		
		JButton button_7 = new JButton("Save");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateSecondPeriod(ViewSchedules.stId, TwocomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_7.setBounds(365, 108, 76, 23);
		panel.add(button_7);
		
		JButton button_8 = new JButton("Save");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateThirdPeriod(ViewSchedules.stId, ThreecomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_8.setBounds(365, 135, 76, 23);
		panel.add(button_8);
		
		JButton button_9 = new JButton("Save");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateFourthPeriod(ViewSchedules.stId, FourcomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_9.setBounds(365, 162, 76, 23);
		panel.add(button_9);
		
		JButton button_10 = new JButton("Save");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateFifthPeriod(ViewSchedules.stId, FivecomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_10.setBounds(365, 189, 76, 23);
		panel.add(button_10);
		
		JButton button_11 = new JButton("Save");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateSixthPeriod(ViewSchedules.stId, SixcomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_11.setBounds(365, 216, 76, 23);
		panel.add(button_11);
		
		JButton button_12 = new JButton("Save");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateSeventhPeriod(ViewSchedules.stId, SevencomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_12.setBounds(365, 243, 76, 23);
		panel.add(button_12);
		
		JButton button_13 = new JButton("Save");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Counselor.updateEighthPeriod(ViewSchedules.stId, EightcomboBox.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,"Class saved.", "CONFIRMATION", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		button_13.setBounds(365, 270, 76, 23);
		panel.add(button_13);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        PrinterJob job = PrinterJob.getPrinterJob();
		        job.setJobName("Print Data");
		            
		        job.setPrintable(new Printable() {
		            @Override
		            public int print(Graphics pg, PageFormat pf, int pageNum) throws PrinterException {
		                pf.setOrientation(PageFormat.LANDSCAPE);
		                if(pageNum>0)
		                {
		                    return Printable.NO_SUCH_PAGE;
		                }
		                Graphics2D g2 = (Graphics2D)pg;
		                g2.translate(pf.getImageableX(), pf.getImageableY());
		                g2.scale(0.8,0.8);
		                panel.paint(g2);
		                return Printable.PAGE_EXISTS;
		            }
		        });
		        boolean ok = job.printDialog();
		        if(ok){
		        try{
		            job.print();
		        }
		        catch (PrinterException ex){}
		        }
			}
		});
		btnPrint.setBounds(352, 368, 117, 29);
		panel.add(btnPrint);
		
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

