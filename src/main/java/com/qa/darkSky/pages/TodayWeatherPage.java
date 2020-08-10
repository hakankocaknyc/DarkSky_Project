package com.qa.darkSky.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darkSky.base.BasePage;
import com.qa.darkSky.util.ElementUtil;
import com.qa.darkSky.util.JavaScriptUtil;


public class TodayWeatherPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	
	By currentLocation=By.xpath("//a[@class='currentLocationButton']//img");
	By today  = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]");
	By allTemp = By.xpath("(//div[@class='temps'])//span//span");
	By currentTemp=By.xpath("//span[@class='summary swap']");
	
	
	public TodayWeatherPage(WebDriver driver) {
		 
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
		
		 
	}
	
	public void clickCurrentLocation() throws InterruptedException{
		Thread.sleep(3000);
		elementUtil.doClick(currentLocation);
		Thread.sleep(3000);
	javaScriptUtil.specificScrollPageDown(driver);
	Thread.sleep(3000);
	
		
		}
	public void clickToday(){
		elementUtil.doClick(today);
		
	}
	
	

		public void gettingLowestAndHighestTemp() {
	   	
		List<WebElement> tempList= driver.findElements(allTemp);
		ArrayList<Integer> tempInt= new ArrayList<Integer>();
		
		for (int i = 0; i < tempList.size(); i++) {
			String tempText= tempList.get(i).getText();
			
			tempInt.add(Integer.parseInt(tempText.replaceAll("[^\\d.]", "")));
			System.out.println("Temperature is: " +tempInt.get(i));
			
		}
			 Integer[] array = tempInt.toArray(new Integer[0]);
			 int lowest = array[0]; 
			 for(int x : array ){
			  if (x < lowest) {
			    lowest = x;
			 }}System.out.println("Lowest temperature is: " + lowest);
			  
			 int highest=array[0];
			 int i;
		
			 for (i = 1; i < array.length; i++) 
		       if (array[i] > highest) 
		         highest = array[i]; 
			 System.out.println("Highest temperature is: " +highest);
		     
		
	}
}
