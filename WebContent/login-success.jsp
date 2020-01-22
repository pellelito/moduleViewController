<%@page import="a.Package.aBean"%>

<p>You are successfully logged in!</p>

<%
aBean bean=(aBean)request.getAttribute("bean");
out.print("Welcome, " + bean.getName() +"<br>");
String uName = bean.getName();
Cookie[] cookies = request.getCookies();

String userLogged = null;
for(Cookie cookie : cookies){
    if(uName.equals(cookie.getName())){
        userLogged = cookie.getValue();
    }
}
out.print("Logged in: " + userLogged +"<br>");
if (bean.getAdmin()){
	out.print("<form action='UpdateServlet' method='post'><br>");
	out.print("Set new username:<input type='text' name='name'><br>");
	out.print("Set new password: <input type='password' name='password'><br>");
	out.print("<input type='submit' value='Update'>");
	out.print("</form>");
}else{
	out.print("Sorry you're not allowed to make changes!");
}	
%>

