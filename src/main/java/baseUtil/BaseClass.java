package baseUtil;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import utils.Configuration;
import static utils.IConstant.*;
public class BaseClass {
	public WebDriver driver; // or we can use protected type
	public HomePage homePage; // or we can use protected type
	Configuration configuration;
	@BeforeMethod
	public void setUP() {
		configuration=new Configuration();//default constructor of configuration class will be initialized
		initDriver();
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProerties(URL));
//		how can we convert a string to long type?
		long pageLoadWait = Long.parseLong(configuration.getProerties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProerties(IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClass();
	}
	public void initDriver() {
	String browserName =	configuration.getProerties(BROWSER);
		
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
			
		case "FIREFOX":
			
			 System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe"); 
			 driver = new FirefoxDriver();
			 
			 break;
			 
		case "EDGE":

			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe"); 
			driver = new EdgeDriver();
			break;

		default:
			 WebDriverManager.chromedriver().setup(); 
			 driver= new ChromeDriver();
			break;

		}
	}

	public void initClass() {
		homePage = new HomePage(driver);
		
	}
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}

}
