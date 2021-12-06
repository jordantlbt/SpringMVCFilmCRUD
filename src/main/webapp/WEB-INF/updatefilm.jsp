<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Update</title>
</head>
<body>

	<h1>Update:</h1>
	<form action="updatefilm.do" method=GET>
		<h2>Film ID# - ${film.filmId}</h2>
		
		Film ID:
		<input type="text" name="filmId" value="${film.filmId}" readonly /> <br>
		<br>	
		Title:
		<input type="text" name="title" value="${film.title}" required /> <br>
		<br>
		Description:
		<input type="text" name="description" value="${film.description}" /> 
		<br>
		Release Year:
		<input type="text" placeholder="YYYY" name="releaseYear" value="${film.releaseYear}" /> 
		<br>
		*Language:
		<input type="radio" name="languageId" value="1">
	 	<label for="languageID1">English</label>
		<input type="radio" name="languageId" value="2">
		<label for="languageID2">Italian</label>
		<input type="radio" name="languageId" value="3">
		<label for="languageID3">Japanese</label>
		<input type="radio" name="languageId" value="4">
		<label for="languageID4">Mandarin</label>
		<input type="radio" name="languageId" value="5">
		<label for="languageID5">French</label>
		<input type="radio" name="languageId" value="6">
		<label for="languageID6">German</label>
		<br> 
		
		Rating: 
		<input type="radio" name="rating" value="G">
	 	<label for="G">G</label>
		<input type="radio" name="rating" value="PG">
		<label for="PG">PG</label>
		<input type="radio" name="rating" value="PG13">
		<label for="PG13">PG13</label>
		<input type="radio" name="rating" value="R">
		<label for="R">R</label>
		<input type="radio" name="rating" value="NC17">
		<label for="NC17">NC17</label>
		<br>
		Special Features:
		<input type="checkbox" name="specialFeatures" value="Trailers">
	 	<label for="Trailers">Trailers</label>
		<input type="checkbox" name="specialFeatures" value="Deleted Scenes">
		<label for="Deleted Scenes">Deleted Scenes</label>
		<input type="checkbox" name="specialFeatures" value="Behind the Scenes">
		<label for="Behind the Scenes">Behind the Scenes</label>
		<input type="checkbox" name="specialFeatures" value="Commentaries">
		<label for="Commentaries">Commentaries</label> 
		<br><br>
		<form action="updatefilm.do">
			<input type="submit" value="Update Film" />
		</form>
	</form>
	<br> 
	
	<!-- Homepage link -->
	<form action="home.do">
		<input type="submit" value="Back">
	</form>
	
</body>
</html>