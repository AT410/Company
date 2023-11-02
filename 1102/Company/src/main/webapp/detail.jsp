<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 未ログインの場合は、ログインページへリダイレクト -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>詳細ページ</title>
</head>
<body>
	<h1>社員情報</h1>
	
	<!-- 社員情報詳細 -->
	<main>
		<!-- 一覧 -->
		<div class="detail__show">
			<form>
				<!-- ID -->
				<div>
					<label for="detail_id">ID</label>
					<input type="text" id="detail_id">
				</div>
				<!-- 名前 -->
				<div>
					<label for="detail_name">名前</label>
					<input type="text" id="detail_id">
				</div>
				<!-- 所属部署 -->
				<div>
					<label for="detail_type">所属部署</label>
					<input type="text" id="detail_type">
				</div>
				<!-- 生年月日 -->
				<div>
					<label for="detail_birthday">生年月日</label>
					<input type="text" id="detail_birthday">
				</div>
				<!-- 性別 -->
				<div>
					<label for="detail_gender">性別</label>
					<input type="text" id="detail_gender">
				</div>
				<!-- 電話番号 -->
				<div>
					<label for="detail_phone">電話番号</label>
					<input type="text" id="detail_phone">
				</div>
				<!-- メールアドレス -->
				<div>
					<label for="detail_mail">メールアドレス</label>
					<input type="text" id="detail_mail">
				</div>
				<!-- 保有資格・検定 -->
				<div>
					<label for="detail_license">保有資格・検定</label>
					<input type="text" id="detail_license">
				</div>
				<!-- 入社日 -->
				<div>
					<label for="detail_hire_date">入社日</label>
					<input type="text" id="detail_hire_date">
				</div>
				<!-- 退職日 -->
				<div>
					<label for="detail_leaving_day">退職日</label>
					<input type="text" id="detail_leaving_day">
				</div>
				<!-- 各種ボタン -->
				<input type="button" value="登録"/>
			</form>
		</div>
	</main>
</body>
</html>