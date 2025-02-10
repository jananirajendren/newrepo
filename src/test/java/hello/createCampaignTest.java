package hello;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ObjectRepository1.Homepage;
import ObjectRepository1.campaign.campaignLookUP;
import ObjectRepository1.campaign.campiagnCreationPage;
import ObjectRepository1.campaign.validateCampaignPage;
import ObjectRepository1.campaign.windowSwitching;
import Utility.BaseClass;
import Utility.Excel_Utility;
import Utility.File_Utility;
import Utility.Java_Utility;
import Utility.WebDriver_Utility;

public class createCampaignTest extends BaseClass{
	
	@Test(groups={"smokeTest","regressionTest"})
	public  void createCampaignTest() throws Throwable{
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
//		String BROWSER = flib.getKeyAndValuePair("browser");
//		String URL = flib.getKeyAndValuePair("url");
//		String USERNAME = flib.getKeyAndValuePair("username");
//		String PASSWORD = flib.getKeyAndValuePair("password");
			
			
//				WebDriver driver;
//				if (BROWSER.contains("Chrome")) {
//					driver = new ChromeDriver();
//				}
//				else if(BROWSER.contains("Firefox")) {
//					driver = new FirefoxDriver();
//				}
//				else {
//					driver = new EdgeDriver();
//				}
//
//				
//				driver.get(URL);
//				//implemented using getter methods
//				 Loginpage login = new Loginpage(driver);
//				 login.getUserTextField().sendKeys(USERNAME);
//				 login.getPasswordTextField().sendKeys(PASSWORD);
//				 login.getLoginButton().click();
				
				
				//Businesslogics
//				Loginpage login = new Loginpage(driver);
//				login.loginToApp(USERNAME, PASSWORD);
				
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				WebDriver_Utility wlib = new WebDriver_Utility();
//				wlib.WaitForpageToLoad(driver);
//				wlib.maximize(driver);
				
				Homepage homepage = new Homepage(driver);
				homepage.morebutton();
				homepage.camplink();
				
				campaignLookUP lookupimg = new campaignLookUP(driver);
				lookupimg.campLookUp();
				
				Java_Utility jlib = new Java_Utility();
				int rannum=jlib.getRandomNum();
				
				Excel_Utility elib = new Excel_Utility();
				String campName = elib.getExcelData("Sheet1", 0, 0) + rannum;
				
			campiagnCreationPage page = new campiagnCreationPage(driver);
		       page.campaignTextFiled(campName);
		       page.plusLookupButton();
		       
		      String prdName = elib.getExcelData("Sheet1", 8, 0);
		       wlib.windowSwitching(driver, "Campaigns&action");
		      windowSwitching window = new windowSwitching(driver);
		      window.enterProdName(driver, prdName);
		      window.searchProd();
		      window.dynamicPath(driver, prdName);
		      wlib.windowSwitching1(driver, "Campaigns&action");
		      
		       
				page.saveButton();

				validateCampaignPage validate = new validateCampaignPage(driver);
				 validate.validateCampaignPage(driver, campName);
				
homepage.adminlink();

	}
}
