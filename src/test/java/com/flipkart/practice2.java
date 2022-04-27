package com.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions ;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class practice2 {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//1.In place WebDriver we can use RemoteWebDriver
		FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		driver.get("https://www.flipkart.com");
		//Close Banner
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']"))).click();
		//click on Mobiles
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mobiles']"))).click();
		//click on Electronics
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Electronics']"))).click();
	    // select Mi
		String x="Mi";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+x+"']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated
				   (By.xpath("//option[text()='Min']/parent::select"))).click();
		//Select Range
		WebElement min = driver.findElement(By.xpath("//option[text()='Min']/parent::select"));
		//min.click();
		List<WebElement> range = min.findElements(By.xpath("//option"));
		//option[text()='₹4000']
		for(WebElement e:range)
		{
			String minValue ="4000";
			String str= e.getText();
			   if(str.contains(minValue))
			   {
				   e.click();
			   }
			  break;
		   
		}
		//driver.findElement(By.xpath("(//option[text()='₹2000']/parent::select)[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("(//option[text()='₹2000']/parent::select)[2]"))).click();
		WebElement max = driver.findElement(By.xpath("(//option[text()='₹2000']/parent::select)[2]"));
		List<WebElement> maxRange = max.findElements(By.xpath("child::option"));
		for(WebElement e:maxRange)
		{
			String minValue ="30000";
			String str= e.getText();
			   if(str.contains(minValue))
			   {
				   e.click();
			   }
			   break;	   
		}
		//get count of item in between range
		WebElement pe = driver.findElement(By.xpath("//div[contains(text(),'Redmi')]/ancestor::div[7]"));
		List<WebElement> mob = pe.findElements(By.xpath("//div[contains(text(),'Redmi')]"));
		int count=0;
		for(WebElement e:mob)
		{
			String str = e.getText();
			//System.out.println(str);
			if(str.contains("Redmi")||str.contains("Xiaomi")||str.contains("REDMI"))
			{
				count++;
			}
			
		}
		System.out.printf("The Count of Mobiles in between range is %d",count);
	}
}
