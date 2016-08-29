<%@ include file="header.jsp" %>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
<style>
#wrapper {
	background: #fff;
	padding: 20px;
	border: 10px solid #aaa;
	border-radius: 15px;
	background-clip: padding-box;
	text-align: center;
}

.overlay {
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background: rgba(0, 0, 0, 0.5);
	transition: opacity 200ms;
	visibility: hidden;
	opacity: 0;
	padding: 0px 50px 0 50px;
}

.overlay.light {
	background: rgba(255, 255, 255, 0.5);
}

.overlay .cancel {
	position: absolute;
	width: 100%;
	height: 100%;
	cursor: default;
}

.overlay:target {
	visibility: visible;
	opacity: 1;
}

.popup {
	margin: 10px;
	padding: 20px;
	background: #fff;
	border: 1px solid #666;
	box-shadow: 0 0 50px rgba(0, 0, 0, 0.5);
	position: relative;
}

.light .popup {
	border-color: #aaa;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.25);
}

.popup .close {
	position: absolute;
	width: 20px;
	height: 20px;
	top: 20px;
	right: 20px;
	opacity: 0.8;
	transition: all 200ms;
	font-size: 24px;
	font-weight: bold;
	text-decoration: none;
	color: #666;
}

.popup .close:hover {
	opacity: 1;
}
</style>


</head>
<body>
	<script type="text/javascript">
		var data;
		$(document)
				.ready(
						function() {
							$('#data_table_id')
									.DataTable(
											{
												"data" : data,
												"language" : {
													"lengthMenu" : "Display -- records per page",
													"zeroRecords" : "No matching records found - We don't add anything yet No data available in table - no data of your choice.",
													"infoEmpty" : "No records available",
													"emptyTable" : "My Custom Message On Empty Table"
												}
											});
						});
	</script>

	<script>
		function validateInput() {
			var x = document.getElementById("userCode").value;
			var y = document.getElementById("datefrom").value;
			if ((x == null || x == "") || (y == null || y == "")) {
				alert("Please provide Valid User Code And Date");
				return false;
			}
			return true;
		}
	</script>

	<!-- scripte for expand/cpllapse -->
	<script language="javascript">
		function toggle() {
			var ele = document.getElementById("toggleText");
			var text = document.getElementById("displayText");
			if (ele.style.display == "block") {
				ele.style.display = "none";
				text.innerHTML = "show";
			} else {
				ele.style.display = "block";
				text.innerHTML = "hide";
			}
		}
	</script>
	<table>
  <c:forEach items="${resultList}" var="resultList">
    <tr>
      <td><c:out value="${resultList}" /></td>
    </tr>
  </c:forEach>
</table>
<a href="<c:url value='/user/new' />">Add Beneficiary/Payee</a>
<a href="<c:url value='/user/new' />">Transfer funds</a>
	<form action="${pageContext.request.contextPath}/user/transactionSummaryDetail"
		method="GET" onsubmit="return validateInput();">
		<div
			style="border-radius: 10px; border: 1px solid #337ab7; padding-top: 10px;">
			<div>
			</div>
			
			<ul
				style="list-style-type: none; display: flex; padding-left: 50px; padding-top: 10px">
				<li><label for="lbl_txn_id">Transaction Date {From</label> 
				<input  type="date" id="datefrom" name="datefrom"
					style="margin-left: 15px; width: 155px;">
				<li><label for="lbl_txn_id"> Till</label> <input
					type="date" id="date" name="date"
					style="margin-left: 15px;width: 155px;">
				<li><label for="lbl_txn_id" style="margin-left: 10px;">}  User
						Code</label> <input type="text" id="userCode" name="userCode"
					placeholder="User Code" style="margin-left: 30px; width: 154px;">

					<button type="Submit" value="Submit" class="btn-primary  btn-lg"
						style="margin-left: 22px;">Transaction Summary</button>
					<button type="reset" value="Reset" class="btn-primary  btn-lg">Reset</button>
				</li>
			</ul>


		</div>

	</form>






	<table width="70%" style="border: 3px; background: rgb(243, 244, 248);">
		<tr>
			<td>
				<table id="example" class="display" cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>TXN Id</th>
							<th>User Id</th>
							<th>INPUT VALUES</th>
							<th>TXN Date</th>

						</tr>
					</thead>
				

					<tfoot>
						<tr>
							<th>Txn Id</th>
							<th>User Id</th>
							<th>INPUT VALUES</th>
							<th>TXN Date</th>

						</tr>
					</tfoot>

				</table> 
				<%@ include file="footer.jsp" %>
</body>

</html>