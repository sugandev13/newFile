package advancedPrograms;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AllInOne {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver a;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver\\chromedriver.exe");
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
		//a.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		a.navigate().refresh();
		Thread.sleep(5000); 
		
		WebElement toolTip = a.findElement(By.xpath("//button[@title='Add New Quotation']"));
		
		String name = toolTip.getAttribute("title");
		System.out.println("The ToolTip is "+ name);
		
		String window1 = a.getWindowHandle();
		System.out.println(window1);
		
		a.switchTo().newWindow(WindowType.TAB);
		a.get("https://www.leafground.com/drag.xhtml;jsessionid=node0optobdpd62kqu33ui82rc2p2207116.node0");
		Thread.sleep(2000);
		
		Set <String> window2 = a.getWindowHandles();
		
		for (String focusOnWindow2 : window2) {
			a.switchTo().window(focusOnWindow2);
			Thread.sleep(2000);
		}
		
		WebElement dragElement = a.findElement(By.id("form:drag"));
		WebElement dropTo = a.findElement(By.id("form:drop_content"));
		
		Actions actions = new Actions(a);
		actions.clickAndHold(dragElement).moveToElement(dropTo).release(dropTo).build().perform();
		System.out.println("Drag and Drop is Completed");
		Thread.sleep(2000);
		
		a.switchTo().newWindow(WindowType.TAB);
		a.get("https://www.leafground.com/file.xhtml;jsessionid=node0optobdpd62kqu33ui82rc2p2207116.node0");
		Thread.sleep(3000);
		
		Set <String> window3 = a.getWindowHandles();
		
		for (String focusOnWindow3 : window3) {
			a.switchTo().window(focusOnWindow3);
			Thread.sleep(2000);
		}
		
		WebElement downLoadButton = a.findElement(By.id("j_idt93:j_idt95"));
		downLoadButton.click();
		
		File file = new File("C:\\Users\\kk\\Downloads");
		
		File[] totalFiles1 = file.listFiles();
		
		for (File file2 : totalFiles1) {
			if(file2.getName().equals("TestLeaf Logo.png")) {
				System.out.println("File Name is Matched");
				break;
			}
		}
		
	}

}
