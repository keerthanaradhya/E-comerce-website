<%@page import="com.intern.GetApplicationContext" %>
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="com.intern.dao.ContactDao" %>
<%@page import="java.util.List" %>
<%@page import="com.intern.pojo.ContactPojo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><%@include file="messageBox/message.jsp" %></h1>

	<%ApplicationContext ac = GetApplicationContext.getApplicationContext(); 
	ContactDao c = ac.getBean(ContactDao.class);
	List<ContactPojo> list = c.readContact();
	
	for (ContactPojo cp : list){
		%>
		SN:<%=cp.getSn()%><br>
		NAME:<%=cp.getName() %><br>
		EMAIL:<%=cp.getEmail() %><br>
		MESSAGE:<%=cp.getMessage() %><br>
		DATE:<%=cp.getDatetime() %><br>
		<form>
			<input type="hidden" name="sn" value="<%=cp.getSn() %>">
			<button>Delete</button>
			<br>
		</form>
		<a href="deletecontact? sn=<%=cp.getSn() %>">delete</a>
	<% }
	%>
</body>
</html>