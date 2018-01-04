package com.malith.TorrentSiteScrapper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.malith.JacksonJSONHandler.JSONHandler;

public class App
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "//home//malith//Documents//chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		//YTS
		YtsAg ytsAg = new YtsAg(driver);

		List<Movie> movieList = ytsAg.getMovieList();

		

		JSONHandler jacksonParser = new JSONHandler();
		//jacksonParser.print(movieList);

		jacksonParser.writeContent("//home//malith//Documents//", movieList);

		//Wikipedia
		WikipediaOrg wiki = new WikipediaOrg(movieList, driver);
		
		driver.close();
		
		//jacksonParser.print(wiki.getMovieList());
		//jacksonParser.writeContent("//home//malith//Documents//", wiki.getMovieList());


	}
}
