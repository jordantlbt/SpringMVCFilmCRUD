package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	
	private List<Actor> actors;
	private int filmID;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String language;
	private String specialFeatures;
	private String category;
	
	public Film() {
		super();
	}

	public Film(int filmID, String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String language,
			String specialFeatures, String category) {
		super();
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.language = language;
		this.specialFeatures = specialFeatures;
		this.category = category; 
	}

// constructor that includes list of actors of film object 
	public Film(List<Actor> actors, int filmID, String title, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String language,
			String specialFeatures, String category) {
		super();
		this.actors = actors;
		this.filmID = filmID;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.language = language;
		this.specialFeatures = specialFeatures;
		this.category = category; 
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getfilmID() {
		return filmID;
	}

	public void setfilmID(int id) {
		this.filmID = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Film [actors=" + actors + ", id=" + filmID + ", title=" + title + ", description=" + description
				+ ", releaseYear=" + releaseYear + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + ", language=" + language + ", specialFeatures=" + specialFeatures + ", category=" + category + "]";
	}
	
	public String toStringFilmBySearch() {
		return "\nID: " + filmID + "\nTitle: " + title + "\nRelease Year: " + releaseYear 
				+ "\nRating: " + rating + "\nDescription: " + description + "\nLanguage: " + language
				+ "\n" + actors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, category, description, filmID, language, languageId, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(category, other.category)
				&& Objects.equals(description, other.description) && filmID == other.filmID
				&& Objects.equals(language, other.language) && languageId == other.languageId && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}
}
