<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ include file="Header.jsp"%>
<title>Home page</title>
<script type="text/javascript">
function closePopup() {
	$(".ui-front").dialog().dialog('close');
}

function createPopup() {
	var url = "gotoOder.html";
	$("#dialog-create").dialog({
		title : 'Add order',
		autoOpen : false,
		resizable : false,
		height : 570,
		width : 600,
		show : {
			effect : 'drop',
			duration : 500,
			direction : 'up'
		},
		modal : true,

		open : function(event, ui) {
			$(this).load(url);
		},
		close : function(event, ui) {
			$(this).dialog('close');
		}
	});
	$("#dialog-create").dialog('open');
	return false;
}


	function validateEmail(sEmail) {
	    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	    if (filter.test(sEmail)) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
</script>
</head>
<body>
	<h1>Hello</h1>
	<c:if test="${empty user}">
		<jsp:forward page="Login.jsp" />
		<%-- <c:redirect url="WEB-INF/Login.jsp" /> --%>
	</c:if>
	<h1>
		nnguyen79
		<c:out value="${user.userName}" />
	</h1>
	Hello
	<c:out value="${user.userName}" />


	<h1>
		<a href="logout.html">Logout</a>
	</h1>
	<!-- Create popup -->
			<div style="padding-left: 30px">
				
					<input class="btnAdd" type="submit" value="Add" id="btnCreate"
						onclick="createPopup();" />
			
				<div id="dialog-create" title="Basic dialog"></div>
				<div id="dialog-verify"></div>
				<div id="dialog-edit-cus"></div>
			</div>
	<h1>
		<a href="gotoOder.html">Create Order</a>
	</h1>
	<h2>List Order</h2>
	
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
	<%-- <h1><c:out value="${orderMessage}"/></h1> --%>
</body>
</html>