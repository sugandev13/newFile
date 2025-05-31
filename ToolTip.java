package advancedPrograms;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolTip {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver t;
		System.setProperty("webdriver.chrome.driver","D:\\New\\\\Lenova\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
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
		
		WebElement toolTip = t.findElement(By.xpath("//*[@type='button'][@title='Add New Quotation']"));
		
		String toolTip1 = toolTip.getAttribute("title");
		System.out.println(toolTip1);
		
		String window1 = t.getWindowHandle();
		System.out.println(window1);
		Thread.sleep(3000);
		
		((JavascriptExecutor)t).executeScript("window.open()");  // or driver.switchto().newWindow(windowType.TAB);
		ArrayList<String> tab2 = new ArrayList<String>(t.getWindowHandles());
		t.switchTo().window(tab2.get(1));
		t.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		Set <String>window2 = t.getWindowHandles();
		
		for (String focusOnWindow2 : window2) {
			t.switchTo().window(focusOnWindow2);
		}
		
		WebElement userName = t.findElement(By.xpath("//input[@name='username']"));
		userName.sendKeys("Admin");
		
		WebElement passWord = t.findElement(By.xpath("//input[@name='password']"));
		passWord.sendKeys("admin123");
		Thread.sleep(1000);
		
		t.findElement(By.xpath("//*[@type='submit']")).click();
		Thread.sleep(3000);
		
		String title = t.getTitle();
		System.out.println("The Page Title is "+title);
		
		t.switchTo().window(window1);
		Thread.sleep(1000);
		
		t.findElement(By.xpath("//button[@title='Add New Quotation']")).click();
		Thread.sleep(1000);
		
		String url = t.getCurrentUrl();
		System.out.println("The URL is = "+url);
		
		

	}

}
