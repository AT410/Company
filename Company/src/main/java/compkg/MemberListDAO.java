package compkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberListDAO extends DAO{

	//全件取得
	public ArrayList<MemberListDTO> SelectAll()
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<MemberListDTO> list = new ArrayList<MemberListDTO>();
		
		String sql = "SELECT * FROM main";
		
		try
		{
			con = MemberListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				MemberListDTO obj = new MemberListDTO();
				obj.setId(rs.getString("id"));
				obj.setName("name");
				obj.setTypeCode(rs.getString("typecode"));
				obj.setBirthDay(rs.getDate("birthday"));
				obj.setGender(rs.getBoolean("gender"));
				obj.setPhone(rs.getString("phone"));
				obj.setMail(rs.getString("email"));
				obj.setLicense(rs.getString("license"));
				obj.setHire_Day(rs.getDate("hire_day"));
				obj.setLeavingDay(rs.getDate("leaving_day"));
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
	
	//一覧用取得（部署名サブクエリ）
	public ArrayList<MemberListDTO> SelectAllSub()
	{
		Connection con = null;
		PreparedStatement stmt = null;
		
		ArrayList<MemberListDTO> list = new ArrayList<MemberListDTO>();
		
		String sql = "SELECT m.id,m.name, "
					+ "(SELECT typename FROM typemaster WHERE code = m.typecode) typename,"
					+ "FLOOR((CURDATE() - birthday) / 10000) AS age,"
					+ "CASE WHEN gender = '0' THEN '男' ELSE '女' END AS gender,"
					+ "m.phone,m.email "
					+ "FROM main m";
		
		try
		{
			con = MemberListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				MemberListDTO obj = new MemberListDTO();
				obj.setId(rs.getString("id"));
				obj.setName(rs.getString("name"));
				obj.setTypeName(rs.getString("typename"));
				obj.setAge(rs.getString("age"));
				obj.setGenderStr(rs.getString("gender"));
				obj.setPhone(rs.getString("phone"));
				obj.setMail(rs.getString("email"));
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
	
	//登録ユーザー確認
	public Boolean chaeckUserId(String targetId)
	{
		Connection con = null;
		PreparedStatement stmt= null;
		
		int check = 0;
		
		String sql = "SELECT COUNT(*) AS count "
				+ "FROM main "
				+ "WHERE id = '" +targetId+"' ";
		
		try {
			con = MemberListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				check = rs.getInt("count");
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLERROR:" + e.getMessage());
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
		return check>0 ? true:false;
	}
	
	//社員情報新規登録
	public void Insert(MemberListDTO inData)
	{
		//接続変数宣言
		Connection con = null;
		PreparedStatement stmt = null;
		
		int result = 0;
		
		//InsertSQL文作成
		String sql = "INSERT INTO main "
				+ "(id,name,typecode,birthday,gender,phone,email,license,hire_day,leaving_day) "
				+ "VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?)";
		
		try
		{
			con = MemberListDAO.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, inData.getId());
			stmt.setString(2, inData.getName());
			stmt.setString(3, inData.getTypeCode());
			stmt.setDate(4, inData.getBirthDay());
			stmt.setBoolean(5, inData.getGender());
			stmt.setString(6, inData.getPhone());
			stmt.setString(7, inData.getMail());
			stmt.setString(8, inData.getLicense());
			stmt.setDate(9, inData.getHire_Day());
			stmt.setDate(10, inData.getLeaving_Day());
			result = stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			if(stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
