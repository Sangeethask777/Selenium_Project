package executePageClasses;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.ExpenseCategoryPageClass;
import PageClasses.HomePageClass;
import PageClasses.LoginPageClass;
import PageClasses.ManageExpensePageClass;
import retryAnalyzer.RetryAnalyzer;

public class ManageExpensePageTestClass extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	ManageExpensePageClass lep ;
	ExpenseCategoryPageClass ep;
	
  @Test(priority = 2,groups = {"group1"})
  public void verifyManageExpensePageIsDisplayedOrNot() 
  {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  lep=new ManageExpensePageClass(driver);
	  	  
	  lp.Login("admin", "admin");
	  hp.clickOnManageExpense();
	  hp.clickonExpenseManage();
	  String actual=lep.getTextofManageExpenseTitle();
	  String expect="List Expense";
	  Assert.assertEquals(actual, expect);
  }
  
  @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"create"})
  public void verifyToCreateNewManageExpense() throws AWTException, IOException 
  {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  lep=new ManageExpensePageClass(driver);
	  
	  lp.Login("admin", "admin");
	  hp.clickOnManageExpense();
	  hp.clickonExpenseManage();
	  lep.clickonNewTab();
	  lep.selectValueinUserField(3);
	  lep.selectValueinCategoryField("newitem");
	  lep.selectValueinOrderId(6);
	  lep.selectValueinPurchaseId("14");
	  lep.selectTheValueOfExpenseType(2);
	  //lep.sendKeysofAmount(lep.readIntValue(1, 3));
	  lep.typeElementOnAmountTextBox("100");
	  //lep.sendKeysofRemarksTab(lep.readExpense(0, 0));
	  //lep.uploadingOfFile("\"C:\\Users\\sange\\Downloads\\Assignment9.docx\"");
	  //lep.sampleFileUpload();
	  lep.submitonSaveButton();
	  boolean expected=lep.isSuccessfullAlertMessageDisplayed();
	  Assert.assertTrue(expected);
	 // String actual=lep.getTextOfSuccessfullyMessage();
		//String expected = "×\n"
			//	+ "Alert!\n"
				//+ "Expense Record Created Successfully";
		//Assert.assertEquals(actual, expected);
  
  }
  
  @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"search"})
  public void verifyToSearchCreatedManageExpense() throws IOException 
  {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  lep=new ManageExpensePageClass(driver);
	  
	  lp.Login("admin", "admin");
	  hp.clickOnManageExpense();
	  hp.clickonExpenseManage();
	  lep.clickonSearchTab();
	  lep.searchInUsersTab(3);
	  lep.searchInTitleTab(lep.readExpense(1, 0));
	  lep.submitonSearch();
	  boolean actualresult=lep.isSearchResultDisplayed();
	  Assert.assertTrue(actualresult);
  
  }
  
  @Test (priority = 3,groups = {"delete"})
  public void verifyToDeleteCreatedExpenseinExpensecategoryPage() throws IOException
  {
	  lp=new LoginPageClass(driver);
	  hp=new HomePageClass(driver);
	  ep=new ExpenseCategoryPageClass(driver);
	  
	  lp.Login("admin", "admin");
	  hp.clickOnManageExpense();
	  hp.clickonExpenseCategory();
	  ep.clickOnSearch();
	  //ep.sendKeystoTitleOfSearchElement(ep.readExpense(0, 1));
	  ep.clickOnSearchButton();
	  ep.clickOnDelete();
	  ep.acceptAlertMessageDisplayed();
	  boolean actualRes=ep.isDeleteAlertMessageConfirmationDisplayed();
	  Assert.assertTrue(actualRes);
  } 
  
}


