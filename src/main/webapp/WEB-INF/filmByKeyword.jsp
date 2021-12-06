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
     			<li>${film.filmID}</li>  <!--Film entity: filmID  -->
				<li>${film.title}</li>
				<li>${film.description}</li>
				<li>${film.releaseYear}</li>
				<li>${film.rentalDuration}</li>
				<li>${film.rentalRate}</li>
				<li>${film.length}</li>
				<li>${film.replacementCost}</li>
				<li>${film.rating}</li>
				<li>${film.language}</li>
				<li>${film.specialFeatures}</li>
				<li>${film.category}</li> 
				<c:forEach var="actor" items="${film.actors}">
				<li>Actors: ${actor.firstName}, ${actor.lastName}</li> 
				</c:forEach>
      <br/><br/>
<<<<<<< HEAD
<form action="deletefilm.do" method="GET">
   			 <button type="submit" name="filmID" value= "${film.filmID}">Delete Film</button>
   			</form>

<form action="updatefilm.do" method="GET">
<button type="submit" value="${film.filmID}">Update Film</button>

</form>

        
        
    </c:forEach>
      </ul>
      
<a href="home.do">Home</a>
        
 
      </c:when>
    <c:otherwise>
      <p>No films found</p>
    </c:otherwise>
  </c:choose>
  </body>