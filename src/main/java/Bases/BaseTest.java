package Bases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import Utils.Const;

public class BaseTest {
	protected WebDriver driver;
	
	
	public BaseTest(String nameBrowser){
		driver = instanceBrowser(nameBrowser);
	}
	
	protected void closeWebDriver(WebDriver driver){
		System.out.println("Cerrando el driver");
		driver.close();
		driver.quit();
	}
	
	
	//Metodo para configurar e instanciar el driver
	protected WebDriver instanceBrowser(String nameBrowser){
		if(nameBrowser.equalsIgnoreCase(Const.FIREFOX)){
			System.setProperty(Const.FIREFOXKEY, Const.FIREFOXPATH);
			driver = new FirefoxDriver();
		}else if(nameBrowser.equalsIgnoreCase(Const.CHROME)){
			System.setProperty(Const.CHROMEKEY, Const.CHROMEPATH);
			driver = new ChromeDriver();
		}else if(nameBrowser.equalsIgnoreCase(Const.INTERNETEXPLORER)){
			System.setProperty(Const.INTERNETEXPLORERKEY, Const.INTERNETEXPLORERPATH);
			driver = new InternetExplorerDriver();
		}else{
			System.out.println("El navegador "+nameBrowser+" no se encuentra disponible, asi que trabaja con Firefox.");
			System.setProperty(Const.FIREFOXKEY, Const.FIREFOXPATH);
			driver = new FirefoxDriver();
		}
	return driver;
	}
	
	
	protected String getTimeNow(){
		Date moment = Calendar.getInstance().getTime();
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh_mm_ss dd-MM-yyyy");
		String valueTime = timeFormat.format(moment); 
		return valueTime;
	}
	
	
	/*
	 *  Capturar screenshot 
	 */
	protected void captureScreenshot(WebDriver driver){
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try{
			FileUtils.copyFile(src, new File(Const.SCREENSHOTSPATH+"img"+"_"+getTimeNow()+".png"));
		}catch(IOException e){
			System.out.println(Const.EXCEPTIONMESSAGE + e.getMessage());
		}
	}
	
	/*
	 * Terminacion de los Tests
	 */
	
	@AfterMethod
	public void OnFailure(ITestResult testResult){
		if(testResult.getStatus()==ITestResult.FAILURE){
			System.out.println("Fallo el test:  Ademas revisar la captura de pantalla");
			captureScreenshot(driver);
		}else if(testResult.getStatus()==ITestResult.SUCCESS){
			System.out.println("El test fue exitoso: ");
		}
	}
	
/*	@AfterSuite
	public void executeCloseWebDriver(){
		closeWebDriver(driver);
	} */
	
	
	
}
