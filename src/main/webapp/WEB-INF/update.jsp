<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/update" id="updateform" hidden=true method="post">
		<input type="text" id="upidx" name="idx" value="${Pb.idx}" hidden=true readonly>
		<ul>
			<li><h1>정보 수정</h1></li>
			<li><input type="text" id="upname" name="name" value="${pb.name}"></li>
			<li><input type="text" id="uphp" name="hp" value="${pb.hp}"></li>
			<li><input type="text" id="upmemo" name="memo" value="${pb.memo}"></li>
			<li><input type="submit" id="upbtn" value="저장"><input type="button" id="cancelbtn" value="취소"></li>
		</ul>
	</form>
</body>
</html>