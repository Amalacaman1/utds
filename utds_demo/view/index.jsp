<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.ItemDao" %>
<%
	List itemList = (List)((session.getAttribute("itemList") == null) ? ItemDao.getList() : session.getAttribute("itemList"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD Demo</title>
</head>
<body>
	<form method="POST" action="search">
	<table>
		<tr>
			<td>Search</td>
			<td><input type="text" name="queryString" size="20" /></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr><td colspan="2" /></tr>
		<tr>
			<td colspan="2">Items</td>
		</tr>
	<%if(itemList.size() == 0){%>
		<tr><td colspan="2">No records found.</td></tr>		
	<%}else{
		%>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Category</td>
			<td>Actions</td>
		</tr>	
		<%
		for(int x = 0; x < itemList.size(); x++){
		%>
		<tr>
			<td><%=((Item)itemList.get(x)).getId() %></td>
			<td><%=((Item)itemList.get(x)).getName() %></td>
			<td><%=((Item)itemList.get(x)).getCategory() %></td>
			<td><a href="update?id=<%=((Item)itemList.get(x)).getId() %>">Update</a>&nbsp;<a href="delete?id=<%=((Item)itemList.get(x)).getId() %>">Delete</a></td>
		</tr>	
		<%
		}
	}%>
		<tr>
			<td colspan="2"><a href="add">Add</a></td>
		</tr>
	</table>
	</form>
</body>
</html>