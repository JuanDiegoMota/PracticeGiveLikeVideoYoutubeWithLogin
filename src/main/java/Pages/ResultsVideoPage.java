package Pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Bases.BasePage;

public class ResultsVideoPage extends BasePage{
	
	@FindBy(xpath=".//*[@id='results']/ol/li[2]/ol/li[5]/div/div/div[2]/h3/a")
	WebElement video;
	
	public ResultsVideoPage(WebDriver driver){
		super(driver);
	}
	
	public void selectVideo(){
		OnClick(video);
	}
	
	/*

	public void foundVideo(String nameVideo){
	
		for(WebElement e : list){
			System.out.println("El elemento es: "+e.getText());
			if(e.getText().equalsIgnoreCase(nameVideo)){
				System.out.println("Lo encontre");
				OnClick(e);
				break;
			}
			System.out.println("No lo encuentro");
		}
	} */
		
}
