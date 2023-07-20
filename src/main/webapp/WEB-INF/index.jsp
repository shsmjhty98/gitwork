<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	li{
		list-style: none;
	}
	#insert{
		width: 30%;
		height: 100px;
		border: 5px solid green;
	}
	#list{
		width: 30%;
		height: 500px;
		border: 5px solid red;
		display: inline-block;
		overflow: scroll;
	}
	#findone{
		width: 30%;
		height: 200px;
		border: 5px solid blue;
	}
</style>
</head>
<body>
	<div id="insert">
		<form action="/insert" method="post">
			<input type="text" id="name" name="name" placeholder="이름 입력"> <br>
			<input type="text" id="hp" name="hp" placeholder="전화번호 입력"> <br>
			<input type="text" id="memo" name="memo" placeholder="메모 입력"> <br>
			<input type="submit" value="전화번호 입력">
		</form>
	</div>
	
	<div id="main">
		<div id="list">
			<input type="text" id="search" name="search" placeholder="검색"> 
			<button onclick="search()">검색</button>
			<hr>
			<c:forEach var="pb" items="${list}">
				<li onclick="location.href='/findOne?idx=${pb.idx}'">
					${pb.idx}
					${pb.name} <br>
					${pb.hp} <br>
					${pb.memo}
				</li> <hr>
			</c:forEach>
		</div>
	
		<div id="findone">
			${pb.idx} <br>
			${pb.name} <br>
			${pb.hp} <br>
			${pb.memo} <br>
			<input type="button" id="upbtn" value="수정" onclick="location.href='/update'">
			<input type="button" id="delbtn" value="삭제" onclick="location.href='/delete'">
		</div>
		
	</div>
</body>
</html>