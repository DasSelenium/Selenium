package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.loginpageclass;
import com.utility.browserfactory;
import com.utility.configDataProvider;
import com.utility.exceldataProvider;

public class loginApp extends BaseClass {
	
	//this is a new comment from Milan 

	@Test
	public void launchPage() throws InterruptedException {
		
		loginpageclass loginpageclass = PageFactory.initElements(driver, loginpageclass.class);
		loginpageclass.loginmethod(exl.getStringdata("Login", 0, 0), exl.getStringdata("Login", 0, 1));

	}

}
