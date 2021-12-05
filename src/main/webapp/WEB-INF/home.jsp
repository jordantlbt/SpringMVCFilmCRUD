<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC Film Site</title>
</head>
<body>

<h1>Mock Buster</h1>

<h2> Welcome to MockBuster online!</h2>



<h2>Search for a film:</h2>

<h3>Find a film by id</h3>
	<form action="searchid.do" method="GET">
		<input type="text" name="filmID" size="8"/> 
		<input type="submit" value="Get Film" />   <!--name="~~" must match params in FilmController -->
	</form>

<h3>Find a film by keyword</h3>
	<form action="searchkeyword.do" method="GET">
		<input type="text" name="keyword" size="10"/> 
		<input type="submit" value="Get Film" />
	</form>

	
	
<!-- 	
<h3>Find Actors by Film id</h3>
	<form action="search.do" method="GET">
		<input type="text" name="id" size="3"/> 
		<input type="submit" value="Get Film" />
	</form>
	
<h3>Find Actors by actor id</h3>
	<form action="search.do" method="GET">
		<input type="text" name="id" size="3 "/> 
		<input type="submit" value="Get Film" />
	</form>	
	
	
-->	
	
	
	
<h2>Add a new film</h2>	

<h3>Add a film</h3>
	
	<a href="createFilm.jsp">Add a film</a>
	

<h3>Delete a film</h3>
	<form action="deletefilm.do" method="GET">
		<input type="submit" value="Delete A Film" />
	</form>	

<h3>Update a film</h3>
	<form action="updatefilm.do" method="GET">
		<input type="submit" value="Update A Film" />
	</form>
	
<h3>Search newly created films by film id</h3>
	<form action="searchid.do" method="GET">
		<input type="text" name="id" size="8"/> 
		<input type="submit" value="Search New Films" />
	</form>	

</body>
</html> 