package com.syntax.practice;

import com.syntax.utils.ConfigUtility;

public class TestConfigUtility extends ConfigUtility{

	public static void main(String[] args) {
		
		String browser=getProperty("browser");
		System.out.println(browser);
		
		String url=getProperty("url");
		System.out.println(url);
	}
}
