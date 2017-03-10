package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Bases.BasePage;

public class SearchVideoPage extends BasePage{
	@FindBy(xpath=".//*[@id='yt-masthead-content']/form/div/input")
	private WebElement searchBox;
	
	@FindBy(xpath=".//*[@id='yt-masthead-content']/form/button")
	private WebElement searchButton;
	
	public SearchVideoPage(WebDriver driver){
		super(driver);
	}
	
	public void searchVideo(String video){
		setText(searchBox, video);
		OnClick(searchButton);
	}
}
