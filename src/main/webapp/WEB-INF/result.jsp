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
	<c:choose>
		
		<c:when test="${! empty film}">
			<ul>
				<li>Film id: ${film.filmID}</li>  <!--Film entity: filmID  -->
				<li>Title: ${film.title}</li>
				<li>Description: ${film.description}</li>
				<li>Release Year: ${film.releaseYear}</li>
				<li>Rental Duration: ${film.rentalDuration}</li> 
				<li>Rental Rate: ${film.rentalRate}</li>
				<li>Film Length: ${film.length}</li> 
				<li>Rating: ${film.rating}</li>
				<li>Language: ${film.language}</li>
				<li>Special Features: ${film.specialFeatures}</li>
				
				<li>Replacement Cost: ${film.replacementCost}</li> 
				
			<c:forEach var="category" items="${film.category}">
				<li>Category: ${film.category}</li> 
			</c:forEach>
			
			<c:forEach var="actor" items="${film.actors}">
				<li>Actors: ${actor.firstName}, ${actor.lastName}</li> 
			</c:forEach>					

			</ul>
				
<form action="deletefilm.do" method="GET">
   			<button type="submit" name="filmID" value= "${film.filmID}">Delete Film</button> 
   			</form>
			
		</c:when>
		<c:otherwise>
			<p>No film exists</p>
		</c:otherwise>
	</c:choose>
<br>

<a href="updatefilm.do?filmID=${film.filmID}">Update Film</a>

	
	<a href="home.do">Home</a>
	


</body>
</html>