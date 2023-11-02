package compkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminUserDAO extends DAO {

	//管理者登録ユーザー全件取得
	public ArrayList<AdminUserDTO> selectAll()
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<AdminUserDTO> list = new ArrayList<AdminUserDTO>();
		
		String sql = "SELECT * FROM adminuser";
		
		try {
			con = AdminUserDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				AdminUserDTO obj = new AdminUserDTO();
				obj.setId(rs.getString("id"));
				obj.setPass(rs.getString("pass"));
				list.add(obj);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error:"+e.getMessage());
		}
		finally
		{
			if(stmt != null)
			{
				try {
					stmt.close();
				}
				catch(SQLException e)
				{
					
				}
			}
			if(con != null)
			{
				try {con.close();}catch(SQLException e) {}
			}
		}
		return list;
	}
	
	//管理ユーザーの登録確認
	public Boolean CheckAdminUser(AdminUserDTO obj)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		int check = 0;
		
		String sql = "SELECT COUNT(*) AS count "
				+ "FROM adminuser "
				+ "WHERE id = '"+ obj.getId() + "' "
				+ "AND pass = '"+ obj.getPass() + "'";
		
		try
		{
			con = AdminUserDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				check =rs.getInt("count");
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}
		finally
		{
			if(stmt != null)
			{
				try {stmt.close();}catch(SQLException e) {}
			}
			if(con != null)
			{
				try {con.close();}catch(SQLException e) {}
			}
		}
		return check > 0 ? true:false;
	}
}
