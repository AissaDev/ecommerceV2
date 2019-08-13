<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<div id="formCat" class="cadre">
	<f:form modelAttribute="categorie" action="saveCat" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Catégorie:</td>
				<td><f:input path="idcategorie"/></td>
				<td><f:errors path="idcategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Nom Catégorie</td>
				<td><f:input path="nomCategorie" /></td>
				<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="" >
	<table class="tabStyle1">
		<tr>
			<th>ID</th>
			<th>NOM CAT</th>
			<th>DESCRIPTION</th>
			<th>PHOTO</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${categories}" var="cat">
			<tr>
				<td>${cat.idcategorie}</td>
				<td>${cat.nomCategorie}</td>
				<td>${cat.description}</td>
				<td><img src="photoCat?idCat=${cat.idcategorie}"></td>
			</tr>
		</c:forEach>
	</table>
</div>