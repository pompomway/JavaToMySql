package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	

	
	private final String JDBC_DRIVE="com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL="jdbc:mysql://localhost:3306/dbconnection?serverTimezone=UTC";
	private final String JDBC_USER="root";
	private final String JDBC_PASS="123456";
	
	private DBUtil() {}
	
	public static DBUtil getUtils() {
		return new DBUtil();
	}
	
	private Connection conn;
	
	public Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVE);
			conn=DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DBUtil error!");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement ps) {
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(Statement st) {
		if (st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet rs) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
