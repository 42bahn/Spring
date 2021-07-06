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
	<h1>게시글 작성</h1>
	<form method="post" action="/create">
		<p> 카테고리 : <input type="text" name="category" /> </p>
		<p> 제목 : <input type="text" name="title" /> </p>
		<p> 작성자 : <input type="text" name="author" /> </p>
		<p> 내용 </p>
		<textarea cols="40" rows="10" name="content"></textarea>
		<button type="submit">등록</button>
	</form>
</body>
</html>