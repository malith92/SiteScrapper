package com.malith.TorrentSiteScrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaPage
{

	public static void main(String[] args)
	{
		// declaration and instantiation of objects/variables

		System.setProperty("webdriver.chrome.driver", "//home//malith//Documents//chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://en.wikipedia.org/wiki/Finding_Nemo_(film)";
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();

		//String boxOfficeElementContent = driver.findElement(By.xpath("//th[text()='Box office']/../td")).getText();

		WebElement boxOfficeElementContent = driver.findElement(By.xpath("//th[text()='Box office']/../td"));
		System.out.println(boxOfficeElementContent);
		/*String boxOffice = boxOfficeElementContent.substring(1, boxOfficeElementContent.indexOf("["));

		double bO = 0.0;

		if (boxOffice.contains("million"))
		{
			bO = Double.parseDouble(boxOffice.split(" ")[0].replace(",", ""));
		}
		else if (boxOffice.contains("billion"))
		{
			bO = Double.parseDouble(boxOffice.split(" ")[0].replace(",", "")) * 100.0;
		}
		else
		{
			bO = Double.parseDouble(boxOffice.replace(",", "")) / 100.0;
		}*/

		/*
		 * compare the actual title of the page with the expected one and print the
		 * result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed");
		}

		// close Fire fox
		driver.close();

		System.out.println("boxOfficeElementContent : " + boxOfficeElementContent);

		//System.out.println("boxOffice : " + boxOffice);

		double d = 600000.0 / 1000000000;
		System.out.printf("dexp: %f\n", d);

	}
}
