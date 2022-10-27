package daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutils.DBUtil;
import utils.Person;

public class PersonDaoImpl01 extends PersonDaoImpl{

	@Override
	public List<Person> getById(String... id) {
		Connection conn=DBUtil.getUtils().getConnection();
		Statement st =null;
		ResultSet rs=null;
		List<Person> list =new ArrayList<>();
		String sql;
		for (String idd:id) {
			sql="select * from login where id='"+idd+"';";
			
			try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()) {
					Person pn =new Person();
					pn.setPk(rs.getInt("pk"));
					pn.setId(rs.getString("id"));
					pn.setPass(rs.getString("pass"));
					list.add(pn);
				}
				
			} catch (SQLException e) {
				System.out.println("getById error!");
				e.printStackTrace();
				return null;
			}
			
		}
		DBUtil.getUtils().close(rs);
		DBUtil.getUtils().close(st);
		DBUtil.getUtils().close(conn);
		return list;
	}

	@Override
	public List<Person> getByPass(String... pass) {
		Connection conn=DBUtil.getUtils().getConnection();
		Statement st=null;
		ResultSet rs=null;
		List<Person> list =new ArrayList<>();	
		for (String pas:pass) {
			String sql="select * from login where pass='"+pas+"';";			
			try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()) {
					Person pn=new Person();
					pn.setPk(rs.getInt("pk"));
					pn.setId(rs.getString("id"));
					pn.setPass(rs.getString("pass"));	
					list.add(pn);
				}			
			} catch (SQLException e) {
				System.out.println("getByPass");
				e.printStackTrace();
				return null;
			}
			
		}
		DBUtil.getUtils().close(rs);
		DBUtil.getUtils().close(st);
		DBUtil.getUtils().close(conn);
		return list;
	}

}
