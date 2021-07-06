<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<a href="/">홈</a>
	<h1>게시글 수정</h1>
	<form method="post">
		<input type="hidden" value="${data.boardId }">
		<p> 카테고리 : <input type="text" name="category" value="${data.category }"/> </p>
		<p> 제목 : <input type="text" name="title" value="${data.title }" /> </p>
		<p> 작성자 : <input type="text" name="author" value="${data.author }" /> </p>
		<p> 내용 </p>
		<textarea cols="40" rows="10" name="content">${data.content }</textarea>
		<p><input type="submit" value="수정"></p>
	</form>
</body>
</html>