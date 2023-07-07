package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ExpenseCategoryPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public ExpenseCategoryPageClass(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[text()='Expense Category'])[2]")
	WebElement expenseCategoryHeading;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newTab;
	
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	WebElement title;
	
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchKey;
	
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	WebElement titleOfSearchElement;
	
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement searchButton;
	
	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	WebElement searchResultDisplay;
	
	@FindBy(xpath = "//*[@class='fas fa-trash-alt']")
	WebElement delete;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement deleteAlertMessageConfirmation;
	
	public String getTextofExpenseCategoryHeading()
	{
		return gl.getTextOfElement(expenseCategoryHeading);
	}
	
	public void clickOnNewTab()
	{
		gl.clickElement(newTab);
	}
	
	public void sendKeystoTitleField(String value)
	{
		gl.clickElement(title, value);
	}
	
	public void clickOnSave()
	{
		gl.clickElement(save);
	}

	public boolean isAlertMessageDisplayed()
	{
		return gl.isDisplayedmethod(alertMessage);
	}
	
	public void clickOnSearch()
	{
		gl.clickElement(searchKey);
	}
	
	public void sendKeystoTitleOfSearchElement(String value)
	{
		gl.clickElement(titleOfSearchElement, value);
	}
	
	public void clickOnSearchButton()
	{
		gl.clickElement(searchButton);
	}
	
	public boolean isSearchResultDisplayed()
	{
		return gl.isDisplayedmethod(searchResultDisplay);
	}
	
	public void clickOnDelete()
	{
		gl.clickElement(delete);
	}
	
	public void acceptAlertMessageDisplayed()
	{
		gl.alertAccept(driver);
	}
	
	public boolean isDeleteAlertMessageConfirmationDisplayed()
	{
		return gl.isDisplayedmethod(deleteAlertMessageConfirmation);
	}

	public String readExpense(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

