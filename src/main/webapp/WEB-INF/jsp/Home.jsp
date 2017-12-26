<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="Header.jsp"%>
<title>Home page</title>
</head>
<body>
	<h1>Hello</h1>
	<c:if test="${empty user}">
		<jsp:forward page="Login.jsp" />
		<%-- <c:redirect url="WEB-INF/Login.jsp" /> --%>
	</c:if>
	<h1>
		Hello
		<c:out value="${user.userName}" />
	</h1>
	Hello
	<c:out value="${user.userName}" />
	"Hello Baby"

	<h1>
		<a href="logout.html">Logout</a>
	</h1>
	<h1>
		<a href="gotoOder.html">Create Order</a>
	</h1>
	<h2>List Order</h2>>
	<table id="tbAccount">
		<thead>
			<tr>
				<th align="left">Số thứ tự</th>
				<th align="left">Tên khách hàng</th>
				<th align="left">Địa chỉ</th>
				<th align="left">Trạng thái đơn hàng</th>
				<th align="left">Tổng giá</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="g" items="${orderList}">
				<tr>
					<td>${g.index + 1}</td>
					<td>${g.customerName}</td>
					<td>${g.address}</td>
					<td>${g.orderStatus.status}</td>
					<td>${g.totalFee}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>