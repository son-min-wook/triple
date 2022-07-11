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
		<label style="font-size:20px;">장소 목록</label>
		<button class="btn btn-primary btn-sm" style="float:right;" onclick="location.href='/insert'">장소 등록</button>
	</div>
    <div class="col-ex-12">	
	<table class="table table-hover">
		<tr>
			<th>Place_id</th>
			<th>Place_nm</th>
		</tr>
			<c:forEach var="l" items="${list}">
			<tr onclick="location.href='/detail/${l.place_id}'">
				<td>${l.place_id}</td>
				<td>${l.place_nm }</td>
			</tr>
			</c:forEach>
	</table>
    </div>
</div>

</body>
</html>

</layoutTag:layout>