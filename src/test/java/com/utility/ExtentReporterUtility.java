package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extestTest=new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName) {
		
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter(
				System.getProperty("user.dir")+"//" + reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
		}
	public static void createExtentTest(String testName) {
		
	      ExtentTest test = extentReports.createTest(testName);
	      extestTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extestTest.get();
		
	}
	public static void flushReport() {
		extentReports.flush();
	}
	

}
