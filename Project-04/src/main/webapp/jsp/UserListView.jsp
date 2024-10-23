<%@page import="in.co.rays.model.RoleModel"%>
<%@page import="in.co.rays.bean.RoleBean"%>
<%@page import="in.co.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.ORSView"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="<%=ORSView.USER_LIST_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.UserBean"
			scope="request"></jsp:useBean>

		<%
			List list = ServletUtility.getList(request);
			int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
		%>

		<div align="center">
			<h1>
				<font color="navy">User List</font>
			</h1>
		</div>

		<table border="1%" style="width: 100%">
			<tr>
				<th><input type="checkbox"></th>
				<th>S.No.</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login</th>
				<th>Mobile No.</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>Role</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					bean = (UserBean) it.next();
					RoleModel model = new RoleModel();
					RoleBean roleBean = new RoleBean();
					roleBean = model.findByPk(bean.getRoleId());
			%>
			<tr align="center">
				<td><input type="checkbox"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLogin()%></td>
				<td><%=bean.getMobileNo()%></td>
				<td><%=bean.getGender()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=roleBean.getName()%></td>
				<td><a href="<%=ORSView.USER_CTL%>?id=<%=bean.getId()%>">edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>