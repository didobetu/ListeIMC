<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Liste des patients - IMC</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
	<h1>Liste des patients (IMC)</h1>

	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Masse (kg)</th>
				<th>Taille (m)</th>
				<th>IMC</th>
				<th>Interprétation</th>
				<th colspan="2">Opérations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${patients}">
				<tr>
					<td><c:out value="${p.nom}" /></td>
					<td><c:out value="${p.prenom}" /></td>
					<td><fmt:formatNumber value="${p.masse}" maxFractionDigits="1" /></td>
					<td><fmt:formatNumber value="${p.taille}" minFractionDigits="2" maxFractionDigits="2" /></td>
					<td><fmt:formatNumber value="${p.imc}" minFractionDigits="2" maxFractionDigits="2" /></td>
					<td><c:out value="${p.interpretation}" /></td>
					<td>
						<form class="enligne" method="post" action="${pageContext.request.contextPath}/supprimer"
							onsubmit="return confirm('Supprimer ce patient ?');">
							<input type="hidden" name="id" value="${p.id}">
							<button type="submit" class="lien supprimer">Supprimer</button>
						</form>
					</td>
					<td><a class="lien modifier"
						href="${pageContext.request.contextPath}/modifier?id=${p.id}">Modifier</a></td>
				</tr>
			</c:forEach>
			<c:if test="${empty patients}">
				<tr>
					<td colspan="8" class="vide">Aucun patient enregistré.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

	<p>
		<a class="bouton" href="${pageContext.request.contextPath}/ajouter">Ajouter un patient</a>
	</p>
</body>
</html>
