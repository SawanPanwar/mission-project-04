<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.ctl.UserListCtl"%>
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
	<div align="center">
		<form action="<%=ORSView.USER_LIST_CTL%>" method="post">

			<jsp:useBean id="bean" class="in.co.rays.bean.UserBean"
				scope="request"></jsp:useBean>

			<div align="center">
				<h1>
					<font color="navy">User List</font>
				</h1>
			</div>

			<div align="center" style="height: 15px; margin-bottom: 12px">
				<h3>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
				</h3>
				<h3>
					<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
				</h3>
			</div>

			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
				List roleList = (List) request.getAttribute("roleList");
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				if (list.size() != 0) {
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">

			<table style="width: 100%">
				<tr>
					<td align="center"><label><b>First Name :</b></label> <input
						type="text" name="firstName"
						value="<%=ServletUtility.getParameter("firstName", request)%>">&nbsp;
						<label><b>Role :</b></label> <%=HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getRoleId()), roleList)%>&nbsp;
						<input type="submit" name="operation"
						value="<%=UserListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=UserListCtl.OP_RESET%>">
					</td>
				</tr>
			</table>

			<br>

			<table border="1%" style="width: 100%">
				<tr style="background-color: lavender; color: black;">
					<th><input type="checkbox" id="selectall"></th>
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
					while (it.hasNext()) {
							bean = (UserBean) it.next();
							RoleModel model = new RoleModel();
							RoleBean roleBean = model.findByPk(bean.getRoleId());
				%>
				<tr align="center">
					<td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getMobileNo()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=roleBean.getName()%></td>
					<td><a href="<%=ORSView.USER_CTL%>?id=<%=bean.getId()%>"
						<%if (userBean.getId() != bean.getId() && bean.getRoleId() == RoleBean.ADMIN) {%>
						onclick="return false;" <%}%>>edit</a></td>
				</tr>
				<%
					}
				%>
			</table>

			<br>

			<table style="width: 100%">
				<tr>
					<td style="width: 30%"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>
					<td style="width: 30%"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_NEW%>"></td>
					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_DELETE%>"></td>
					<td style="text-align: right;"><input type="submit"
						name="operation" value="<%=UserListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
			<%
				}
				if (list.size() == 0) {
			%>
			<br>
			<table>
				<tr>
					<td align="right"><input type="submit" name="operation"
						value="<%=UserListCtl.OP_BACK%>"></td>
				</tr>
			</table>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>