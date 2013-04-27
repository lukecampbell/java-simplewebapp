<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <body>
        <%
            List values = (List) request.getAttribute("values");
            Iterator it = values.iterator();
            while(it.hasNext()) {
                out.print("<br>" + it.next());
            }
        %>
    </body>
</html>


