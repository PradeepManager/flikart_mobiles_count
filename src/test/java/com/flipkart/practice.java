package com.flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {
	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Electronics']")).click();
		Thread.sleep(5000);
		String x="Mi";
		driver.findElement(By.xpath("//a[text()='"+x+"']")).click();
		
		
		
	}
}
