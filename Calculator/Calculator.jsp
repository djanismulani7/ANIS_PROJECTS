<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="calciError.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP FILE CALCULATOR</title>

</head>
<body>
	<% 
		//at the line NO=2 see FOR ERROR DISPLAY MESSAGE WRITE ----> errorPage="calciError.html"
			String num1=request.getParameter("first");
			String num2=request.getParameter("second");
			
			int number1=Integer.parseInt(num1);
			int number2=Integer.parseInt(num2);
			
			String ans=request.getParameter("choice");
			
			if(ans.equals("add"))
			{
				System.out.print("THE ADDITION IS"+(number1+number2));
				response.getWriter().println("<h1>"+(number1+number2)+"<h1>");
			}
			else if(ans.equals("sub"))
			{
				System.out.print("THE SUB IS"+(number1-number2));
				response.getWriter().println("<h1>"+(number1-number2)+"<h1>");
			}	
			else if(ans.equals("mul"))
			{
				System.out.print("THE MUL IS"+(number1*number2));
				response.getWriter().println("<h1>"+(number1*number2)+"<h1>");
			}	
			else if(ans.equals("div"))
			{
				System.out.print("THE DIV IS"+(number1/number2));
				response.getWriter().println("<h1>"+(number1/number2)+"<h1>");
			}	
	
		
	%>
	<a href="Calculator.html">REFRESH</a>
	
</body>
</html>