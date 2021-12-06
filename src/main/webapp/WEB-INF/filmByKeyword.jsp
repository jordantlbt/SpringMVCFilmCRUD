<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Keyword Search Results</title>
</head>
<body> 
  <c:choose>
    <c:when test="${! empty films}">
   
      <ul>
        <c:forEach var="film" items="${films}">
      <br><br>
     			<li>Film ID: ${film.filmID}</li>  <!--Film entity: filmID  -->
				<li>Title: ${film.title}</li>
				<li>Description: ${film.description}</li>
				<li>Release Year: ${film.releaseYear}</li>
				<li>Film Length: ${film.length}</li>
				<li>Rating: ${film.rating}</li>
				<li>Language: ${film.language}</li>
				<li>Special Features: ${film.specialFeatures}</li>
				<li>Category: ${film.category}</li> 
				<li>Rental Duration: ${film.rentalDuration}</li>
				<li>Rental Rate: ${film.rentalRate}</li>
				<li>Replacement Cost: ${film.replacementCost}</li>
				<c:forEach var="actor" items="${film.actors}">
				<li>Actors: ${actor.firstName}, ${actor.lastName}</li> 
				</c:forEach>
      <br/>

<form action="deletefilm.do" method="GET">
   			<button type="submit" name="filmID" value= "${film.filmID}">Delete Film</button> 
   			</form>

<a href="updatefilm.do?filmID=${film.filmID}">Update Film</a>

        
        
    </c:forEach>
      </ul>
      <br><br>
      
<a href="home.do">Home</a>
        
 
      </c:when>
    <c:otherwise>
      <p>No films found</p>
    </c:otherwise>
  </c:choose>
  </body>