<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="herbStyling.css" media="screen" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Herbs</title>
</head>
<body>
<h1>${herb.commonName}</h1>
	<c:choose>
		<c:when test="${! empty herb}">
<div class="result">
				Herb Scientific Name: ${herb.scientificName}<br>
</div>
<div class="result">
				Herb Common Name: ${herb.commonName}<br>
</div>
<div class="result">
				Herb Family: ${herb.family}<br>
</div>
<div class="result">				
				Herb Uses: ${herb.uses}<br>
</div>
<div class="result">				
				Herb Precautions: ${herb.precautions}<br>
	</div>
				
			<img src="${herb.photo}" alt="herb photo"><br>
		</c:when>
		<c:otherwise>
		<div class="result">
			<p>No herb found</p>
			</div>
		</c:otherwise>
	</c:choose>
		<form action="previous.do" method="GET">
		<input type="submit" value="previous">
		</form>
		<form action="next.do" method="GET">
		<input type="submit" value="next">
		</form>
		<form action="DeleteHerb.do" method="GET">
		<input type="hidden" name="commonName" value="${herb.commonName}">
		<input type="submit" value="delete">
		</form>
		<span class="links">
	<a href="updateHerb.jsp">Update this Herb</a>
	<br>
	<a href="index.jsp" >Return to Home Page</a>
	<span class="links">
</body>
</html>