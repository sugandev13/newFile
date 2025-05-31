package advancedPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleToolTip {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		WebDriver t;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		t = new ChromeDriver();

		t.get("https://erp1.cal4care.com:4002/#/login");
		t.manage().window().maximize();
		Thread.sleep(3000);

		t.findElement(By.id("Login-tab")).click();
		Thread.sleep(2000);

		t.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("dev");
		t.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("welcome");
		Thread.sleep(2000);
		t.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		t.findElement(By.xpath("//*[@formcontrolname='verify_otp_ctrl']")).sendKeys("654987");
		Thread.sleep(2000);

		t.findElement(By.id("send_otp_id")).click();
		Thread.sleep(5000);

		t.navigate().refresh();
		Thread.sleep(5000);

		WebElement search = t.findElement(By.xpath("//*[@title='Search']"));

		String toolTip = search.getAttribute("title");
		System.out.println("The ToolTip is "+toolTip);
		Thread.sleep(2000);

		String s = t.getWindowHandle();
		System.out.println(s);

		//	t.switchTo().newWindow(WindowType.WINDOW); // it's open the new window
		t.switchTo().newWindow(WindowType.TAB);  // it's open the new tab
		t.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);


		Set <String> window2 = t.getWindowHandles();

		for (String focusWindow2 : window2) {
			t.switchTo().window(focusWindow2);
		}

		WebElement userName =	t.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");

		WebElement passWord = t.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("admin123");

		WebElement submit = t.findElement(By.xpath("//button[@type='submit']"));
		submit.click();

		String pageTitle = t.getTitle();
		System.out.println("The Page Name is "+pageTitle);

		t.switchTo().window(s);
		
		WebElement clickSearch = t.findElement(By.xpath("//*[@title='Search']"));
		clickSearch.click();
		
		String pageTitle2 = t.getTitle();
		System.out.println("The Page Name is "+ pageTitle2);

	}

}
