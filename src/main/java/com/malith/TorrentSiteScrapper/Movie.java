package com.malith.TorrentSiteScrapper;

import java.util.List;

public class Movie
{
	private String name;
	private int year;
	private double imdbRating;
	private List <String> genres;
	private double boxOffice;
		
	public Movie()
	{
		super();
	}

	public Movie(String name, int year, double imdbRating, List<String> genres)
	{
		super();
		this.name = name;
		this.year = year;
		this.imdbRating = imdbRating;
		this.genres = genres;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getYear()
	{
		return this.year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public double getImdbRating()
	{
		return this.imdbRating;
	}

	public void setImdbRating(double imdbRating)
	{
		this.imdbRating = imdbRating;
	}

	public List<String> getGenres()
	{
		return this.genres;
	}

	public void setGenres(List<String> genres)
	{
		this.genres = genres;
	}
	

	public double getBoxOffice()
	{
		return boxOffice;
	}

	public void setBoxOffice(double boxOffice)
	{
		this.boxOffice = boxOffice;
	}

	@Override
	public String toString()
	{
		String genres = String.join(", ", this.genres);
		
		return "Name : "+this.name+"\nYear : "+this.year+"\nIMDB Rating : "+this.imdbRating+"\nGenres : "+genres;
	}	
}
