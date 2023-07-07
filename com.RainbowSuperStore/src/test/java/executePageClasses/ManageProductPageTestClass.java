package executePageClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.HomePageClass;
import PageClasses.LoginPageClass;
import PageClasses.ManageProductPageClass;
import retryAnalyzer.RetryAnalyzer;

public class ManageProductPageTestClass extends BaseClass {
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageProductPageClass mpp;
	
	
	
  @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"search"})
  public void verifyToSearchAProductInManageProductPage() 
  {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  mpp=new ManageProductPageClass(driver);
	  	  
	  lp.Login("admin", "admin");
	  hp.clickonManageProduct();
	  mpp.clickOnSearchCategory();
	  mpp.typeProductCodeOnTextBox("1185");
	  mpp.clickOnSearchButton();
	  String actual=mpp.getTextOfSearchProduct();
		String expected = "P1185";
		Assert.assertEquals(actual, expected);
	  
  }
  
   
  
}


