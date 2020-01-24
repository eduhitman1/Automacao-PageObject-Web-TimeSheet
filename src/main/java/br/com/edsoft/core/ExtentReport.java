package br.com.edsoft.core;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import br.com.edsoft.ct.CTLANCA002;

public class ExtentReport {

	@SuppressWarnings("unlikely-arg-type")

	public void extendReport() throws IOException {
		// start reporters
		ExtentHtmlReporter Reporter = new ExtentHtmlReporter("src/main/resources/report/CTLANCA001.html");

		ExtentReports extent = new ExtentReports();

		extent.attachReporter(Reporter);

		ExtentTest logger = extent.createTest("CTLANCA001");

		logger.log(Status.INFO, "Lançamento de timeSheet");

		CTLANCA002 ct2 = new CTLANCA002();
		
		ct2.CTLANCA002();
		
		if(ct2.equals(Status.PASS)) {
		logger.log(Status.PASS, "CTLANCA001 passou");

		}else {
			logger.log(Status.FAIL, "CTLANCA001 Erro");	
		}
		
		
		logger.info("This step shows usage of info(details)");

		logger.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		logger.addScreenCaptureFromPath("screenshot.png");

		extent.flush();
	}

}
