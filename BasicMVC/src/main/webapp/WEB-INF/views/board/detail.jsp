<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<a href="/">게시글 목록</a>
	<h1>게시글</h1>
		<p>
			카테고리 : <input type="text" name="category" readonly="readonly"
				value="${data.category }" />
		</p>
		<p>
			제목 : <input type="text" name="title" readonly="readonly"
				value="${data.title }" />
		</p>
		<p>
			작성자 : <input type="text" name="author" readonly="readonly"
				value="${data.author }" />
		</p>
		<p>내용</p>
		<textarea cols="40" rows="10" name="content" readonly="readonly">${data.content }</textarea>
		<p>
			<a href="/modify?boardId=${boardId }">수정</a>
			<form method="post" action="/remove">
				<input type="hidden" name="boardId" value="${boardId }">
				<input type="submit" value="삭제">
			</form>
		</p>
</body>
</html>