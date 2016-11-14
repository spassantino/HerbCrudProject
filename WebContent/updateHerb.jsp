<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="herbStyling.css" media="screen" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a Herb and Its Data</title>
</head>
<body>
<h1>Find an herb to update by common name:</h1>
<form action="UpdateHerb.do" method="POST" method="GET">
<input type="hidden" name="cn" value="${herb.commonName}"/>
<div class="data">
Common Name of Herb to Update: <input type="text" name="commonName" value="${herb.commonName}"/><br>

Updated Herb Scientific Name: <input type="text" name="scientificName" value="${herb.scientificName}"/> <br>
Updated Herb Family: <input type="text" name="family" value="${herb.family}"/><br>
Updated Herb Uses: <input type="text" name="uses" value="${herb.uses}"/><br>
Updated Herb Precautions: <input type="text" name="precautions" value="${herb.precautions}"/><br>
Updated Herb Photo (url): <input type="text" name="photo" value="${herb.photo}"/><br>
 <input type="submit" value="Update Herb Data" /><br>
 <div class="data">
</form>
</body>
</html>