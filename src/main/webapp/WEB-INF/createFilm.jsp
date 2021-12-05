<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Film</title>
</head>
<body>

<h1>Add A Film</h1>

<h3>Please enter the following information for your film:</h3>
<form action="createFilm.do" method="POST">
	
	
		*Title: 
		<input type="text" name="title" size="8"/> 
	<br>
		*Description:
		<input type="text" name="description" size="8"/> 
	<br>	
		*Release Year:
		<input type="text" name="releaseYear" size="8"/> 
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
	<!-- 	*Category
		<select name="category">
			<option value="Action">Action</option>	
			<option value="Animation">Animation</option>
			<option value="Children ">Children </option>	
			<option value="Classics">Classics</option>	
			<option value="Comedy">Comedy</option>
			<option value="Documentary">Documentary	</option>
			<option value="Drama">Drama</option>
			<option value="Family">Family	</option>
			<option value="Foreign">Foreign	</option>
			<option value="Games">Games	</option>
			<option value="Horror">Horror	</option>
			<option value="Music">Music	</option>
			<option value="New">New	</option>
			<option value="Sci-Fi">Sci-Fi	</option>
			<option value="Sports">Sports</option>	
			<option value="Travel">Travel</option>
		</select>	-->
		
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

	<input type="submit" value="Add A Film"/>
	 <p>*required</p> 
	</form>
	
	<form action="home.do" method="GET">
		<input type="submit" value="Home"/>

	</form>	
	



</body>
</html>