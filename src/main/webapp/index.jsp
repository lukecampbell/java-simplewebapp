<html>
    <body>
        <%
            // This is a scriptlet
            System.out.println("Evaluating date now");
            java.util.Date date = new java.util.Date();
        %>
        Hello! Dude, time is now <%= date %>
    </body>
</html>
