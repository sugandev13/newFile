package advancedPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class April {

	public static void main(String[] args) throws InterruptedException {
		WebDriver a;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		a = new ChromeDriver();

		a.get("https://www.leafground.com/file.xhtml;jsessionid=node0xtombh8r58dlkq98whnbso0g184114.node0");
		a.manage().window().maximize();
		Thread.sleep(2000);

		String window1 = a.getWindowHandle();
		System.out.println(window1);

		a.switchTo().newWindow(WindowType.TAB);
		a.get("https://erp1.cal4care.com:4002/#/login");
		Thread.sleep(2000);
		
		Set <String> window2 = a.getWindowHandles();
		
		for (String focusOnWindow2 : window2) {
			a.switchTo().window(focusOnWindow2);
			System.out.println("Second Window");
		}

		String PageName = a.getTitle();
		System.out.println(PageName);
		
		a.findElement(By.id("Login-tab")).click();
		Thread.sleep(2000);

		a.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("dev");
		a.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("welcome");
		Thread.sleep(2000);
		a.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		a.findElement(By.xpath("//*[@formcontrolname='verify_otp_ctrl']")).sendKeys("654987");
		Thread.sleep(2000);

		a.findElement(By.id("send_otp_id")).click();
		Thread.sleep(5000);
		

		String PageName1 = a.getTitle();
		System.out.println(PageName1);
	}

}
