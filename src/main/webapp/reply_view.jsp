<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 답글쓰기</title>
</head>
<body>
	<h2>자유게시판 답글쓰기</h2>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="reply.do" method="post">	
			<tr>
				<td>번호</td>
				<td>${reply_view.bid}</td>
			</tr>	
			<tr>
				<td>조회수</td>
				<td>${reply_view.bhit}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="bname" size="65" value="${reply_view.bname}"></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input type="text" name="btitle" size="65" value="${reply_view.btitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="bcontent" cols="50" rows="10">${reply_view.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<input type="submit" value="답글쓰기">&nbsp;&nbsp;&nbsp;
					<a href="list.do">목록보기</a>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>