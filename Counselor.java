import java.sql.SQLException;
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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;

public class Counselor extends DBConnection{
	
	static String lastCouId = null;
	
	public static void CreateSchedule(String st_id, String elective1, String elective2, String elective3, String lunch, 
			String core1, String core2, String core3, String core4)
	{
		boolean firstVacant = true;
		boolean secondVacant = true;
		boolean thirdVacant = true;
		boolean fourthVacant = true;
		boolean fifthVacant = true;
		boolean sixthVacant = true;
		boolean seventhVacant = true;
		boolean eighthVacant = true;
		String sql;
		String class_id;
		String insertSql;
		String updateSql;
		int newCapacity;
		
		DBConnection.connection();
		
		sql = "SELECT * FROM Class WHERE class_name LIKE '" + lunch + "';";
		try 
		{
			rs = st.executeQuery(sql);
			rs.first();
			if(rs.getInt("class_period") == 1)
				firstVacant = false;
			else if(rs.getInt("class_period") == 2)
				secondVacant = false;
			else if(rs.getInt("class_period") == 3)
				thirdVacant = false;
			else if(rs.getInt("class_period") == 4)
				fourthVacant = false;
			else if(rs.getInt("class_period") == 5)
				fifthVacant = false;
			else if(rs.getInt("class_period") == 6)
				sixthVacant = false;
			else if(rs.getInt("class_period") == 7)
				seventhVacant = false;
			else if(rs.getInt("class_period") == 8)
				eighthVacant = false;
			class_id = rs.getString("class_id");
			insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
			st.executeUpdate(insertSql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			for(int i = 3; i >= 1; i--)
			{
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective1 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective1 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective2 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective2 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective3 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + elective3 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;
	
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;
	
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + core1 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + core1 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + core2 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + core2 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + core3 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + core3 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
				
				sql = "SELECT * FROM Class WHERE class_name LIKE '" + core4 + "';";
				rs = st.executeQuery(sql);
				rs.first();
				if(rs.getInt("class_priority_lvl") == i)
				{
					sql = "SELECT * FROM Class WHERE class_name LIKE '" + core4 + "';";
					rs = st.executeQuery(sql);
					while(rs.next())
						if(rs.getInt("class_capacity") > 0)
						{
							if(rs.getInt("class_period") == 1 && firstVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								firstVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 2 && secondVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								secondVacant = false;
	
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 3 && thirdVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								thirdVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 4 && fourthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fourthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 5 && fifthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								fifthVacant = false;
	
								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 6 && sixthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								sixthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 7 && seventhVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								seventhVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
							else if(rs.getInt("class_period") == 8 && eighthVacant)
							{
								class_id = rs.getString("class_id");
								newCapacity = rs.getInt("class_capacity") - 1;
								insertSql = "INSERT INTO Student_enrollment (Student_st_id, Class_class_id) VALUES (" + st_id + ", '" + class_id + "');";
								st.executeUpdate(insertSql);
								eighthVacant = false;

								updateSql = "UPDATE Class SET class_capacity = " + newCapacity + " WHERE class_id LIKE '" + class_id + "';";
								st.executeUpdate(updateSql);
								break;
							}
						}
				}
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void CreateClass(String class_id, String class_name, String class_category, String class_period, String teacher_id, String class_capacity, String class_location, String class_lvl, String priority_lvl)
	{
		String sql = "INSERT INTO Class (class_id, class_name, class_period, teacher_id, class_category, class_capacity, class_location, class_priority_lvl, class_level) "
				+ "VALUES ('" + class_id + "', '" + class_name + "', " + class_period + ", '" + teacher_id + "', '" + class_category + "', " + class_capacity + ", '" + class_location + "', " + priority_lvl + ", '" + class_lvl + "');";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateStudent(String st_id, String st_name, String st_grade_lvl, String st_gender, String st_email)
	{
		String sql = "INSERT INTO Student (st_id, st_name, st_grade_lvl, st_gender, st_email) "
				+ "VALUES (" + st_id + ", '" + st_name + "', '" + st_grade_lvl + "', '" + st_gender + "', '" + st_email + "');";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateSubject(String subject_name, String priority_lvl)
	{
		String subj_sql = "INSERT INTO Subject (Subject_Name, Priority_Lvl) "
				+ "VALUES ('" + subject_name + "', " + priority_lvl + ");";
		try {
			st.executeUpdate(subj_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateTeacher(String teacher_id, String teacher_name, String teacher_subject, String teacher_email, String teacher_phone)
	{
		String teacher_sql = "INSERT INTO Teacher (teacher_id, teacher_name, teacher_subject, teacher_email, teacher_phone) "
				+ "VALUES (" + teacher_id + ", '" + teacher_name + "', '" + teacher_subject + "', '" + teacher_email + "', '" + teacher_phone + "');";
		try {
			st.executeUpdate(teacher_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateCounselor(String cou_id, String cou_fname, String cou_lname, String cou_email, String cou_phone, String cou_pw)
	{
		lastCouId = cou_id;
		String cou_login_sql = "INSERT INTO login_credentials (username, password) "
				+ "VALUES ('" + cou_id + "', '" + cou_pw + "');";
		String cou_sql = "INSERT INTO Counselor (cou_id, cou_fname, cou_lname, cou_email, cou_phone) "
				+ "VALUES ('" + cou_id + "', '" + cou_fname + "', '" + cou_lname + "', '" + cou_email + "', '" + cou_phone + "');";
		try {
			st.executeUpdate(cou_sql);
			st.executeUpdate(cou_login_sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void securityQuestion(String question, String answer)
	{
		String sql = "UPDATE login_credentials "
				+ "SET security_question = '" + question + "', security_answer = '" + answer + "' "
				+ "WHERE username LIKE '" + lastCouId + "';";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteStudent(String st_id)
	{
		String sql = "DELETE FROM Student WHERE st_id = " + st_id + ";";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTeacher(String teacher_id)
	{
		String sql = "";
	}
	
	public static void deleteClass(String class_id)
	{
		String sql = "DELETE FROM Class WHERE class_id = " + class_id + ";";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteSubject(String Subject_Name)
	{
		String sql = "DELETE FROM Subject WHERE Subject_Name LIKE '" + Subject_Name + "';";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateFirstPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 1;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 1;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateSecondPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 2;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 2;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateThirdPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 3;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 3;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateFourthPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 4;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 4;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateFifthPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 5;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 5;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateSixthPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 6;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 6;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateSeventhPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 7;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 7;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateOld);
			st.executeUpdate(updateNew);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateEighthPeriod(String st_id, String class_id)
	{
		int old_class_capacity = 0;
		int new_class_capacity = 0;
		String updateOld = null;
		String updateNew = null;
		String oldClassId;
		String deleteSql = "DELETE Student_enrollment FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 8;";
		String insertSql = "INSERT INTO Student_enrollment(Student_st_id, Class_class_id) "
				+ "VALUES (" + st_id + ", '" + class_id + "');";
		String searchSqlOld = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id WHERE Student_enrollment.Student_st_id = " + st_id + " AND Class.class_period = 8;";
		String searchSqlNew = "SELECT * FROM Class WHERE class_id LIKE '" + class_id + "';";
		try {
			rs = st.executeQuery(searchSqlOld);
			if(rs.next())
			{
				old_class_capacity = rs.getInt("Class.class_capacity") + 1;
				oldClassId = rs.getString("Class.class_id");
				updateOld = "UPDATE Class SET class_capacity = " + old_class_capacity + " WHERE class_id LIKE '" + oldClassId + "';";
			}
			rs = st.executeQuery(searchSqlNew);
			if(rs.next())
				new_class_capacity = rs.getInt("class_capacity") - 1;
			updateNew = "UPDATE Class SET class_capacity = " + new_class_capacity + " WHERE class_id LIKE '" + class_id + "';";
			st.executeUpdate(deleteSql);
			st.executeUpdate(insertSql);
			st.executeUpdate(updateNew);
			st.executeUpdate(updateOld);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteSchedule(String st_id)
	{
		String sql = "DELETE FROM Student_enrollment WHERE Student_st_id = " + st_id + ";";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
