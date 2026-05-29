<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增會員帳號</title>
</head>
<body>

	<h3>資料新增：</h3>
<form method="POST" action="mem.do" name="form1">
	<tr>
		<td>會員帳號:</td>
		<td><input type="text" name="account" size="45"/></td>
    </tr>
    
    <br>
    
    <input type="hidden" name="action" value="insert">
    <input type="submit" value="送出新增">
</form>	

</body>
</html>