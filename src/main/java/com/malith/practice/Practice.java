package com.malith.practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "//home//malith//Documents//chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		
		String firtstWindowName = driver.getWindowHandle();
		
		System.out.println("firtstWindowName : "+firtstWindowName);
		
		WebElement button = driver.findElement(By.id("button1"));
		
		for(int i=0; i<4; i++)
		{
			button.click();
		}
		
		Set <String> windowNames = driver.getWindowHandles();
		
		int count = 1;
		for(String windowName : windowNames)
		{
			System.out.println("Window number "+count+" : "+windowName);
			count++;
		}
		//driver.close();
		
		count = 1;
		for(String windowName : windowNames)
		{
			if(!windowName.equals(firtstWindowName))
			{
				driver.switchTo().window(windowName);
				driver.close();
				System.out.println("Window number "+count+" : "+windowName+" closed !");
			}
			count++;
		}

	}

}
