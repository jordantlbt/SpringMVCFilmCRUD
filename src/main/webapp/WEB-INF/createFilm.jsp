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
		<label for="filmTitle">*Title: </label>
		<input type="text" name="filmTitle" size="8"/> 
	<br>
		<label for="filmDescription">*Description: </label>
		<input type="text" name="filmDescription" size="8"/> 
	<br>	
		<label for="filmReleaseYear">*Release Year: </label>
		<input type="text" name="filmReleaseYear" size="8"/> 
	<br>
		<label for="filmTitle">Rental Duration: </label>
		<input type="text" name="filmTitle" size="8"/> 
	<br>
		<label for="filmDescription">Rental Rate: </label>
		<input type="text" name="filmDescription" size="8"/> 
	<br>	
		<label for="filmReleaseYear">Film Length: </label>
		<input type="text" name="filmReleaseYear" size="8"/> 
	<br>
		<label for="filmTitle">Rating: </label>
		<input type="text" name="filmTitle" size="8"/> 
	<br>
		<label for="filmDescription">Special Features: </label>
		<input type="text" name="filmDescription" size="8"/> 
	<br>	
		<label for="filmReleaseYear">Replacement Cost: </label>
		<input type="text" name="filmReleaseYear" size="8"/> 
	<br>
	
		<input type="submit" value="Add A Film"/>
	<p>*required</p>
		
	</form>



</body>
</html>