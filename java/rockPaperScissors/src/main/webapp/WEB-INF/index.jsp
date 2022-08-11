<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rock Paper Scissors</title>
</head>
<body>
    <h1>Rock Paper Scissors</h1>
    <form method="post" action="${pageContext.request.contextPath}/rps-servlet">
        <button name="player" type="submit" value="rock">Rock</button>
        <button name="player" type="submit" value="paper">Paper</button>
        <button name="player" type="submit" value="scissors">Scissors</button>
    </form>
</body>
</html>