<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%! static int count = 0; %> 

<% 

if(request.getParameter("password").equals("mayank")) {

	%>



<%

out.println("Welcome to dashboard :");

%>

<br/>

Name:

<% 

	out.println(request.getParameter("name"));

	count++;

%>
<hr>
password:

<%

out.println(request.getParameter("password"));

%>	
<hr>

<%

out.println("You are logging in this page  "+ count +"times");

%>

	

<%

}

else{

	out.println("Please Enter The correct Password!");

}



%>
	
	
	
</body>
</html>