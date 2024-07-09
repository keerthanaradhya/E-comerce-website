<%
	String msg = (String)session.getAttribute("msg");
	if (msg!=null){
		
%>
	<%=msg%>
<%}
	session.removeAttribute("msg");
%>	
	
