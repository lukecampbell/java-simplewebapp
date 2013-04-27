<%@ page contentType="application/json" %>
<%@ page import="java.util.*" %>
<%@ page import="com.asascience.models.User" %>
<%
    response.setContentType("application/json");
    response.setHeader("Content-Disposition", "inline");
    List<User> users = (List<User>) request.getAttribute("users");
%>
{
<% 
for(Iterator i = users.iterator(); i.hasNext();) {
    User user = (User) i.next();

    out.print( "\"" + user.getId() + "\""
        + " : " + "{\"name\":\"" 
        + user.getName() + "\", \"age\":" 
        + user.getAge() + "}");
        
    if (i.hasNext()) {
        out.println(",");
    }
} 
%>
}

        
