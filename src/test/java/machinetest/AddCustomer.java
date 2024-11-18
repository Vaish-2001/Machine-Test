package machinetest;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class AddCustomer  {
	public static Select sel;

	@Parameters({ "leadname", "refnumber", "contactperson","mobile"})
	@Test(priority = 1)
	public void addCustomer(String lead_name, String ref_number, String contact_person) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// Maximizing the window
		driver.manage().window().maximize();
		// Providing waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Entering into the web site
		driver.get("https://testffc.nimapinfotech.com/");
		// Finding the My customers element in the web page and clicking on it
		driver.findElement(By.xpath("//span[text()='My Customers']")).click();
		// Clicking on the New Customer button
		driver.findElement(By.xpath("//span[text()=' New Customer ']")).click();
		/*
		 * Changing the controller or thread to the popup window for adding a new
		 * customer after clicking on New Customer button..... By using getWindowHandles
		 * method of the WebDriver interface
		 */
		Set<String> handles = driver.getWindowHandles();
		for (String str : handles)
			driver.switchTo().window(str);
		Thread.sleep(2000);
		// Storing the expected parameters
		String expected_leadname = "Saurav";
		String expected_ref_no = "1234567890";
		String expected_contact_person = "Mr Rahul";
		String expected_mobile = "9876543210";
		// Validating the email and password using Assert class
		Assert.assertEquals(expected_leadname, lead_name, "*** Lead Name is IN-VALID ***");
		// Printing the message in the console using Reporter class
		Reporter.log("*** Lead Name is VALID ***", true);
		Assert.assertEquals(expected_ref_no, ref_number, "*** Reference number is IN-VALID ***");
		Reporter.log("*** Reference number is VALID ***", true);
		Assert.assertEquals(expected_contact_person, contact_person, "*** Contact person is IN-VALID ***");
		Reporter.log("*** Contact person is VALID ***", true);
		// Passing the parameters of lead name and reference number from the XML file
		driver.findElement(By.xpath("//input[@formcontrolname='LeadName']")).sendKeys(lead_name);
		driver.findElement(By.xpath("//input[@formcontrolname='RefNo']")).sendKeys(ref_number);
		
//		WebElement ref_by = driver.findElement(By.cssSelector("mat-select[placeholder='Referance By']"));
//		sel = new Select(ref_by);
//		Thread.sleep(2000);
//		sel.selectByVisibleText(" Saurabh Joshi ");

		driver.findElement(By.cssSelector("input[data-placeholder='Contact Person Name']")).sendKeys(contact_person);
		
//__________________________________________________
		WebElement country = driver.findElement(By.xpath("(//mat-select[@formcontrolname='CountryId'])[2]"));
		sel = new Select(country);
		Thread.sleep(2000);
		sel.selectByVisibleText("India");

		WebElement state = driver.findElement(By.xpath("(//mat-select[@formcontrolname='StateId'])[2]"));
		sel = new Select(state);
		Thread.sleep(2000);
		sel.selectByVisibleText("Maharashtra");

		WebElement city = driver.findElement(By.xpath("(//mat-select[@placeholder='City'])[2]"));
		sel = new Select(city);
		Thread.sleep(2000);
		sel.selectByVisibleText("Mumbai");

		WebElement locality = driver.findElement(By.xpath("(//mat-select[@formcontrolname='LocalityId'])[2]"));
		sel = new Select(locality);
		Thread.sleep(2000);
		sel.selectByVisibleText("Mumbai");

		driver.findElement(By.cssSelector("//input[@formcontrolname='PinCode']")).sendKeys("441026");
		driver.quit();
	}
}
