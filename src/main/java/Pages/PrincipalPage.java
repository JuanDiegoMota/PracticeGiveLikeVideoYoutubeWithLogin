package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Bases.BasePage;

public class PrincipalPage extends BasePage {
	@FindBy(xpath=".//*[@id='yt-masthead']/div[2]/div/button")
	private WebElement signInButton;
	
	public PrincipalPage(WebDriver driver){
		super(driver);
	}
	
	
	public void goToInputLogin(){
		OnClick(signInButton);
	}
}
