<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="compkg.*" %>
<%@page import="java.util.*" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録・更新ページ</title>
</head>
<body>
<% String mode = (String)request.getAttribute("mode"); %>
	<h1>社員情報(<%=mode %>)</h1>
	
	<!-- 社員情報詳細 -->
	<main>
		<!-- 一覧 -->
		<div class="submit__show">
			<form action="/Company/SubmitServlet" method="post">
				<!-- ID -->
				<div>
					<label for="submit_id">ID</label>
					<input type="text" id="submit_id" name="submit_id" required>
				</div>
				<!-- 名前 -->
				<div>
					<label for="submit_name">名前</label>
					<input type="text" id="submit_name" name="submit_name" required>
				</div>
				<!-- 所属部署 -->
				<div>
					<label for="submit_type">所属部署</label>
					<% 	TypeListDAO dao = new TypeListDAO();
						ArrayList<TypeListDTO> tydtos = dao.selectALL();
					%>
					<select id=submit_type name="submit_type">
						<option disabled selected required>選択してください</option>
						<% for(TypeListDTO obj:tydtos){ %>
						<option value="<%=obj.getCode() %>" required><%=obj.getTypeName() %></option>
						<%} %>
					</select>
				</div>
				<!-- 生年月日 -->
				<div>
					<label for="submit_birthday">生年月日</label>
					<input type="date" id="submit_birthday" name="submit_birthday" required>
				</div>
				<!-- 性別 -->
				<div>
					<label for="submit_gender">性別</label>
					<select id="submit_gender" name="submit_gender">
						<option disabled selected required>選択してください</option>
						<option value="0">男</option>
						<option value="1">女</option>
					</select> 
				</div>
				<!-- 電話番号 -->
				<div>
					<label for="submit_phone">電話番号</label>
					<input type="text" id="submit_phone" name="submit_phone" required>
				</div>
				<!-- メールアドレス -->
				<div>
					<label for="submit_mail">メールアドレス</label>
					<input type="text" id="submit_mail" name="submit_mail" required>
				</div>
				<!-- 保有資格・検定 -->
				<div>
					<label for="submit_license">保有資格・検定</label>
					<input type="text" id="submit_license" name="submit_license">
				</div>
				<!-- 入社日 -->
				<div>
					<label for="submit_hire_date">入社日</label>
					<input type="date" id="submit_hire_date" name="submit_hire_date" required>
				</div>
				<!-- 退職日 -->
				<div>
					<label for="submit_leaving_day">退職日</label>
					<input type="date" id="submit_leaving_day" name="submit_leaving_day">
				</div>
				<!-- 各種ボタン -->
				<button type="submit" name="action" value="<%=mode%>">
					<% if(mode=="new"){ %>
					登録
					<%}else if(mode=="update"){ %>
					更新
					<%} %>
				</button>
			</form>
		</div>
	</main>
</body>
</html>