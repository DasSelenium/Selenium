package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configDataProvider {

	Properties pro;

	public configDataProvider() {

		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {

			System.out.println("Unable to load properties file" + e.getMessage());

		}
	}

	public String getdatafromKey(String KeySearch) {

		return pro.getProperty(KeySearch);
	}

	public String getBrowser() {

		return pro.getProperty("Browser");
	}

	public String getURL() {

		return pro.getProperty("qaURL");
	}

}
