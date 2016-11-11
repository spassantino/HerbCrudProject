<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update a Herb and Its Data</title>
</head>
<body>
<h2>Find an herb to update by common name:</h2>
<form action="UpdateHerb.do" method="POST" method="GET">
<input type="hidden" name="choice" value="${herb.commonName}"/>
Common Name of Herb to Update: <input type="text" name="commonName"/><br>

Updated Herb Scientific Name: <input type="text" name="scientificName"/> <br>
Updated Herb Family: <input type="text" name="family"/><br>
Updated Herb Uses: <input type="text" name="uses"/><br>
Updated Herb Precautions: <input type="text" name="precautions"/><br>
Updated Herb Photo (url): <input type="text" name="photo"/><br>
 <input type="submit" value="Update Herb Data" /><br>
</form>
</body>
</html>