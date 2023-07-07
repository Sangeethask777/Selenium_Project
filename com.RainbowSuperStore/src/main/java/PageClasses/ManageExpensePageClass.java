package PageClasses;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.ExplicitWait;
import utilities.FileUploadRobotClass;
import utilities.GeneralUtilities;

public class ManageExpensePageClass {

	WebDriver driver;
	ExplicitWait ew=new ExplicitWait();
	GeneralUtilities gl = new GeneralUtilities();
	FileUploadRobotClass f = new FileUploadRobotClass();

	public ManageExpensePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='List Expense']")
	WebElement manageExpenseTitle;

	@FindBy(xpath = "//*[@class='btn btn-rounded btn-danger']")
	WebElement newTab;

	@FindBy(id = "user_id")
	WebElement userField;

	@FindBy(id = "ex_cat")
	WebElement categoryField;

	@FindBy(id = "order_id")
	WebElement orderId;

	@FindBy(id = "purchase_id")
	WebElement purchaseId;

	@FindBy(name="ex_type")
	WebElement expenseType;
	
	

	@FindBy(id="amount")
	WebElement amount;

	@FindBy(xpath = "(//*[@class='form-control'])[3]")
	WebElement remarkstab;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement uploadFile;

	@FindBy(xpath = "//*[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//*[@class='alert alert-success alert-dismissible']")
	WebElement successfulAlertMessage;

	@FindBy(xpath = " //*[text()=' Search']")
	WebElement searchTab;

	@FindBy(xpath = "(//*[@class='form-control selectpicker'])[1]")
	WebElement usersTab;

	@FindBy(xpath = "(//*[@class='form-control'])[1]")
	WebElement titleTab;

	@FindBy(xpath = "//*[@class='btn btn-danger btn-fix']")
	WebElement submitSearch;

	@FindBy(xpath = "//tbody//tr[1]//td[1]")
	WebElement searchResult;

	public String getTextofManageExpenseTitle() {
		ew.presenceOfElementlocatedWait(driver,"//h1[text()='List Expense']");
		
		return gl.getTextOfElement(manageExpenseTitle);
	}

	public void clickonNewTab() {
		gl.clickElement(newTab);
	}

	public void selectValueinUserField(int index) {
		gl.selectByIndex(userField, index);
	}

	public void selectValueinCategoryField(String value) {
		gl.selectByVisibleText(categoryField, value);
	}

	public void selectValueinOrderId(int index) {
		gl.selectByIndex(orderId, index);
	}

	public void selectValueinPurchaseId(String value) {
		gl.selectByVisibleText(purchaseId, value);
	}

	public void selectTheValueOfExpenseType(int value)
	{
	gl.selectByIndex(expenseType, value);
	}

	public void typeElementOnAmountTextBox(String value)
	{
	gl.typeElement(amount,value);
	}

	public void sendKeysofRemarksTab(String value) {
		gl.clickElement(remarkstab, value);
	}

	public void uploadingOfFile(String value) {
		gl.fileUploading(uploadFile, value);
	}

	public void submitonSaveButton() {
		gl.SubmitElement(saveButton);
	}

	//public String getTextOfSuccessfullyMessage()
	//{
	//return gl.getTextOfElement(successfulAlertMessage);
	//}
	
	public boolean isSuccessfullAlertMessageDisplayed()
	{
		return gl.isDisplayedmethod(successfulAlertMessage);
		
	}

	public void clickonSearchTab() {
		gl.clickElement(searchTab);
	}

	public void searchInUsersTab(int index) {
		gl.selectByIndex(usersTab, index);
	}

	public void searchInTitleTab(String value) {
		gl.clickElement(titleTab, value);
	}

	public void submitonSearch() {
		gl.SubmitElement(submitSearch);
	}

	public boolean isSearchResultDisplayed() {
		return gl.isDisplayedmethod(searchResult);
	}

	public void sampleFileUpload() throws AWTException {
		gl.clickElementJs(uploadFile, driver);
		f.fileUpload();
	}
	
	public String readExpense(int row, int col) throws IOException
	{
		return ExcelRead.getStringdata(row,col);
		
	}
	public String readIntValue(int row, int col) throws IOException
	{
		return ExcelRead.getIntegerdata(row, col);
		
	}

	
	
	

}