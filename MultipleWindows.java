package advancedPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver a;
		System.setProperty("webdriver.chrome.driver","D:\\New\\\\Lenova\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		a = new ChromeDriver();
		
		a.get("https://www.leafground.com/window.xhtml");
		a.manage().window().maximize();
		Thread.sleep(2000);
		
		String window1 = a.getWindowHandle();
		System.out.println("window1 = "+window1);
		
		WebElement n1 = a.findElement(By.id("j_idt88:new"));
		n1.click();
		
		// focus on new window
		Set<String>newWindow = a.getWindowHandles();
		
		for (String newWindow2 : newWindow) {
			a.switchTo().window(newWindow2);
		}
		
		a.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		Thread.sleep(2000);
		
		a.switchTo().window(window1);
		
		a.findElement(By.xpath("//*[contains(text(),'Close Windows')]")).click();
		
		int noOfWindows = a.getWindowHandles().size();
		System.out.println("No of Windows = "+noOfWindows);
		
		// closed child windows
		Set <String>windowsNew = a.getWindowHandles();
		
		for (String childWindows : windowsNew) {
			if(!childWindows.equals(window1)) {
				a.switchTo().window(childWindows);
				a.close();
			}
		}

	}

}
