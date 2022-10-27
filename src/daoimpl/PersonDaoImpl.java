package daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PersonDao;
import dbutils.DBUtil;
import utils.Person;

public abstract class PersonDaoImpl implements PersonDao{

	@Override
	public void save(Person person) {
		Connection conn=DBUtil.getUtils().getConnection();
		PreparedStatement ps=null;
		String sql="insert into login (id,pass) value (?,?);";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, person.getId());
			ps.setString(2, person.getPass());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("save error!");
			e.printStackTrace();
		}finally{
			DBUtil.getUtils().close(ps);
			DBUtil.getUtils().close(conn);
		}
		
	}

	@Override
	public int update(Person person) {
		Connection conn=DBUtil.getUtils().getConnection();
		PreparedStatement ps=null;
		String sql="update login set pass=? where pk=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, person.getPass());
			ps.setInt(2, person.getPk());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("update error!");
			e.printStackTrace();
		}finally {
			DBUtil.getUtils().close(ps);
			DBUtil.getUtils().close(conn);
		}
		return 0;
	}

	@Override
	public int delete(int pk) {
		Connection conn=DBUtil.getUtils().getConnection();
		PreparedStatement ps=null;
		String sql="delete from login where pk=?;";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, pk);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("delete error!");
			e.printStackTrace();
		}finally {
			DBUtil.getUtils().close(ps);
			DBUtil.getUtils().close(conn);
		}
		return 0;
	}

	@Override
	public Person getByPk(int pk) {
		Connection conn=DBUtil.getUtils().getConnection();
		Statement st =null;
		ResultSet rs=null;
		Person pn=new Person();
		String sql="select * from login where pk="+pk+";";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				pn.setPk(pk);
				pn.setId(rs.getString("id"));
				pn.setPass(rs.getString("pass"));
			}
		} catch (SQLException e) {
			System.out.println("getByPk error!");
			e.printStackTrace();
		}finally {
			DBUtil.getUtils().close(rs);
			DBUtil.getUtils().close(st);
			DBUtil.getUtils().close(conn);
		}
		
		return pn;
	}



}
