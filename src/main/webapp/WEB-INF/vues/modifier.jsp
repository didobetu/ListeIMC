<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Modifier un patient</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h1>Modifier un patient</h1>

	<c:if test="${not empty erreur}">
		<p class="erreur">${erreur}</p>
	</c:if>

	<form method="post" action="${pageContext.request.contextPath}/modifier">
		<input type="hidden" name="id" value="${patient.id}">

		<label for="nom">Nom</label>
		<input type="text" id="nom" name="nom" value="<c:out value='${patient.nom}'/>" required>

		<label for="prenom">Prénom</label>
		<input type="text" id="prenom" name="prenom" value="<c:out value='${patient.prenom}'/>" required>

		<label for="masse">Masse (kg)</label>
		<input type="number" id="masse" name="masse" step="0.1" min="1" value="${patient.masse}" required>

		<label for="taille">Taille (m)</label>
		<input type="number" id="taille" name="taille" step="0.01" min="0.3" max="2.8" value="${patient.taille}" required>

		<button type="submit" class="bouton">Mettre à jour</button>
		<a class="lien" href="${pageContext.request.contextPath}/patients">Annuler</a>
	</form>
</body>
</html>
