package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Service
public class FilmDAOJdbcImpl implements FilmDAO {

		private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
		private static final String user = "student";
		private static final String pass = "student"; //change to student 

		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		@Override
		public Film findFilmByID(int filmID) {
			Film film = null;

			try {
				Connection conn = DriverManager.getConnection(URL, user, pass);

				String sql = "SELECT DISTINCT film.id, film.title, description, release_year, language_id, rental_duration,"
						+ "rental_rate, length, replacement_cost, rating, special_features, category.name, film_category.category_id"
						+ " FROM film " 
						+ " JOIN film_category ON film.id = film_category.film_id "
						+ " JOIN category ON film_category.category_id = category.id WHERE film.id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, filmID);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					film = new Film();
					film.setfilmID(rs.getInt("film.id"));
					film.setTitle(rs.getString("film.title"));
					film.setDescription(rs.getString("description"));
					film.setReleaseYear(rs.getShort("release_year"));
					film.setLanguageId(rs.getInt("language_id"));
					film.setRentalDuration(rs.getInt("rental_duration"));
					film.setRentalRate(rs.getDouble("rental_rate"));
					film.setLength(rs.getInt("length"));
					film.setReplacementCost(rs.getDouble("replacement_cost"));
					film.setRating(rs.getString("rating"));
					film.setSpecialFeatures(rs.getString("special_features"));
					//film.setLanguage(rs.getString("language.name"));
					film.setActors(findActorsByFilmID(rs.getInt("film.id")));
					film.setCategory(rs.getString("category.name"));
					film.setCategory_id(rs.getInt("film_category.category_id"));
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return film;
		}

		@Override
		public List<Film> findFilmByKeyword(String keyword) {
			List<Film> filmByKeyword = new ArrayList<>();

			try {
				Connection conn = DriverManager.getConnection(URL, user, pass);

				String sql = "SELECT DISTINCT film.id, title, description, release_year, language_id, rental_duration,"
						+ "rental_rate, length, replacement_cost, rating, special_features"
						+ " FROM film"
						+ " JOIN film_actor ON film.id = film_actor.film_id"
						+ " WHERE film.title LIKE ? OR film.description LIKE ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, "%" + keyword + "%");
				stmt.setString(2, "%" + keyword + "%");
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					Film film = new Film();
					film.setfilmID(rs.getInt("film.id"));
					film.setTitle(rs.getString("title"));
					film.setDescription(rs.getString("description"));
					film.setReleaseYear(rs.getShort("release_year"));
					film.setLanguageId(rs.getInt("language_id"));
					film.setRentalDuration(rs.getInt("rental_duration"));
					film.setRentalRate(rs.getDouble("rental_rate"));
					film.setLength(rs.getInt("length"));
					film.setReplacementCost(rs.getDouble("replacement_cost"));
					film.setRating(rs.getString("rating"));
					film.setSpecialFeatures(rs.getString("special_features"));
					//film.setLanguage(rs.getString("language.name"));
					film.setActors(findActorsByFilmID(rs.getInt("film.id")));
					filmByKeyword.add(film);
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return filmByKeyword;
		}

		@Override
		public List<Actor> findActorsByFilmID(int filmID) {
			List<Actor> actors = new ArrayList<>();

			try {
				Connection conn = DriverManager.getConnection(URL, user, pass);

				String sql = "SELECT actor.id, actor.first_name, actor.last_name "
						+ " FROM actor JOIN film_actor ON actor.id = film_actor.actor_id "
						+ " JOIN film ON film.id = film_actor.film_id WHERE film.id = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, filmID);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Actor actor = new Actor();
					actor.setId(rs.getInt("actor.id"));
					actor.setFirstName(rs.getString("actor.first_name"));
					actor.setLastName(rs.getString("actor.last_name"));
					actors.add(actor);
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return actors;
		}

		@Override
		public Actor findActorByID(int actorID) {
			Actor actor = null;

			try {
				Connection conn = DriverManager.getConnection(URL, user, pass);

				String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
				
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, actorID);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					actor = new Actor();
					actor.setId(rs.getInt("id"));
					actor.setFirstName(rs.getString("first name"));
					actor.setLastName(rs.getString("last name"));
				}
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return actor;
		}

		@Override 
		public Film createFilm(Film film) {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(URL, user, pass);
				conn.setAutoCommit(false); // START TRANSACTION
				
				String sqlInsertFilm = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, "
						+ "replacement_cost, rating, special_features)" 
						+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement stmt = conn.prepareStatement(sqlInsertFilm, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, film.getTitle());
				stmt.setString(2, film.getDescription());
				stmt.setInt(3, film.getReleaseYear());
				stmt.setInt(4, film.getLanguageId());
				stmt.setInt(5, film.getRentalDuration());
				stmt.setDouble(6, film.getRentalRate());
				stmt.setDouble(7, film.getLength());
				stmt.setDouble(8, film.getReplacementCost());
				stmt.setString(9, film.getRating());
				stmt.setString(10, film.getSpecialFeatures());

				int updateCount = stmt.executeUpdate(); 
				if (updateCount == 1) {
					ResultSet rs = stmt.getGeneratedKeys();

					if (rs.next()) { 
						int newfilmId = rs.getInt(1);
						film.setfilmID(newfilmId); 
						
						if (film.getfilmID() != 0) {
							stmt.setInt(1, newfilmId);
							updateCount = stmt.executeUpdate();
						}
//						if (film.getActors() != null && film.getActors().size() > 0) {
//							String sqlInsertActors = "INSERT INTO film_actor (film_id, actor_id) values(?, ?)"; 
//							stmt = conn.prepareStatement(sqlInsertActors, Statement.RETURN_GENERATED_KEYS);
//							for (Actor actor : film.getActors()) {
//								stmt.setInt(1, film.getfilmID());
//								stmt.setInt(2, actor.getId());
//								stmt.executeUpdate();
//							}
						}
					}
//				} else {
//					film = null;
//				}
				conn.commit();
				stmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException sqle2) {
						System.err.println("Error trying to rollback");
					}
				}
				throw new RuntimeException("Error inserting " + film);
			}
			return film;
		}

		public boolean deleteFilm(Film film) {
			Connection conn = null;
			
			try {
				String sqlFilmCategory = "DELETE FROM film_category where film_id = ?"; 
				String sqlFilmActor = "DELETE FROM film_actor where film_id = ?"; 
				String sqlFilm = "DELETE FROM film WHERE id = ?";
				
				conn = DriverManager.getConnection(URL, user, pass);
				conn.setAutoCommit(false); // START TRANSACTION
				
				PreparedStatement stmt = conn.prepareStatement(sqlFilmCategory);
				stmt.setInt(1, film.getfilmID());
				stmt.executeUpdate();
				
				stmt = conn.prepareStatement(sqlFilmActor);
				stmt.setInt(1, film.getfilmID());
				stmt.executeUpdate();

				stmt = conn.prepareStatement(sqlFilm);
				stmt.setInt(1, film.getfilmID());
				stmt.executeUpdate();

				conn.commit();
				stmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException sqle2) {
						System.err.println("Error trying to rollback");
					}
				}
				return false;
			}
			return true;
		}
		
		@Override 
		public boolean updateFilm(Film film) {
			Connection conn = null;
			
			try {
				String sql = "UPDATE film set "
						+ "title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?, "
						+ "rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ? "
						+ " WHERE id = ?";
				
				conn = DriverManager.getConnection(URL, user, pass);
				conn.setAutoCommit(false); // START TRANSACTION
				
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, film.getTitle());
				stmt.setString(2, film.getDescription());
				stmt.setInt(3, film.getReleaseYear());
				stmt.setInt(4, film.getLanguageId());
				stmt.setInt(5, film.getRentalDuration());
				stmt.setDouble(6, film.getRentalRate());
				stmt.setDouble(7, film.getLength());
				stmt.setDouble(8, film.getReplacementCost());
				stmt.setString(9, film.getRating());
				stmt.setString(10, film.getSpecialFeatures());
				stmt.setInt(11, film.getfilmID());
				stmt.executeUpdate();
				
				int updateCount = stmt.executeUpdate(); 
				if (updateCount == 1) {
					String sqlDeleteAssociatedFilmActor = "DELETE FROM film_actor WHERE film_id =?";
					stmt = conn.prepareStatement(sqlDeleteAssociatedFilmActor);
					
					stmt.setInt(1, film.getfilmID());
					stmt.executeUpdate();
					
					String sqlInsertNewAssociatedFilmActor = "INSERT INTO film_actor WHERE (film_id, actor_id) "
							+ "VALUES (?,?)";
	
					stmt = conn.prepareStatement(sqlInsertNewAssociatedFilmActor);
					if (film.getActors() != null) {
						for (Actor actor : film.getActors()) {
							stmt.setInt(1, film.getfilmID());
							stmt.setInt(1, actor.getId());
						}
					} 
				} conn.commit();
				
				stmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException sqle2) {
						System.err.println("Error trying to rollback");
					}
				}
				return false;
			}
			return true;
	}
		
	@Override 
	public Film findCreatedFilmById(int filmID) {
		Film film = null; 
		try {
			String sql = "SELECT * FROM film WHERE id = ?"; 
			
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, filmID);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				film = new Film();
				film.setfilmID(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getShort("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				//film.setLanguage(rs.getString("language.name"));
				//film.setActors(findActorsByFilmID(rs.getInt("film.id")));
				//film.setCategory(rs.getString("film_category"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	
}
