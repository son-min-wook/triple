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
		<label style="font-size:20px;">댓글 리스트</label>
	</div>
    <div class="col-ex-12">	
	<table class="table table-hover">
		<tr>
			<th>User_id</th>
			<th>Place_id</th>
			<th>Review_id</th>
			<th>Review_txt</th>
			<th>Review_tm</th>
			<th>Img_id</th>
		</tr>
			<c:forEach var="l" items="${review}}">
			<tr onclick="location.href='/detail/${l.place_id}'">
				<td>${l.user_id}</td>
				<td>${l.place_id }</td>
				<td>${l.review_id}</td>
				<td>${l.review_txt }</td>
				<td>${l.review_tm}</td>
				<td>${l.img_id }</td>
				<button class="btn btn-primary btn-sm" style="float:right;" onclick="location.href='/review/update/'">수정</button>
				<button class="btn btn-primary btn-sm" style="float:right;" onclick="location.href='/review/delete'">삭제</button>
			</tr>
			</c:forEach>
	</table>
    </div>
</div>

</body>
</html>

</layoutTag:layout>