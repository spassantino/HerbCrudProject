<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <link rel="stylesheet" type="text/css" href="xxx.css" media="screen" />
 --><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Herbs</title>
</head>
<body>
	<c:choose>
		<c:when test="${! empty herb}">
				Herb Scientific Name: ${herb.scientificName}<br>
				Herb Common Name: ${herb.commonName}<br>
				Herb Family: ${herb.family}<br>
				Herb Uses: ${herb.uses}<br>
				Herb Precautions: ${herb.precautions}<br>
				${herb.photo}<br>
		<form action="previous.do" method="GET">
		<input type="submit" value="previous">
		</form>
		<form action="next.do" method="GET">
		<input type="submit" value="next">
		</form> <br>
		</c:when>
		<c:otherwise>
			<p>No herb found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>