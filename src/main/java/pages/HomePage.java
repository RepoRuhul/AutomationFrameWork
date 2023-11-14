package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import static common.CommonActions.*;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);// can you explain this line please????????
	}

	@FindBy(xpath = "//input[@name='onlineId1']")
	WebElement userIdElement;
	@FindBy(xpath = "//input[@id='passcode1']")
	WebElement passWordElement;

  public void insertText() {
	  inputText(userIdElement, "dfskgd hs");
	  inputText(passWordElement, "jkfdgdskkl");
	  
  }

	public void searchFieldElement() {
		WebElement passWordElement;

		

	}

}
