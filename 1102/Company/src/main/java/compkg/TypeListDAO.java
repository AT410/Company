package compkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeListDAO extends DAO{

	//全件取得
	public ArrayList<TypeListDTO> selectALL()
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<TypeListDTO> list = new ArrayList<TypeListDTO>();
		
		String sql = "SELECT * FROM typemaster";
		
		try
		{
			con = TypeListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				TypeListDTO obj = new TypeListDTO();
				obj.setCode(rs.getString("code"));
				obj.setTypeName(rs.getString("typename"));
				list.add(obj);
			}
		}
		catch(SQLException e)
		{
			System.out.println(sql);
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
		return list;
	}
	
	//コードをもとに部署名を返す
	public String getTypeName(String code)
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		String result = null;
		
		String sql = "SELECT typename FROM typemaster"
				+ "WHERE code = '" + code + "'";
		
		try
		{
			con = TypeListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				result = rs.getString("typename");
			}
			
		}
		catch(SQLException e)
		{
			System.out.println(sql);
			System.out.println("Error:"+e.getMessage());
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
		return result;
	}
}