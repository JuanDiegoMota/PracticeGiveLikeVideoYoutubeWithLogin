package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import Bases.BasePage;

public class LoginPage extends BasePage{
		
	@FindBy(id="Email")
	private WebElement boxEmail;
	
	@FindBy(id="next")
	private WebElement nextButton;
	
	@FindBy(id="Passwd")
	private WebElement boxPass;
	
	@FindBy(id="signIn")
	private WebElement signInButton;
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	public void inputEmail(String email){
		setText(boxEmail, email);
		OnClick(nextButton);
	}
	
	public void inputPass(String pass){
		setText(boxPass, pass);
		OnClick(signInButton);
	}
	
	public void signInLogin(String email, String pass){
		inputEmail(email);
		inputPass(pass);
	}
	
	public WebElement getElement(){
		return signInButton;
	}
	
	
}
