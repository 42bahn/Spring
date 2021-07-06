<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="/">홈</a>
	<br>
	<a href="/create">게시글 작성</a>
	<div>
		<form method="POST" action="/search">
			<input type="search" name="keyword" placeholder="검색"> <input
				type="submit" value="검색">
		</form>
	</div>
	<table border="1">
		<thead>
			<tr>
				<td bgcolor="#D8D8D8">카테고리</td>
				<td>제목</td>
				<td bgcolor="#D8D8D8">작성자</td>
				<td bgcolor="#D8D8D8">작성일자</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data }">
				<tr>
					<td bgcolor="#D8D8D8" align="center">${row.category }</td>
					<td width="500"><a href="/detail?boardId=${row.board_id }">${row.title }</a></td>
					<td bgcolor="#D8D8D8">${row.author }</td>
					<td bgcolor="#D8D8D8">${row.insert_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>