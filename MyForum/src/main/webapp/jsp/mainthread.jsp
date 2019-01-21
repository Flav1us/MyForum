
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false"%> <!-- почему-то ломается jstl без этого -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main thread</title>
</head>
<body>

<hr>

<c:forEach var="post" items="${thread.getPosts()}">
	<c:out value='${post.getText()}'/>
	<hr />
</c:forEach>

<div>
	<form action="/MyForum/mainthread" method="post">
		<input type="text" name="add_post" >
		<input type="hidden" name="command" value="add_post">
		<input type="submit" value="submit">
	</form>
	<form action="/MyForum/mainthread" method="post">
		<input type="hidden" name="command" value="save_thread">
		<input type="submit" value="save thread">
	</form>
	<form action="/MyForum/mainthread" method="post">
		<input type="hidden" name="command" value="load_thread">
		<input type="submit" value="load thread">
	</form>
	<form action="/MyForum/mainthread" method="get">
		<input type="submit" value="update page">
	</form>
</div>

</body>
</html>
