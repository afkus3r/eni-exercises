
<html>
<head>

      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
     <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/modifierProfil.css"/>
      <title>Panel Administration</title>
</head>
<body>
<main>

  <jsp:include page="header.jsp" />

  <div class="content">
    <h1>PANEL ADMINISTRATION</h1>

    <h2>Administration</h2>

    <div class="buttons">
      <a class="logout" href="${pageContext.request.contextPath}/AffichageCategorie">Gestion catégorie</a>
      <a class="logout" href="${pageContext.request.contextPath}/MonProfil?pseudo=${sessionScope.utilisateur.pseudo}">Gestion Utilisateur</a>
    </div>


  </div>
</main>

</body>
</html>
