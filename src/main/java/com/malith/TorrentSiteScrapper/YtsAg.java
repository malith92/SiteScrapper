package com.malith.TorrentSiteScrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YtsAg
{
	private WebDriver driver;
	private String Url;
	private String basicXpath;
	private List<Movie> movieList;
	private String firstWindowHandle;
	private Set<String> windowHandles;

	public YtsAg(WebDriver driver)
	{
		this.driver = driver;
		this.Url = "https://yts.am/browse-movies/0/all/all/0/rating";
		this.basicXpath = "//div[@class='browse-movie-wrap col-xs-10 col-sm-4 col-md-5 col-lg-4']/..";
		this.movieList = new ArrayList<Movie>();
	}

	public YtsAg(WebDriver driver, String Url)
	{
		this.driver = driver;
		this.Url = Url;
		this.basicXpath = "//div[@class='browse-movie-wrap col-xs-10 col-sm-4 col-md-5 col-lg-4']/..";
		this.movieList = new ArrayList<Movie>();
	}

	public List<Movie> getMovieList()
	{
		scrapeWebSite();

		return movieList;
	}

	private void scrapeWebSite()
	{
		this.driver.get(Url);
		
		this.firstWindowHandle = driver.getWindowHandle();

		String lastLinkXpath = "//ul[@class='tsc_pagination tsc_paginationA tsc_paginationA06']//a[contains(text(), 'Last')]";

		int lastPageNo = Integer.parseInt(driver.findElement(By.xpath(lastLinkXpath)).getAttribute("href").split("=")[1]);

		for(int i=1; i<=2; i++)
		//for(int i=1; i<=lastPageNo; i++)
		{
			String linkXpath = "//ul[@class='tsc_pagination tsc_paginationA tsc_paginationA06']//a[contains(text(), '"+i+"')]";
			WebElement pageLink = driver.findElement(By.xpath(linkXpath));
			pageLink.click();
			this.windowHandles = driver.getWindowHandles();
			
			for(String windowHandle : windowHandles)
			{
				if(!this.firstWindowHandle.equals(windowHandle))
				{
					driver.switchTo().window(windowHandle);
					driver.close();
				}
			}
			driver.switchTo().window(firstWindowHandle);
			extractPageDetails();
		}
	}

	private void extractPageDetails()
	{
		WebElement rootWebElement = driver.findElement(By.xpath(basicXpath));

		List<WebElement> webElementsList = rootWebElement.findElements(By.xpath("./*"));

		for (WebElement webElement : webElementsList)
		{
			this.movieList.add(extractMovieDetails(webElement));
		}
	}

	private Movie extractMovieDetails(WebElement webElement)
	{
		// Movie Name
		String movieName = webElement.findElement(By.xpath("./div/a[@class='browse-movie-title']")).getText();

		// Movie Year
		int movieYear = Integer
				.parseInt(webElement.findElement(By.xpath("./div/div[@class='browse-movie-year']")).getText());

		// IMDB Rating
		double movieRating = Double.parseDouble(webElement
				.findElement(By.xpath("./a[@class='browse-movie-link']/figure/figcaption/h4[@class='rating']"))
				.getAttribute("innerText").split("/")[0]);

		// Genres
		List<String> movieGenres = new ArrayList<String>();
		List<WebElement> genreList = webElement
				.findElements(By.xpath("./a[@class='browse-movie-link']/figure/figcaption/h4[not(@class='rating')]"));

		for (WebElement headingElement : genreList)
		{
			movieGenres.add(headingElement.getAttribute("innerText"));
		}

		return new Movie(movieName, movieYear, movieRating, movieGenres);
	}

}
/*
 * Findings :-
 * 
 * Display WebElement's html code :-
 * System.out.println(webElement.getAttribute("innerHTML"));
 * System.out.println(webElement.getAttribute("innerText"));
 *
 * Display all text in tags :- System.out.println(webElement.getText());
 *
 * Sometimes getText() might not work but getAttribute("innerText") will
 * definitely work
 * 
 * getAttribute("innerHTML") will get the text with html formatting preserved
 * e.g:- <p id="test"> This element contains <span>an inner span</span>. </p>
 * innerHtml: " This element     contains <span>an inner span</span>. "
 *
 * Select child WebElement from parent element :- WebElement childElement =
 * parentElement.findElement(By.xpath(".//div"));
 *
 */
