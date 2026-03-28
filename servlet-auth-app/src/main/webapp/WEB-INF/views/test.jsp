<%@page import="entity.test"%>
<%@page import="java.util.List"%>
<%@page import="dao.testDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%	
		   String searchText =request.getParameter("searchText");
		   List<test> list = testDao.findUser(searchText);
	%>
<body>
<h2>testpage</h2>
	<div class="container">
		<input class="search-input">
		<button onclick="handleSearchOnclick()" >조회</button>
	</div>
	<table>
		<thead>
		<tr>
			<th>dvd_id</th>
			<th>username</th>
		</tr>
		</thead>
		<tbody>
		<!-- 얘는 자바 변수 선언  -->
			<%
				for(test t : list){
			%>
			<!-- 태그를 통해서 보여줘야할 땐 표현식 -->
			<tr>
				<td><%=t.getDvdId() %></td>
				<td><%=t.getTitle() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	<script src="/ssa/static/js/test.js"></script>
</body>
</html>