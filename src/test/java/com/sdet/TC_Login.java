package com.sdet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Login {

	@Test
	public void login_Test()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://virtualpay-qa-fe.csi-infra.com/login");
		
		driver.findElement(By.name("email")).sendKeys("lkk@yopmail.com");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//System.out.println(driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(),"Virtual Pay");
		
		driver.close();
	}
}
