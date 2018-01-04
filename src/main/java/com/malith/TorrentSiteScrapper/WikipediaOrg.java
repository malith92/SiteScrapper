package com.malith.TorrentSiteScrapper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaOrg
{
	private List<Movie> movieList;
	private WebDriver driver;

	private String boxOfficeXpath;
	private String basicUrl;

	private String Url;

	public WikipediaOrg(List<Movie> movieList, WebDriver driver)
	{
		this.movieList = movieList;
		this.driver = driver;

		this.boxOfficeXpath = "//th[text()='Box office']/../td";
		this.basicUrl = "https://en.wikipedia.org/wiki/";

		this.getBoxOfficeRecords();
	}

	private void getBoxOfficeRecords()
	{
		for (Movie movie : movieList)
		{
			this.Url = this.basicUrl + movie.getName().replaceAll(" ", "_") + "_(film)";

			System.out.println("\nUrl : " + this.Url);

			this.driver.get(Url);

			try
			{
				String boxOfficeElementContent = driver.findElement(By.xpath(this.boxOfficeXpath))
						.getAttribute("innerText");

				System.out.println(boxOfficeElementContent);

				double bO = 0.0;

				String boxOffice = boxOfficeElementContent.substring(0, boxOfficeElementContent.indexOf("[")).trim()
						.replaceAll("[^a-zA-Z0-9.]", "");

				if (boxOfficeElementContent.contains("million"))
				{
					bO = Double.parseDouble(boxOffice.split("million")[0].replace(",", ""));
				}
				else if (boxOfficeElementContent.contains("billion"))
				{
					bO = Double.parseDouble(boxOffice.split("billion")[0].replace(",", "")) * 100.0;
				}
				else
				{
					bO = Double.parseDouble(boxOffice.replace(",", "")) / 100.0;
				}

				System.out.println(bO);
				movie.setBoxOffice(bO);
			}
			catch (Exception e)
			{
				System.out.println("Exception : " + e);
				movie.setBoxOffice(0.0);
				System.out.println("Box Office Element Not found !\n");
			}
		}
	}

	public List<Movie> getMovieList()
	{
		return this.movieList;
	}

}
