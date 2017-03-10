package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Bases.BasePage;

public class VideoLikePage extends BasePage {
		
	@FindBy(xpath=".//*[@id='watch8-sentiment-actions']/span/span[1]")
	WebElement likeButton;
	
	public VideoLikePage(WebDriver driver){
		super(driver);
	}
	
	public void GiveLikeToVideo(){
		
		OnClick(likeButton);
	}
}
