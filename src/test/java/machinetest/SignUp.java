package machinetest;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignUp {
	public static WebDriver driver;

	@Parameters({ "Name", "Mobile", "Email","Password","ConfirmPassword" })
	@Test(priority = 0)
	public void signup(String name, String mobile, String email, String password,String confirm_password) throws InterruptedException {
		// Creating the object of ChromeDriver for opening the chrome browser
		driver = new ChromeDriver();
		// Maximising the window
		driver.manage().window().maximize();
		// Providing waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testffc.nimapinfotech.com/");
		// Finding the signup button using findElement and clicking on it
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		// Entering all the details in the sign up page by finding all the textfields
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Mobile No']")).sendKeys(mobile);
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(email);
		/*
		 * Creating the object of scanner class to take the input from the user manually
		 * of the captcha because it can't be automated
		 */
		Scanner sc = new Scanner(System.in);
		// Entering the value of captcha in the console
		System.out.print("ENTER THE CAPTCHA : ");
		String captcha = sc.next();
		System.out.println();
		// Finding the captcha textfield to the manual data
		driver.findElement(By.xpath("//input[@formcontrolname='captchaValue']")).sendKeys(captcha);
		Thread.sleep(2000);
		//clicking on submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.err.print("Enter the OTP : ");
		String otp = sc.next();
		driver.findElement(By.xpath("//input[@formcontrolname='otp']")).sendKeys(otp);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[placeholder='Confirm Password']")).sendKeys(confirm_password);
		driver.findElement(By.id("kt_login_signin_submit")).click();
		sc.close();
		
//		driver.quit();
	}
}
