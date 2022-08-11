<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    String result = (String)request.getAttribute("result");
    String computer = (String)request.getAttribute("computer");
    String player = (String)request.getAttribute("player");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Game Result</title>
</head>
<body>
    <h1><%= result %></h1>
    <p>The computer played <%= computer %> and you played <%= player %>.</p>
    <form method="get" action="${pageContext.request.contextPath}/rps-servlet">
        <button type="submit">Try again</button>
    </form>
</body>
</html>
