import java.sql.SQLException;
import java.util.ArrayList;

public class Teacher extends DBConnection {
	
	public static String getTeacherId(String name)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_name LIKE '" + name + "';";
		String id = null;
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				id = rs.getString("teacher_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static String getTeacherName(String id)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		String name = "";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("teacher_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static void getMathTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'Math';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getScienceTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'Science';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getSsTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'Social Studies';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getEnglishTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'English';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getEcTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'Extra Curricular';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getOtherTeachers(ArrayList<String> list)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_subject LIKE 'Other';";
		try {
			rs = st.executeQuery(sql);
			while(rs.next())
				list.add(rs.getString("teacher_name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean teacherIdIsUnique(String id)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
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

	public static boolean teacherExists(String id)
	{
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
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
	
	public static String getFirstPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 1;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getSecondPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 2;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getThirdPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 3;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getFourthPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 4;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getFifthPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 5;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getSixthPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 6;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getSeventhPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 7;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getEighthPeriod(String id)
	{
		String period = "NONE";
		String sql = "SELECT * FROM Class WHERE teacher_id LIKE '" + id + "' AND class_period = 8;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				period = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return period;
	}
	
	public static String getName(String id)
	{
		String name = "NONE";
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("teacher_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getSubject(String id)
	{
		String subject = "NONE";
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				subject = rs.getString("teacher_subject");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}
	
	public static String getEmail(String id)
	{
		String email = "NONE";
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				email = rs.getString("teacher_email");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	
	public static String getPhone(String id)
	{
		String phone = "NONE";
		String sql = "SELECT * FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				phone = rs.getString("teacher_phone");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return phone;
	}
	
	public static void updateTeacher(String id, String name, String subject, String email, String phone)
	{
		String sql = "UPDATE Teacher "
				+ "SET teacher_name = '" + name + "', teacher_subject = '" + subject + "', teacher_email = '" + email + "', teacher_phone = '" + phone + "' "
						+ "WHERE teacher_id LIKE '" + id + "';";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteTeacher(String id)
	{
		String sql = "DELETE FROM Teacher WHERE teacher_id LIKE '" + id + "';";
		String sql1 = "UPDATE Class "
				+ "SET teacher_id = '00000' "
				+ "WHERE teacher_id LIKE '" + id + "';";
		try {
			st.executeUpdate(sql1);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
