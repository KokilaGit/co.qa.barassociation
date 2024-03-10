package com.ba.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
//	public driver access to sue in entire project
   public  static WebDriver  driver;
   Properties properties;
   
   public BaseClass() {
	   
//	   this constructor is for properties file
	   try {
//		   path to config file to read url and browser properties
		  File file = new File("./src/test/resources/config/config.properties");
		  FileInputStream fileInSrm = new FileInputStream(file);
//		  to read properties file need to create properties object
		  properties = new Properties();
		 properties.load(fileInSrm);
		   
	   }
	   catch (Exception e) {
		   System.out.println("unable to load property file");
		   e.printStackTrace();
	   }
   }
   
   @BeforeMethod
   public void initApplication() {
	  String browser = properties.getProperty("browser");
	  if(browser.equalsIgnoreCase("chrome")) {
		  driver = new ChromeDriver();
	  }
	  else if(browser.equalsIgnoreCase("firefox")) {
		  driver = new FirefoxDriver();
	  }
	  else if(browser.equalsIgnoreCase("edge")) {
		  driver = new EdgeDriver();
	  }
	  else {
		  System.out.println("unsupported browser type. Please check config file");
	  }
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.getUrl();
//		driver.get("https://dev-colo-3.intouchondemand.com/barlanding.aspx");
   }
   
   public  void getUrl() {
	    String url = properties.getProperty("url");
	    driver.get(url);
	    
   }
   
   public  void quitDriver() {
	    driver.quit();
	    
  }
	

//	@AfterMethod
//	public void afterMethod() {
//		driver.quit();
//	}
}
