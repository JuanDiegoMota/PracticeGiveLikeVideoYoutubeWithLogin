package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Bases.BaseTest;
import Pages.LoginPage;
import Pages.PrincipalPage;
import Pages.ResultsVideoPage;
import Pages.SearchVideoPage;
import Pages.VideoLikePage;



public class AppTest extends BaseTest {
	private LoginPage objLogin;
	private PrincipalPage objPrincipal;
	private SearchVideoPage objSearchVideo;
	private ResultsVideoPage objResultVideo;
	private VideoLikePage objLikePage;
	
	@Parameters({"nameBrowser"})
	public AppTest(String nameBrowser){
		super(nameBrowser);
		
		objPrincipal = new PrincipalPage(driver);
		objLogin = new LoginPage(driver);
		objSearchVideo = new SearchVideoPage(driver);
		objResultVideo = new ResultsVideoPage(driver);
		objLikePage = new VideoLikePage(driver);
	}
	
	@BeforeTest
	@Parameters({"url"})
	public void navigate(String url){
		driver.get(url);
		Assert.assertEquals("YouTube", driver.getTitle());
	}
	
	@Test
	@Parameters({"email", "password"})
	public void LoginSuccedfull(@Optional("jdmotas@gmail.com") String email, String password){
		objPrincipal.goToInputLogin();
		objLogin.signInLogin(email, password);
		Assert.assertTrue(objLogin.getElement().isDisplayed());
	}

	
	@Test(dependsOnMethods={"LoginSuccedfull"})
	@Parameters({"artistName","soundtrack"})
	public void searchVideo(@Optional("Guns N' Roses") String artistName, @Optional("Guns N' Roses - Paradise City") String soundtrack){
		objSearchVideo.searchVideo(artistName);
		objResultVideo.selectVideo(soundtrack);
		objLikePage.GiveLikeToVideo();
		Assert.assertNotNull(objLikePage);
	}
	
}
