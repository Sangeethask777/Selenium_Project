package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class ManageProductPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWait ew=new ExplicitWait();
	FluentWaitClass fw=new FluentWaitClass();
	public ManageProductPageClass(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()=' Search']")
	WebElement  searchCategory;
	
	@FindBy(xpath="//input[@name='cd']")
	WebElement  productCodeTextBox;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement  searchButton;
	
	@FindBy(xpath="//button[text()='P1185']")
	WebElement  searchProduct;
	
	public void clickOnSearchCategory()
		{
		ew.elementToBeClickableWait(driver, searchCategory);

		gl.clickElement(searchCategory);
		}
	public void clickOnSearchButton()
		{
		
		gl.clickElement(searchButton);
		}
	public void typeProductCodeOnTextBox(String title)
		{
		ew.presenceOfElementlocatedWait(driver,"(//*[@class='form-control'])[3]");
		gl.typeElement(productCodeTextBox,title);
		}
	public String getTextOfSearchProduct()
		{
		fw.visibilityOfWait( searchProduct,driver);
		return gl.getTextOfElement(searchProduct);
		}
}
