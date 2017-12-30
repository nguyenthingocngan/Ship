<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Header.jsp"%>
<title>Create Order</title>

<script type="text/javascript">
	function closePopup() {
		$(".ui-front").dialog().dialog('close');
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
					alert("create order successfully");
					httpGetAsync("home.html");
					//return true;

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

/* 	function createPopupConfirm() {
		var url = "showConfirmCreateCustomer.html";
		var formData = $("#formData").serializeArray();
		$("#dialog-create").dialog({
			title : 'Add account',
			autoOpen : false,
			resizable : false,
			height : 570,
			width : 600,
			show : {
				effect : 'drop',
				duration : 300,
				direction : 'up'
			},
			modal : true,

			open : function(event, ui) {
				$(this).load(url, formData);
			},
			close : function(event, ui) {
				$(this).dialog('close');
			}
		});
		$("#dialog-create").dialog('open');
		return false;
	}

	$(document).ready(function(){
		$("#firstName").focusout(function(){
			var firstName = $('#firstName').val();
			if($.trim(firstName)==""){
				$("#spFirstName").text("This field is required");
			}
			else{
				if($.trim(firstName).length > 45 || $.trim(firstName).length <2){
					$("#spFirstName").text("Length must be 2 - 45 characters");
				}else{
					$("#spFirstName").text("");
				}
			}
		});
		$("#midName").focusout(function(){
			var midName = $('#midName').val();
			if($.trim(midName)==""){
				$("#spMidName").text("This field is required");
			}
			else{
				if($.trim(midName).length > 45 || $.trim(midName).length <1){
					$("#spMidName").text("Length must be 1 - 45 characters");
				}else{
					$("#spMidName").text("");
				}
			}
		});
		$("#lastName").focusout(function(){
			var lastName = $('#lastName').val();
			if($.trim(lastName)==""){
				$("#spLastName").text("This field is required");
			}
			else{
				if($.trim(lastName).length > 45 || $.trim(lastName).length <2){
					$("#spLastName").text("Length must be 2 - 45 characters");
				}
				else{
					$("#spLastName").text("");
				}
				
			}
		});
		$("#idCardNumber").focusout(function(){
			var idCardNumber = $('#idCardNumber').val();
			if($.trim(idCardNumber)==""){
				$("#spIdCardNumb").text("This field is required");
			}
			else{
				if($.trim(idCardNumber).length > 20 || $.trim(idCardNumber).length <9){
					$("#spIdCardNumb").text("Length must be 9 - 20 characters");
				}
				else{
					$("#spIdCardNumb").text("");
				}
				
			}
		});
		$("#phoneNum1").focusout(function(){
			var phoneNumber1 = $('#phoneNum1').val();
			if($.trim(phoneNumber1)==""){
				$("#spPhone1").text("This field is required");
			}
			else{
				if($.trim(phoneNumber1).length > 20 || $.trim(phoneNumber1).length <9){
					$("#spPhone1").text("Length must be 9 - 20 characters");
				}
				else{
					$("#spPhone1").text("");
				}
			}
		});
		$("#address1").focusout(function(){
			var address1 = $('#address1').val();
			if($.trim(address1)==""){
				$("#spAddress1").text("This field is required");
			}
			else{
				if($.trim(address1).length > 200 || $.trim(address1).length <10){
					$("#spAddress1").text("Length must be 10 - 200 characters");
				}
				else{
					$("#spAddress1").text("");
				}
			}
		});
		
		$("#email1").focusout(function(){
			var email1 = $('#email1').val();
			if($.trim(email1)==""){
				$("#spEmail1").text("This field is required");
			}
			else{
				if (validateEmail(email1)==false) {
					$("#spEmail1").text("Email address is invalid");
		        }
				else{
					$("#spEmail1").text("");
				}
			}
		});
		
		// Enter Number Only
		$("#idCardNumber").keydown(function (e) {
	        // Allow: backspace, delete, tab, escape, enter 
	        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13]) !== -1 ||
	             // Allow: Ctrl+A
	            (e.keyCode == 65 && e.ctrlKey === true) || 
	             // Allow: home, end, left, right
	            (e.keyCode >= 35 && e.keyCode <= 39)) {
	                 // let it happen, don't do anything
	                 return;
	        }
	        // Ensure that it is a number and stop the keypress
	        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105))) {
	            e.preventDefault();
	        }
	    });
	}); */
	
	function validateEmail(sEmail) {
	    var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
	    if (filter.test(sEmail)) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}
	function httpGetAsync(theUrl, callback)
	{
	    var xmlHttp = new XMLHttpRequest();
	    xmlHttp.onreadystatechange = function() { 
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
	            callback(xmlHttp.responseText);
	    }
	    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
	    xmlHttp.send(null);
	}
</script>
<link rel="stylesheet" href="css/screen.css" type="text/css" />
</head>
<body>

	<div style="padding-top: 25px">
		<div id="page-heading">
			<h1>Add Order Information</h1>
		</div>
		<div id="content-table-inner" style="padding-left: 35px;">

			<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr valign="top">
					<td>
						<form id="formData">
							<table border="0" cellpadding="0" cellspacing="0" id="id-form">
								<tr>
									<td colspan="2"><div id="error" class="error"></div></td>
								</tr>
								<tr>
									<td colspan="2"><div id="info" class="success"></div></td>
								</tr>
								<tr>
									<th valign="top">Tên khách hàng</th>
									<td><input type="text" class="inp-form" name="name"
										id="name" /><span id="name" class="error"></span></td>
								</tr>

								<tr>
									<th valign="top">Địa chỉ:</th>
									<td><input type="text" class="inp-form"
										name="address" id="address" /><span
										id="address" class="error"></span></td>
									<td></td>
								</tr>
								<tr>
									<th valign="top">Tiền ship:</th>
									<td><input type="text" class="inp-form" name="shipFee"
										id="shipFee" /><span id="shipFee" class="error"></span></td>
								</tr>
								<tr>
									<th valign="top">Tiền hàng:</th>
									<td><input type="text" class="inp-form" name="productFee" id="productFee" /><span
										id="productFee" class="error"></span></td>
								</tr>
								<tr>
									<th valign="top">Tổng cộng:</th>
									<td><input type="text" class="inp-form" name="totalFee"
										id="totalFee" /><span id="totalFee" class="error"></span></td>
								</tr>
								<tr>
									<th valign="top">Ghi chú:</th>
									<td><input type="text" class="inp-form" name="note" id="note"/><span
										id="note" class="error"></span></td>
								</tr>
								<tr>
									<td></td>
									<td><input type="button" class="btnAdd" value="Save"
										onclick="doAjaxPostCreateCustomer();" id="addAccount" />
										<button type="button" class="btnCancel"
											onclick="closePopup();">Cancel</button></td>
									<td></td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>

</body>
</html>