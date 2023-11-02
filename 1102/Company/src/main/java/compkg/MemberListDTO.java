package compkg;

import java.sql.Date;

public class MemberListDTO {
	private String id;	//社員ID
	private String name;	//名前
	private String typecode;	//所属部署
	private String typename; //所属部署名（サブクエリにて部署テーブルから取得）
	private Date birthday;	//生年月日
	private String age;	//年齢（生年月日から逆算）
	private Boolean gender;	//性別
	private String genderStr;//性別（CASE文で分ける）
	private String phone;	//電話番号
	private String mail;	//E-mail
	private String license;	//取得資格・検定
	private Date hire_day;	//入社日
	private Date leaving_day;//退社日
	
	//Setter
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setTypeCode(String typecode)
	{
		this.typecode = typecode;
	}
	
	public void setBirthDay(Date birthday)
	{
		this.birthday = birthday;
	}
	
	public void setGender(Boolean gender)
	{
		this.gender = gender;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public void setMail(String mail)
	{
		this.mail = mail;
	}
	
	public void setLicense(String license)
	{
		this.license = license;
	}
	
	public void setHire_Day(Date hire_day)
	{
		this.hire_day = hire_day;
	}
	
	public void setLeavingDay(Date leavingday)
	{
		this.leaving_day = leavingday;
	}
	
	//Sub
	public void setTypeName(String typeName)
	{
		this.typename = typeName;
	}
	
	public void setAge(String age)
	{
		this.age = age;
	}
	
	public void setGenderStr(String genderstr)
	{
		this.genderStr = genderstr;
	}
	
	//getter
	public String getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTypeCode()
	{
		return typecode;
	}
	
	public Date getBirthDay()
	{
		return birthday;
	}
	
	public Boolean getGender()
	{
		return gender;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public String getMail()
	{
		return mail;
	}
	
	public String getLicense()
	{
		return license;
	}
	
	public Date getHire_Day()
	{
		return hire_day;
	}
	
	public Date getLeaving_Day()
	{
		return leaving_day;
	}
	
	//Sub
	public String getTypeName()
	{
		return typename;
	}
	
	public String getAge()
	{
		return age;
	}
	
	public String getGenderStr()
	{
		return genderStr;
	}
}
