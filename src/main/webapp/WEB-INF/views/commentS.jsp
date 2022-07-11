<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script>
var place_id = '${detail.place_id}';
commentList(); 

$('[name=commentInsertBtn]').click(function(){
	commentList();
});

function commentList(){
	
	$.ajax({
		url : '/detail/review',
	type :'get',
	data : {'place_id':place_id},
	success : function(data){
		var a ='';
		var sq = 0;
		$.each(data,function(key,value){
			a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
			a += '<div class="commentInfo'+sq+'">'+'작성자 : '+ value.user_id;
			a += '<a onclick="commentUpdate('+sq+',\''+value.review_txt+'\');"> 수정 </a>';
			a += '<a onclick="commentDelete('+sq+');"> 삭제 </a> </div>';
			a += '<div class="commentContent'+sq+'"><p> 내용 : '+value.review_txt + '</p>';
			a += '<div class="commentContent'+sq+'"><p> 사진 : '+value.img_id + '</p>';
			a += '</div></div>';
			sq++;
		});
		$(".commentList").html(a);
	}
	});
}


function commentUpdate(cno,content){
	var a = '';
	
	a += '<div class="input-group">';
	a += '<input type="text" class="form-control" name="content" value="'+content+'"/>';
	a += '<span class="input-group-btn"><button class = "btn btn-default" type="button" onclick="commentUpdateProc('+cno+');">수정</button></span>';
	a += '</div>';
	
	$('.commentContent'+cno).html(a);
}

function commentUpdateProc(cno){
	var updatecontent = $('[name=content_'+cno+']').val();
	
	$.ajax({
		url : '/comment/update',
		type : 'post'.
		data : {'content' : updateContent, 'cno' : cno},
		success : function(data){
			if(data ==1) commentList(bno);
		}
	});
}

function commentDelete(cno){
	$.ajax({
		url: '/comment/delete/'+cno,
		type : 'post',
		success : function(data){
			if(data ==1)commentList(bno);
		}
	});
}

$(document).ready(function(){
	commentList();
});
</script>