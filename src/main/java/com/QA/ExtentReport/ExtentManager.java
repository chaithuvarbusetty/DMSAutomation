package com.QA.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getReportObject() {

        String path = System.getProperty("user.dir")

                + "/reports/index.html";

        ExtentSparkReporter reporter =

                new ExtentSparkReporter(path);

        reporter.config().setReportName("Automation Test Report");

        reporter.config().setDocumentTitle("Vanix DMS Report");

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo("Tester", "Chaithanya");

        return extent;
    }
}
