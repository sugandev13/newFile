package advancedPrograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class ErpAdvanced {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, AWTException {

		WebDriver e;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver\\chromedriver.exe");
		e = new ChromeDriver();

		e.get("https://erp1.cal4care.com:4002/#/login");
		e.manage().window().maximize();
		e.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement logInTab = e.findElement(By.id("Login-tab"));
		logInTab.click();

		WebElement userName = e.findElement(By.cssSelector("input[formcontrolname='username']"));
		userName.sendKeys("dev");

		WebElement passWord = e.findElement(By.cssSelector("input[formcontrolname='password']"));
		passWord.sendKeys("welcome");
		passWord.sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		WebElement sendOtp = e.findElement(By.cssSelector("input[formcontrolname='verify_otp_ctrl']"));
		sendOtp.sendKeys("654987");

		WebElement logInButton = e.findElement(By.cssSelector("input#send_otp_id"));
		logInButton.click();
		//e.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(2000);

		e.navigate().refresh();
		Thread.sleep(3000);

		String w1 = e.getWindowHandle();
		System.out.println(w1);

		String pageName = e.getTitle();
		System.out.println("PageName is "+pageName);

		WebElement addName = e.findElement(By.xpath("//*[@title='Add New Quotation']"));
		Thread.sleep(1000);

		String toolTip = addName.getAttribute("title");
		System.out.println(toolTip);
		Thread.sleep(2000);

		e.switchTo().newWindow(WindowType.TAB);
		e.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Set <String> w2 = e.getWindowHandles();

		for (String newWindow : w2) {
			e.switchTo().window(newWindow);
			//e.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			Thread.sleep(2000);
		}

		WebElement u2 = e.findElement(By.xpath("//*[@name='username']"));
		u2.sendKeys("Admin");

		WebElement p2 = e.findElement(By.xpath("//*[@name='password']"));
		p2.sendKeys("admin123");

		WebElement submit = e.findElement(By.xpath("//*[@type='submit']"));
		submit.click();

		String Name = e.getTitle();
		System.out.println("The Page Name is "+Name);

		e.switchTo().newWindow(WindowType.TAB);
		e.get("https://www.leafground.com/drag.xhtml;jsessionid=node0ey4ty79esd3hv1oop7icjnok427845.node0");

		Set <String> w3 = e.getWindowHandles();

		for (String w3Focus : w3) {
			e.switchTo().window(w3Focus);
			Thread.sleep(2000);
		}

		WebElement from = e.findElement(By.id("form:drag_content"));
		WebElement to = e.findElement(By.id("form:drop_content"));

		Actions actions = new Actions(e);
		actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
		System.out.println("Drag and Drop is Completed");
		Thread.sleep(2000);

		WebElement module = e.findElement(By.id("menuform:j_idt42"));
		module.click();

		WebElement fileModule = e.findElement(By.id("menuform:m_file"));
		//fileModule.click();

		Actions a = new Actions(e);
		a.contextClick(fileModule).build().perform();

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		Set <String> w4 = e.getWindowHandles();

		for (String w4Focus : w4) {
			e.switchTo().window(w4Focus);
			Thread.sleep(3000);
		}

		WebElement downloadButton = e.findElement(By.id("j_idt93:j_idt95"));
		downloadButton.click();

		File file = new File("C:\\Users\\kk\\Downloads");

		File[] totalFile = file.listFiles();

		for (File file2 : totalFile) {
			file2.getName().equals("TestLeaf Logo.png");
			System.out.println("File Name is Matched");
			break;
		}

		Set<String> noOfWindows = 	e.getWindowHandles();

		int windowCounts = noOfWindows.size();
		System.out.println("No Of Windows = "+ windowCounts);

	}

}
