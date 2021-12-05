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
				<li>Category: ${film.category}</li>
				<li>Replacement Cost: ${film.replacementCost}</li>
				
			</ul>
				<form action="deletefilm.do" method="GET">
		<input type="submit" value="Delete"/>
		
		</c:when>
		<c:otherwise>
			<p>No film exists</p>
		</c:otherwise>
	</c:choose>


	<!-- <h3>Search Again</h3>
	<form action="searchid.do" method="GET">
		<input type="submit" value="Get Film" />
	</form> 
	</form>	  -->
	

	<form action="home.do" method="GET">
		<input type="submit" value="Home"/>

</body>
</html>