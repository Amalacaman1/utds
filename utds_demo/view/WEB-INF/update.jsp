<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Item</title>
</head>
<body>
	<form method="POST" action="update">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="item_name" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" /></td>
			</tr>
			<tr><td><input type="submit" value="Submit" /></td></tr>
		</table>
	</form>
</body>
</html>