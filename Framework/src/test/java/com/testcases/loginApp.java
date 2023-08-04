package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.loginpageclass;
import com.utility.browserfactory;
import com.utility.configDataProvider;
import com.utility.exceldataProvider;

public class loginApp extends BaseClass {
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Reports/ExtentReports.html");

	
	//this is a new comment from Milan 
	//this is second new comment from Milan

	@BeforeTest
	public void beforetest() {
		extent.attachReporter(spark);
	}
	
	@Test
	public void launchPage() throws InterruptedException {
		
		ExtentTest test = extent.createTest("Login to OrangeHR").assignAuthor("Milan Das").assignCategory("Regression").assignDevice("Chrome");
		
		loginpageclass loginpageclass = PageFactory.initElements(driver, loginpageclass.class);
		test.pass("logged in successfully");
		loginpageclass.loginmethod(exl.getStringdata("Login", 0, 0), exl.getStringdata("Login", 0, 1));

	}
	
	@AfterTest
	public void Aftertest() {
		
		extent.flush();
		
	}

}
