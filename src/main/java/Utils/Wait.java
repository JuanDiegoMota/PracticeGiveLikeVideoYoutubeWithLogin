package Utils;


import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class Wait {
	
	private WebDriverWait wait;
	private static final int EXPLICITTIMEOUT = 15;
	private static final int PAGELOADTIMEOUT = 10;
	private static final int FLUENTTIMEOUT = 30;
	private static final int verificationTime = 3;
	
	public Wait(WebDriver driver){
		wait = new WebDriverWait(driver, EXPLICITTIMEOUT);
	}
	
	public WebElement explicitWait(WebElement e){
		wait.until(ExpectedConditions.elementToBeClickable(e));
		return e;
	}
	
	public static void PageLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(PAGELOADTIMEOUT, TimeUnit.SECONDS);
	}
	
	public boolean FluentWait(WebElement element){
		return new FluentWait<WebElement>(element)
				.withTimeout(FLUENTTIMEOUT, TimeUnit.SECONDS)
				.pollingEvery(verificationTime, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.until(new Function<WebElement, Boolean>(){
					@Override
					public Boolean apply(WebElement d){
						return d.isDisplayed();
					}
				});
	}	
}