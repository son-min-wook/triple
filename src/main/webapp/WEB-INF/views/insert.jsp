<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<layoutTag:layout>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Form</title>
</head>
<body>


<div class="container">
	<div class="col-xs-12" style="margin:15px auto;">
		<label style="font-size:20px;">게시글 작성</label>
	</div>
	
	<div class="col-xs-12">
		<form action="/insertProc" method="post" enctype="multipart/form-data">
		<div class="form-group">
	
			<label for=""place_id"">ID</label>
			<input type="text" class="form-control" id =""place_id"" name="place_id" placeholder="ID를 입력하세요">
		</div>
		<div class="form-group">
			<label for="place_nm">장소명</label>
			<input type="text" class="form-control" id="place_nm" name="place_nm" placeholder="이름을 입력하세요">
		</div>
		<button type="submit" class="btn btn-primary btn-sm" style="float:right;">저장</button>
		</form>
	</div>
</div>
</body>
</html>

</layoutTag:layout>