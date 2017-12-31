<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="Header.jsp"%>
<title>Home page</title>
<script type="text/javascript">
function closePopup() {
	$('#exampleModalCenter').modal('hide');
}

function doAjaxPostCreateCustomer() {
	// get the form values  
	var name = $('#name').val();
	var address = $('#address').val();
	var shipFee = $('#shipFee').val();
	var productFee = $('#productFee').val();
	var total = $('#totalFee').val();
	var note = $('#note').val();

	$.ajax({
		type : "POST",
		url : "createOrder.html",
			dataType: "json",
		data: {"name" : name,
				"address" : address,
				"shipFee" : shipFee,
				"productFee" : productFee,
				"total" : total,
				"note"  : note
			},
/* 			data : "name=" + name + "&address="
			+ address + "&shipFee=" + shipFee
			+ "&productFee=" + "productFee" + "&total=" + "total" + "&note="+ "note", */
		success : function(response) {
			// we have the response

			if (response.status == "SUCCESS") {
				closePopup();
				$('#successOrder').html(
						"create order successfully");

			} else {
				errorInfo = "";
				for (i = 0; i < response.result.length; i++) {
					errorInfo += "<br>" + (i + 1) + ". "
							+ response.result[i].code;
				}
				$('#error').html(
						"Please correct following errors: " + errorInfo);
				$('#info').hide('slow');
				$('#error').show('slow');
			}

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

	function validateEmail(sEmail) {
		var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if (filter.test(sEmail)) {
			return true;
		} else {
			return false;
		}
	}
	$(document).ready(function() {
		$('#tbOrder').DataTable();
	});
</script>
</head>
<body>
	<%-- 	<h1>Hello</h1>
	<c:if test="${empty user}">
		<jsp:forward page="Login.jsp" />
		<c:redirect url="WEB-INF/Login.jsp" />
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
	<div>
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
	</div>
	<h1><c:out value="${orderMessage}"/></h1> --%>

	<c:if test="${empty user}">
		<c:redirect url="WEB-INF/Login.jsp" />
	</c:if>
	<div class="jumbotron text-center">
		<h1>
			Chào mừng đến với Shipper
			<c:out value="${user.userName}" />
		</h1>
		<p>Nếu bạn cần, hãy gọi shipper!</p>
	</div>

	<div class="container">
	      	<div id="errorOrder"></div>
		<div id="successOrder"></div>
	
		<!-- Start create Order -->
	<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Add attribute</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
						<div class="form-row">
							<label>Tên khách hàng:</label>
							 <input type="text" class="form-control" id="name" name="name"
								placeholder="Tên khách hàng" value="Ngân" required>
						</div>
						<div class="form-row">
							<label>Địa chỉ:</label> <input
								type="text" class="form-control" name="address" id="address"
								placeholder="Địa chỉ"
								value="34 Cộng Hòa, phường 15 quận Tân Bình" required>
						</div>
						<div class="form-row">
							<label>Tiền ship:</label> <input
								type="text" class="form-control" name="shipFee" id="shipFee"
								placeholder="Tiền ship" value="50000" required>
						</div>
						<div class="form-row">
							<label>Tiền hàng:</label> <input
								type="text" class="form-control" name="productFee"
								id="productFee" placeholder="Tiền hàng" value="500000"
								required>
						</div>
						<div class="form-row">
							<label>Tổng cộng:</label> <input
								type="text" class="form-control" name="totalFee"
								id="totalFee" placeholder="Tổng cộng" value="550000"
								required>
						</div>
						<div class="form-row">
							<label>Ghi chú::</label> <input
								type="text" class="form-control" name="note" id="note"
								placeholder="Ghi chú" value="ghi chú" required>
						</div>
					</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button class="btn btn-primary" type="submit" onclick="doAjaxPostCreateCustomer();" id="addOrder" >Submit form</button>
      </div>
    </div>
  </div>
</div><!-- End model -->
<!-- End create order -->
	
	
	
	
		<!-- Start order information -->
		<div>
			<div class="table-responsive">
				<table id="tbOrder" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th align="left">Tên khách hàng</th>
							<th align="left">Địa chỉ</th>
							<th align="left">Trạng thái đơn hàng</th>
							<th align="left">Tổng giá</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="g" items="${orderList}">
							<tr>
								<td>${g.customerName}</td>
								<td>${g.address}</td>
								<td>${g.orderStatus.status}</td>
								<td>${g.totalFee}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- End order information-->
	</div>

</body>
</html>