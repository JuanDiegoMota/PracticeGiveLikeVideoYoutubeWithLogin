package Bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Wait;

public class BasePage {
	protected WebDriver driver;
	Wait myWait;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		myWait = new Wait(driver);
		
		//Inicializador de los WebElements
		PageFactory.initElements(driver, this);
	}
	
	protected void OnClick(WebElement element){
		myWait.explicitWait(element);
		element.click();
	}
	
	protected void setText(WebElement element, String text){
		myWait.explicitWait(element);
		element.sendKeys(text);
	}
}
