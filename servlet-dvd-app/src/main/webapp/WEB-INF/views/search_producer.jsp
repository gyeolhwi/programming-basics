<%@page import="com.study.dvd.dao.ProducerDao"%>
<%@page import="com.study.dvd.entity.Producer"%>
<%@page import="com.study.dvd.dao.DvdDao"%>
<%@page import="com.study.dvd.entity.Dvd"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid #dbdbdb;
	border-collapse: collapse;
}

th, td {
	padding: 5px 10px;
}
</style>
</head>
<body>
	<div>
		<label>검색</label>
		<input type="text" 
		class="search-input"  
		placeholder="제작사명을 입력하세요">
		<button onclick="handleSearchClickToPublisherName()">검색</button>
	</div>
	
	<%
		String searchText = request.getParameter("searchText");
		List<Producer> producers = ProducerDao.searchProdcuerByProducerName(searchText);
		System.out.println(producers);
	%>
	<table>
		<thead>
		<tr>
			<th>순서</th>
			<th>제작사_ID</th>
			<th>제작사</th>
		</tr>
		</thead>
		<tbody>
			<%
				int num = 1;
				for(Producer producer : producers) {
			%>
				<tr>
					<td><%= num++ %></td>
					<td><%= producer.getProducerId() %></td>
					<td><%=producer.getProducerName() %></td>
				</tr>
			<%
				};
			%>
		</tbody>
	</table>
	<script src="/dvd/static/search_dvd.js"></script>

</body>
</html>