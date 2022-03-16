package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class simpleAppiumTest {

	static AndroidDriver<MobileElement> driver;
	//	AppiumDriver driver;
	//	WebDriver driver;


	@BeforeTest

	public void setuptest() throws MalformedURLException, InterruptedException, Exception 
	{


		// Create object of DesiredCapabilities class                             

		DesiredCapabilities capabilities = new DesiredCapabilities();



		// Optional

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");


		// Specify the device name (any name)

		capabilities.setCapability("deviceName", "My New Phone");

		// Specify the connected device ID

		capabilities.setCapability("udid", "192.168.154.101:5555");


		// Platform version

		capabilities.setCapability("platformVersion", "10.0");


		// platform name

		capabilities.setCapability("platformName", "Android");


		// specify the application package that we copied from appium                

		capabilities.setCapability("appPackage", "io.selendroid.testapp");


		// specify the application activity that we copied from appium                   

		capabilities.setCapability("appActivity", ".HomeScreenActivity");


		// Start android driver I used 4727 port by default it will be 4723

		//driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url, capabilities);

		// Specify the implicit wait of 5 second

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void closepopups() throws InterruptedException {

		// click on continue button  

		MobileElement conbutton = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		conbutton.click();

		// click on alertok button  

		MobileElement alertokbutton = driver.findElement(By.id("android:id/button1"));
		alertokbutton.click();
		
	}
	
	@Test(priority = 1)
	public void performactionsonapp() throws InterruptedException {

		// Enter the text in textbox

		MobileElement textbox = driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']"));
		textbox.sendKeys("Shahid Nadeem Khan");


		// click on registration button  

		MobileElement regbutton = driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration"));
		regbutton.click();



		// Wait for 10 second

		Thread.sleep(10000);

	}
	
	@AfterTest
	
	public void teardowntest() {

		// close the application
		driver.close();
		driver.quit();
	}
}