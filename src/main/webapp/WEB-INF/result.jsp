<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<a href="searchid.do">Results</a>
<c:choose>
    <c:when test="${! empty film}">
      <ul>
        <li>Film id: ${film.id}</li>
        <li>${film.title}</li>
        <li>${film.description}</li>
        <li>${film.releaseYear}</li>
        <li>${film.languageId}</li>
        <li>${film.rentalDuration}</li>
        <li>${film.rentalRate}</li>
        <li>${film.length}</li>
        <li>${film.replacement}</li>
        <li>${film.rating}</li>
        <li>${film.language}</li>
        <li>${film.specialFeatures}</li>
        <li>${film.category}</li>
        
      </ul>
    </c:when>
    <c:otherwise>
      <p>No film exists</p>
    </c:otherwise>
  </c:choose>
  
  
<h3>Search Again</h3>
	<form action="searchid.do" method="GET">
		<input type="submit" value="Get Film" />
	</form> 
	

	<form action="home.do" method="GET">
		<input type="submit" value="Home" />
	</form>	 
  
</body>
</html>