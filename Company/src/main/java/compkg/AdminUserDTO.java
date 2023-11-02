package compkg;

public class AdminUserDTO {
	private String id;		//ログインID
	private String password;//パスワード
	
	//Setter
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setPass(String pass)
	{
		this.password = pass;
	}
	
	//getter
	public String getId()
	{
		return this.id;
	}
	
	public String getPass()
	{
		return this.password;
	}
}
