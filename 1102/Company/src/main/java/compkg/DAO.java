package compkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//データベース接続　親クラス
public class DAO {
	//接続用定数
	protected static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	protected static final String Connection_URL = "jdbc:mysql://localhost/Company_db?serverTimezone=UTC";
	protected static final String DB_USER = "root";
	protected static final String DB_PASS = "Q3bjAZGX";
	private static Connection con = null;
	
	protected static Connection getConnection()
	{
		try
		{
			Class.forName(JDBC_Driver);
			con = DriverManager.getConnection(Connection_URL,DB_USER,DB_PASS);
			return con;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new IllegalStateException(e);
		}
		return null;
	}
}
