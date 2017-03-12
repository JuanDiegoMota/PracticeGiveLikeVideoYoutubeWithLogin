package Pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Bases.BasePage;
import Utils.Wait;


public class ResultsVideoPage extends BasePage{
	
	@FindBy(xpath=".//*[@id='results']/ol/li/ol/li/div/div/div[2]/h3/a")
	List<WebElement> list;
	
	public ResultsVideoPage(WebDriver driver){
		super(driver);
	}
		

	public void selectVideo(String nameVideo){
		Wait.PageLoad(driver);
		System.out.println("El tamaño es: "+list.size());
		for(WebElement e : list){
			System.out.println("El elemento es: "+e.getText());
			if(e.getText().equalsIgnoreCase(nameVideo)){
				System.out.println("Lo encontre");
				OnClick(e);
				break;
			}
			System.out.println("No lo encuentro");
		}
	}
		
}
