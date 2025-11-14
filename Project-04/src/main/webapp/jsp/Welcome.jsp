<%@page import="in.co.rays.proj4.controller.ORSView"%>
<html>
<head>
<title>Welcome to ORS</title>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
	<form action="<%=ORSView.WELCOME_CTL%>">
		<%@ include file="Header.jsp"%>
		<br> <br> <br>
		<h1 align="center">
			<font size="10px" color="navy">Welcome to ORS</font>
		</h1>
	</form>
</body>
</html>