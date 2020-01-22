<%@page import="a.Package.aBean"%>

<p>You are successfully updated!</p>

<%

aBean bean=(aBean)request.getAttribute("bean");
out.print("New username, " + bean.getName() +"<br>");
out.print("New password, " + bean.getPassword() +"<br>");
String uName = bean.getName();
Cookie[] cookies = request.getCookies();

String userLogged = null;
for(Cookie cookie : cookies){
    if(uName.equals(cookie.getName())){
        userLogged = cookie.getValue();
        out.print(uName +" " + userLogged + "<br>");
    }
}

%>

