package com.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.beust.jcommander.Parameter;
import com.utility.Helper;
import com.utility.browserfactory;
import com.utility.configDataProvider;
import com.utility.exceldataProvider;

public class BaseClass {

	WebDriver driver;
	public exceldataProvider exl;
	configDataProvider config;
	public ExtentReports report ;
	
	
	@BeforeSuite
	public void SuiteSetup() {
		
		exl = new exceldataProvider();
	 config = new configDataProvider();
	 
	 
	 
	 report = new ExtentReports();
	 report.attachReporter();
	 
	 {
	};
	

	}
     @Parameters({"browser", "url"})
	@BeforeClass
	public void setup(String browser, String url) {
		//driver = browserfactory.launchapplication(driver, config.getBrowser(), config.getURL());
		
		driver = browserfactory.launchapplication(driver, browser, url);
	}

	@AfterClass
	public void close() {

		browserfactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void screenshot(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	}
	

}
