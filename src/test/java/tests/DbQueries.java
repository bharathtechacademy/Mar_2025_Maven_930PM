package tests;

public class DbQueries {

	public static final String HORROR_MOVIE_LIST = "SELECT FILM.TITLE AS MOVIE_NAME, CATEGORY.NAME AS MOVIE_CATEGORY, LANGUAGE.NAME AS MOVIE_LANGUAGE FROM CATEGORY\r\n"
			+ "JOIN\r\n"
			+ "FILM_CATEGORY\r\n"
			+ "ON CATEGORY.CATEGORY_ID = FILM_CATEGORY.CATEGORY_ID\r\n"
			+ "JOIN\r\n"
			+ "FILM\r\n"
			+ "ON\r\n"
			+ "FILM_CATEGORY.FILM_ID=FILM.FILM_ID\r\n"
			+ "JOIN\r\n"
			+ "LANGUAGE\r\n"
			+ "ON\r\n"
			+ "FILM.LANGUAGE_ID = LANGUAGE.LANGUAGE_ID\r\n"
			+ "WHERE\r\n"
			+ "CATEGORY.NAME = 'Horror'\r\n"
			+ "AND\r\n"
			+ "LANGUAGE.NAME='English'\r\n"
			+ "ORDER BY FILM.TITLE ASC\r\n"
			+ "LIMIT 10;";

}
