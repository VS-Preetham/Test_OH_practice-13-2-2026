package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.net.http.WebSocket;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Logger log;
	public Properties prop;
	
	
	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setup(String os, String browser) throws Exception {
	    System.out.println("SETUP STARTED | OS=" + os + " | Browser=" + browser);


		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fis);

		log = LogManager.getLogger(this.getClass());
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			
			else if (os.equalsIgnoreCase("Mac")) {
			capabilities.setPlatform(Platform.MAC);
			}
			
			else if (os.equalsIgnoreCase("Linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			
			else {
				System.out.println("Invalid Operation System");
			return;
			}
			
			switch (browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
				
			case "edge" :
				capabilities.setBrowserName("edge");
				break;
				
			case "firefox" :
				capabilities.setBrowserName("firefox");
				break;

			default:
				System.out.println("No Matching browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		}
		
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch (browser.toLowerCase()) {
			case "chrome":
			    WebDriverManager.chromedriver().setup();
			    driver = new ChromeDriver();
			    break;

			case "edge":
			    WebDriverManager.edgedriver().setup();
			    driver = new EdgeDriver();
			    break;

			case "firefox":
			    WebDriverManager.firefoxdriver().setup();
			    driver = new FirefoxDriver();
			    break;
		}
		

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("URL"));
	}

	@AfterClass
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}


	public String randomNum() {
		String genNumber = RandomStringUtils.randomNumeric(10);
		return genNumber;
	}

	public String randomAlphabet() {
		String genAlphabet = RandomStringUtils.randomAlphabetic(10);
		return genAlphabet;
	}

	public String AlphaNumeric() {
		String genNumber = RandomStringUtils.randomNumeric(5);
		String genAlphabets = RandomStringUtils.randomAlphabetic(5);

		return (genAlphabets + "@" + genNumber);
	}

	public String captureSS(String tname) {
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		File sourceFile = tks.getScreenshotAs(OutputType.FILE);
	String dest = System.getProperty("user.dir")+"//screenshots//"+"_"+timeStamp+".png";
	File destFile = new File(dest);
	sourceFile.renameTo(destFile);
	return dest;
	}

}
