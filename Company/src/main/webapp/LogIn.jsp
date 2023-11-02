<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<script type="text/javascript">
	function InputCheck()
	{
		var userck = document.getElementById("LoginId");
		var passck = document.getElementById("PassWord");
		if(userck.value===""||passck.value==="")
		{
			alert("入力値が有効ではありません");
			return false;
		}
		else
		{
			return true;
		}
	}
</script>
</head>
<body>
	<h1>ログイン画面</h1>
	<form action="/Company/LoginServlet" method="post">
		<label for="LoginId">ログインID</label>
		<input type="text" id="LoginId" name="LoginId">
		<label for="PassWord">パスワード</label>
		<input type="password" id="PassWord" name="PassWord">
		<input type="submit" value="登録" onClick="return InputCheck();">
	</form>
	<a href="/Company/MemberList.jsp">LINK</a>
</body>
</html>