package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	private WebDriverWait wait;
	private static final int EXPLICITTIMEOUT = 15;
	
	public Wait(WebDriver driver){
		wait = new WebDriverWait(driver, EXPLICITTIMEOUT);
	}
	
	public WebElement explicitWait(WebElement e){
		wait.until(ExpectedConditions.elementToBeClickable(e));
		return e;
	}
}
