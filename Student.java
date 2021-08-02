import java.sql.SQLException;

public class Student extends DBConnection {
	
	public static boolean stIdisUnique(String st_id)
	{
		String sql = "SELECT * FROM Student WHERE st_id = " + st_id + ";";
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
	
	public static boolean studentExists(String id)
	{
		String sql = "SELECT * FROM Student WHERE st_id = " + id + ";";
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
		String firstPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 1;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				firstPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstPeriod;
	}
	
	public static String getSecondPeriod(String id)
	{
		String secondPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 2;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				secondPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secondPeriod;
	}
	
	public static String getThirdPeriod(String id)
	{
		String thirdPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 3;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				thirdPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thirdPeriod;
	}
	
	public static String getFourthPeriod(String id)
	{
		String fourthPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 4;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				fourthPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fourthPeriod;
	}
	
	public static String getFifthPeriod(String id)
	{
		String fifthPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 5;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				fifthPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fifthPeriod;
	}
	
	public static String getSixthPeriod(String id)
	{
		String sixthPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 6;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				sixthPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sixthPeriod;
	}
	
	public static String getSeventhPeriod(String id)
	{
		String seventhPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 7;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				seventhPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seventhPeriod;
	}
	
	public static String getEighthPeriod(String id)
	{
		String eighthPeriod = "NONE";
		String sql = "SELECT * FROM Student_enrollment INNER JOIN Class ON Student_enrollment.Class_class_id LIKE Class.class_id "
				+ "WHERE Student_enrollment.Student_st_id = " + id + " AND Class.class_period = 8;";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				eighthPeriod = rs.getString("class_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eighthPeriod;
	}
	
	public static String getName(String id)
	{
		String name = "NONE";
		String sql = "SELECT * FROM Student WHERE st_id = " + id + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("st_name");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getGradeLvl(String id)
	{
		String name = "NONE";
		String sql = "SELECT * FROM Student WHERE st_id = " + id + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("st_grade_lvl");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getGender(String id)
	{
		String name = "NONE";
		String sql = "SELECT * FROM Student WHERE st_id = " + id + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("st_gender");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getEmail(String id)
	{
		String name = "NONE";
		String sql = "SELECT * FROM Student WHERE st_id = " + id + ";";
		try {
			rs = st.executeQuery(sql);
			if(rs.next())
				name = rs.getString("st_email");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public static void deleteProfile(String id)
	{
		String sql = "DELETE FROM Student_enrollment WHERE Student_st_id = " + id + ";";
		String sql1 = "DELETE FROM Student WHERE st_id = " + id + ";";
		try {
			st.executeUpdate(sql);
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(String id, String name, String gender, String email, String gradelvl)
	{
		String sql = "UPDATE Student "
				+ "SET st_name = '" + name + "', st_grade_lvl = '" + gradelvl + "', st_gender = '" + gender + "', st_email = '" + email + "' "
						+ "WHERE st_id = " + id + ";";
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
