package advancedPrograms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class April28 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver t;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver\\chromedriver.exe");
		t = new ChromeDriver();
		
		t.get("https://erp1.cal4care.com:4002/#/login");
		t.manage().window().maximize();
		Thread.sleep(3000);
		
		WebElement logInTab = t.findElement(By.id("Login-tab"));
		logInTab.click();
		Thread.sleep(3000);
		
		WebElement userName = t.findElement(By.xpath("//*[@formcontrolname='username']"));
		userName.sendKeys("dev");
		
		WebElement passWord = t.findElement(By.xpath("//*[@formcontrolname='password']"));
		passWord.sendKeys("welcome");
		passWord.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		
		WebElement otp = t.findElement(By.xpath("//*[@formcontrolname='verify_otp_ctrl']"));
		otp.sendKeys("654987");
		
		WebElement otpButton = t.findElement(By.id("send_otp_id"));
		otpButton.click();
		Thread.sleep(3000);
		
		t.navigate().refresh();
		Thread.sleep(3000);
		
		String w1 = t.getWindowHandle();
		System.out.println(w1);
		Thread.sleep(3000);
		
		WebElement t1 = t.findElement(By.xpath("//*[@title='Add New Quotation']"));
		Thread.sleep(3000);
		
		String addName = t1.getAttribute("title");
		System.out.println(addName);
		
		String pageTitle = t.getTitle();
		System.out.println(pageTitle);
		Thread.sleep(3000);
		
		t.navigate().refresh();
		Thread.sleep(3000);		
		
		//WebElement firstMenu = t.findElement(By.xpath("//*[@class='sidebar-toggle']"));
		//firstMenu.click();
		
		Actions a = new Actions(t);
		WebElement mainMenu = t.findElement(By.xpath("#/ledger--"));
		a.moveToElement(mainMenu).perform();      
		
		WebElement subMenu = t.findElement(By.xpath("//a[@href='//a[@href='#/transactionnew']"));
		a.moveToElement(subMenu).perform();
		
		/*
		 * WebElement subMenu2 = t.findElement(By.xpath("//a[@href='#/creditnote']"));
		 * a.moveToElement(subMenu2).perform(); subMenu2.click();
		 */

	}

}
