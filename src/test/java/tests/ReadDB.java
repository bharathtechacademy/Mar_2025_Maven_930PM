package tests;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import utilities.DBUtil;

public class ReadDB {

	public static void main(String[] args) throws SQLException {
		
		List<Map<String, String>> data = DBUtil.readData(DbQueries.HORROR_MOVIE_LIST);
		
		for(Map<String, String> row : data) {
			System.out.println(row);
		}
		
		System.out.println(data.get(1).get("movie_name"));

	}

}
