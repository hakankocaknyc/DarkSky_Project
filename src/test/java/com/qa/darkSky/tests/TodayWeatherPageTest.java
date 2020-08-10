package com.qa.darkSky.tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darkSky.base.BasePage;
import com.qa.darkSky.pages.TodayWeatherPage;



public class TodayWeatherPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
  TodayWeatherPage todayWeatherPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		 
		todayWeatherPage = new TodayWeatherPage(driver);			
	}
	@Test
	public void verifyTemp() throws InterruptedException {
		todayWeatherPage.clickCurrentLocation();
		todayWeatherPage.gettingLowestAndHighestTemp();
		
	}
	@Test
	public void clickToday(){
		todayWeatherPage.clickToday();
	}
	@AfterTest
	public void tearDown() {
//		driver.quit();
		
	}}





