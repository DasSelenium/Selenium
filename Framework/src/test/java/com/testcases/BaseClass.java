package com.testcases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
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

	@BeforeClass
	public void setup() {
		driver = browserfactory.launchapplication(driver, config.getBrowser(), config.getURL());
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
