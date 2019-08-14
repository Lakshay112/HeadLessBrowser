package com.task.HeadLess.HeadLessB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;		

public class App {				
		public static void main(String[] args) {
			
			ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/ExtentReports.html");
			  ExtentReports extent = new ExtentReports();
		        extent.attachReporter(reporter);
		        ExtentTest test = extent.createTest("Google Search", "Here i am testing google search functionality");
		        
                     WebDriver driver = new HtmlUnitDriver();
                     
                     test.log(Status.INFO,"starting test case");
                     
                     driver.get("http://www.google.com");
                     test.pass("Navigate to google.com");

                     WebElement element = driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input"));
                     test.pass("Enter text in search box");
   
                    element.sendKeys("Weather Today");	
 
                    element.submit();			
      
                    System.out.println("Page title is: " + driver.getTitle());		
                    
                    driver.quit();
                    test.pass("closed the browser");
                    
                    test.pass("Complete the test");
                    extent.flush();
         }		
}
