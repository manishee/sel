package com.testng.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Parameterization {
	
	WebDriver driver;
	
	@Test
	@Parameters({"url", "fname", "lname", "browser"})
	public void setUp(String url, String fname, String lname, String browser) throws InterruptedException {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mchugh\\Desktop\\JavaTraining\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\mchugh\\Desktop\\JavaTraining\\chromedriver_win32\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\mchugh\\Desktop\\JavaTraining\\chromedriver_win32\\IEDriverServer.exe");
			
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"u_0_e\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"u_0_e\"]")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id=\"u_0_g\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"u_0_g\"]")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@id=\"u_0_y\"]")).click();
		
}
}