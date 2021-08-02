import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
	
	static final String url = "jdbc:mysql://127.0.0.1:3306/schedgendb";
	static final String user = "root";
	static final String password = "vergil92";
	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	public static void connection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url,user,password);
			String sql = "SELECT * FROM `counselor`;";
			st = con.createStatement(
	                ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(sql);
			rs.first();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean uniqueCouUser(String username)
	{
		String sql = "SELECT * FROM `login_credentials` "
				+ "WHERE username = '" + username + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean login(String username, String password)
	{
		String sql = "SELECT * FROM `login_credentials` "
				+ "WHERE username = '" + username + "' AND password = '" + password + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean roomIsVacant(String roomNum, String period)
	{
		String sql = "SELECT * FROM Class WHERE class_location LIKE '" + roomNum + "' AND class_period = " + period + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean classIdIsUnique(String id)
	{
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static void getCoreClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_category LIKE 'Math' OR class_category LIKE 'Science' OR class_category LIKE 'Social Studies' OR class_category LIKE 'English' AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(list.isEmpty())
					list.add(rs.getString("class_name"));
				else
				{
					if(list.get(list.size() - 1).equals(rs.getString("class_name")))
					{
						
					}
					else
						list.add(rs.getString("class_name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getElectiveClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_category LIKE 'Extra Curricular' AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(list.isEmpty())
					list.add(rs.getString("class_name"));
				else
				{
					if(list.get(list.size() - 1).equals(rs.getString("class_name")))
					{
						
					}
					else
						list.add(rs.getString("class_name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getLunches(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_category LIKE 'N/A';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				if(list.isEmpty())
					list.add(rs.getString("class_name"));
				else
				{
					if(list.get(list.size() - 1).equals(rs.getString("class_name")))
					{
						
					}
					else
						list.add(rs.getString("class_name"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getAllClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFirstPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 1 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getSecondPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 2 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getThirdPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 3 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFourthPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 4 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFifthPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 5 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getSixthPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 6 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getSeventhPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 7 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getEighthPeriodClasses(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Class WHERE class_period = 8 AND class_capacity > 0;";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("class_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getClassName(String id)
	{
		String name = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getClassCategory(String id)
	{
		String category = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				category = rs.getString("class_category");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	
	public static String getClassLvl(String id)
	{
		String lvl = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				lvl = rs.getString("class_level");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lvl;
	}
	
	public static String getClassPriorityLvl(String id)
	{
		String plvl = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				plvl = rs.getString("class_priority_lvl");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plvl;
	}
	
	public static String getClassTeacher(String id)
	{
		String teacherId = "";
		String teacherName = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				teacherId = rs.getString("teacher_id");
			teacherName = Teacher.getTeacherName(teacherId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherName;
	}
	
	public static String getClassCapacity(String id)
	{
		String capacity = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				capacity = rs.getString("class_capacity");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capacity;
	}
	
	public static String getClassLocation(String id)
	{
		String location = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				location = rs.getString("class_location");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
	
	public static String getClassPeriod(String id)
	{
		String period = "";
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_period");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static void deleteClass(String id)
	{
		String sql1 = "DELETE FROM Class WHERE class_id LIKE '" + id + "';";
		String sql2 = "DELETE FROM Student_enrollment WHERE Class_class_id LIKE '" + id + "';";
		try {
			st.executeUpdate(sql2);
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean classIdExists(String id)
	{
		String sql = "SELECT * FROM Class WHERE class_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean teacherIsAvailable(String teacher_id, String period)
	{
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + teacher_id + "' AND class_period = " + period + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public static void updateClass(String class_id, String class_name, String class_category, String class_period, String teacher_id, String class_capacity, String class_location, String class_lvl, String priority_lvl)
	{
		String sql = "UPDATE Class "
				+ "SET class_name = '" + class_name + "', class_period = " + class_period + ", teacher_id = '" + teacher_id + "', class_category = '" + class_category + "', class_capacity = " + class_capacity + ", class_location = '" + class_location + "', class_priority_lvl = " + priority_lvl + ", class_level = '" + class_lvl + "' "
						+ "WHERE class_id LIKE '" + class_id + "';";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
