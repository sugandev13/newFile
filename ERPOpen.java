package advancedPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ERPOpen {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver a;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		a = new ChromeDriver();
		
		a.get("https://erp1.cal4care.com:4002/#/");
		a.manage().window().maximize();
		
		WebElement loginTab = a.findElement(By.id("Login-tab"));
		loginTab.click();
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
		WebElement userName = a.findElement(By.xpath("//input[@placeholder='Username']"));
		userName.sendKeys("dev");
		
		WebElement passWord = a.findElement(By.xpath("//input[@placeholder='Password']"));
		passWord.sendKeys("welcome");
		passWord.sendKeys(Keys.RETURN);
		a.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		
		WebElement otpButton = a.findElement(By.xpath("//input[@formcontrolname='verify_otp_ctrl']"));
		otpButton.sendKeys("654987");
		
		WebElement button = a.findElement(By.id("send_otp_id"));
		button.click();
		Thread.sleep(2000);

	}

}
