<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layoutTag" tagdir="/WEB-INF/tags"%>
<html>
<head>
</head>
<body>
<layoutTag:layout>
<div class="container">
	<div class="col-xs-12" style="margin:15px auto;">
		<label style="font-size:20px;">장소 상세</label>
		</div>
		
		<div class="col-xs-12">
			
				<dl class="dl-horizontal">
					<dt>장소명</dt>
					<dd>${detail.place_nm }</dd>
					<dt>장소 ID</dt>
					<dd>${detail.place_id }</dd>
					<dt>최초 댓글 작성자</dt>
					<dd>${detail.first_review_id }</dd>
				</dl>
			
			<div class="btn-group btn-group-sm" role="group" style="float:right;">
				<button type="button" class="btn btn-default" onclick="location.href='/delete/${detail.place_id}'">삭제</button>
				<button type="button" class="btn btn-default" onclick="location.href='/list'">목록</button>
			</div>
		</div>
		
		<div class="container">
			<label for="review">댓글</label>
			<form action="/events" method="post">
				<div class="input-group">
					<input type="hidden" name="type" value="REVIEW"/>
					<input type="text"  class="form-control" name="action" id="action" placeholder="Action (ADD/MOD/DELETE)">
					<input type="text"  class="form-control" name="review_id" id="review_id" placeholder="리뷰ID">
					<input type="text" class="form-control" id="user_id" name ="user_id" placeholder="유저ID">
					<input type="text" class="form-control" id="content" name ="content" placeholder="내용을 입력하세요.">
					<input type="text" class="form-control" id="attachedPhotoIds" name ="attachedPhotoIds" placeholder="사진 List">
					<input type="hidden" name="place_id" value="${detail.place_id}"/>

					<span class="input-group-btn">
						<button class="btn btn-default" type="submit" name="commentSaveBtn">제출</button>
					</span>
				</div>
			</form>
		</div>
</div>

</layoutTag:layout>
</body>
</html>
