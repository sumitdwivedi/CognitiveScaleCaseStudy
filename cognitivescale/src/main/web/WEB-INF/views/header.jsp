<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<title>Cognitive scale Bank App POC Web Application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://www.w3schools.com/lib/w3-theme-red.css">
<body>

	<nav class="w3-sidenav w3-white w3-card-2" style="display: none">
		<a href="javascript:void(0)" onclick="w3_close()"
			class="w3-closenav w3-large">Close &times;</a> <a href="/admin">logIn</a>
		<a href="/home">Registration</a> <a href="/home">Contact US</a> <a
			href="/index">About US</a> <a href="/admin">Offre and Events</a>
	</nav>

	<header class="w3-container w3-red">
		<span class="w3-opennav w3-xlarge" onclick="w3_open()">&#9776;</span>

		<!-- logout form  -->
		<c:url value="/logout" var="logoutUrl" />
		<form id="logout" action="${logoutUrl}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			
				Welcome : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:document.getElementById('logout').submit()">Log out</a>
		</c:if>
		
		
		<!-- logout form end  -->
		<center>
			<h1>My Banking Apps</h1>
			<br>www.myBankingApps.com
		</center>


	</header>







	<script>
		function w3_open() {
			document.getElementsByClassName("w3-sidenav")[0].style.display = "block";
		}
		function w3_close() {
			document.getElementsByClassName("w3-sidenav")[0].style.display = "none";
		}
	</script>

</body>
</html>
