<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>

<div class="container">
	<div class="col-xs-12" style="margin:14px auto;">
		<label style="font-size:20px;">유저 포인트 목록</label>
	</div>
    <div class="col-ex-12">	
	<table class="table table-hover">
		<tr>
			<th>User_id</th>
			<th>User_point</th>
		</tr>
			<c:forEach var="l" items="${point}">
			<tr >
				<td>${l.user_id}</td>
				<td>${l.user_point }</td>
			</tr>
			</c:forEach>
	</table>
    </div>
</div>

</body>
</html>

</layoutTag:layout>