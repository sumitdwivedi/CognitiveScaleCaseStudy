<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%@ include file="header.jsp" %>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login page</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
	</head>

<body>
	message : ${success}
	<br/>
	<br/>
	Go back to <a href="<c:url value='/list' />">List of All Employees</a>
	<a href="<c:url value='/user/new' />">Add New Employee</a>
	<a href="<c:url value='/user/transactionSummary' />">Transaction Summary</a>
	<a href="<c:url value='/user/new' />">Transfer funds</a>
	
</body>
<%@ include file="footer.jsp" %>
</html>