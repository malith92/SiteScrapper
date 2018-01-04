package com.malith.SimpleJSONHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.malith.TorrentSiteScrapper.Movie;

public class WriteJSONWithJSONSimple extends WriteJSON
{
	private JSONArray movieListJSONArray;

	public WriteJSONWithJSONSimple(List<Movie> movieList, String location)
	{
		super(movieList, location);
		this.movieListJSONArray = new JSONArray();
		
		this.createJSONArray();
		this.writeJSONContentToFile();
	}

	private void createJSONArray()
	{
		for (Movie movie : super.getMovieList())
		{
			JSONObject movieDetails = new JSONObject();

			JSONArray genreListJSONArray = new JSONArray();

			for (String genre : movie.getGenres())
			{
				genreListJSONArray.add(genre);
			}

			movieDetails.put("Name", movie.getName());
			movieDetails.put("Year", movie.getYear());
			movieDetails.put("IMDBRating", movie.getImdbRating());
			movieDetails.put("Genres", genreListJSONArray);

			this.movieListJSONArray.add(movieDetails);
		}
	}

	public void writeJSONContentToFile()
	{		
		// Write JSON file
		FileWriter file;
		try
		{
			file = new FileWriter(super.getFileNameWithLocation());
			String content = this.movieListJSONArray.toJSONString();
			System.out.println(content);
			file.write(content);
			file.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
