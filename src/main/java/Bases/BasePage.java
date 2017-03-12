package Bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Wait;

public abstract class BasePage {
	protected WebDriver driver;
	Wait myWait;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		myWait = new Wait(driver);
		
		//Inicializador de los WebElements
		PageFactory.initElements(driver, this);
	}
	
	protected void OnClick(WebElement element){
		myWait.FluentWait(element);
		element.click();
	}
	
	protected void setText(WebElement element, String text){
		myWait.FluentWait(element);
		element.sendKeys(text);
	}
}
