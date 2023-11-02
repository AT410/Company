<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="compkg.*" %>
<%@page import="java.util.*" %>
<%@ page isErrorPage="true" %>
<!-- 未ログインの場合は、ログインページへリダイレクト -->
<%
	//ログイン情報取得
	AdminUserDTO admin = (AdminUserDTO)session.getAttribute("AdminUser");
	if(admin == null)
	{
		response.sendRedirect("LogIn.jsp");
	}
	
	//一覧全件取得
	MemberListDAO dao = new MemberListDAO();
	ArrayList<MemberListDTO> memDtos = dao.SelectAllSub();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録社員一覧</title>
</head>
<body>
	<h1>一覧表</h1>
    <form action="/Company/MemberListServlet" method="post">
	<table border="1">
	    <tr>
			<!-- チェックリスト -->
			<th>選択</th>
			<th>ID</th>
			<th>名前</th>
			<th>部署</th>
			<th>年齢</th>
			<th>性別</th>
			<th>電話番号</th>
			<th>メールアドレス</th>
	    </tr>
	    <!-- 一覧データ↓ -->
	    <% for(MemberListDTO obj:memDtos)
	    {%>
		<tr>
			<td><input type="radio" name="menber_check" value="<%=obj.getId()%>"></td>
	    	<td><%=obj.getId() %></td>
	    	<td><%=obj.getName() %></td>
	    	<td><%=obj.getTypeName() %></td>
	    	<td><%=obj.getAge() %></td>
			<td><%=obj.getGenderStr() %></td>
			<td><%=obj.getPhone() %></td>
			<td><%=obj.getMail() %></td>
	    </tr>
	    <%} %>
	</table>
	<div>
		<button type="submit" name="action" value="info">詳細</button>
		<button type="submit" name="action" value="save">登録</button>
		<button type="submit" name="action" value="delete">削除</button>
	</div>
    </form>
	
	<a href="/Company/detail.jsp">詳細</a>	
	<a href="/Company/detail.jsp">登録</a>	
	<a href="/Company/detail.jsp">削除</a>
</body>
</html>