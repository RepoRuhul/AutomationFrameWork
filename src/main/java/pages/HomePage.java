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
	WebElement userId;
	@FindBy(xpath = "//input[@id='passcode1']")
	WebElement passWordElement;

	public void inputTextInUserIdField() {
		userId.sendKeys("rumaisa"); // value always inside " ", even if you use int type
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertText() {
		inputText(userId, "rumaisaraha");
		inputText(passWordElement, "Rafdarafa12345");

	}

	public void searchFieldElement() throws InterruptedException {
		WebElement passWordElement;
		Thread.sleep(5000);

	}

}
