<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>加入會員</title>
</head>
<body>

    <h1>填寫會員資料</h1>
    <h2>${msg}</h2>

    <form action="${pageContext.request.contextPath}/CustServlet" method="POST">
        會員帳號：<input type="text" name="account" value="${param.account}"> 
        <br><br>
        
        <input type="hidden" name="action" value="insert">
        <input type="submit" value="確認送出">
    </form>

</body>
</html>