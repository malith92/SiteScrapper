package com.malith.SimpleJSONHandler;

import java.util.Date;
import java.util.List;

import com.malith.TorrentSiteScrapper.Movie;

public abstract class WriteJSON
{
	private List<Movie> movieList;
	private String location;
	private String fileName;
	private String fileNameWithLocation;
	
	public WriteJSON()
	{
		
	}
	
	public WriteJSON(List<Movie> movieList, String location)
	{
		this.movieList = movieList;
		this.location = location;
		this.fileName = createFileName();
	}
	
	public String getFileName()
	{
		return fileName;
	}

	private String createFileName()
	{
		String date = new Date().toString().replaceAll(":", ".");
		String fileName = date+".json";
		return fileName;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}

	public String getFileNameWithLocation()
	{
		this.fileNameWithLocation = location+fileName;
		return fileNameWithLocation;
	}

	public abstract void writeJSONContentToFile();
}
