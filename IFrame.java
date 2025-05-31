package advancedPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriver i;
		System.setProperty("webdriver.chrome.driver","D:\\New\\\\Lenova\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		i = new ChromeDriver();
		
		i.get("https://www.leafground.com/frame.xhtml");
		i.manage().window().maximize();
		Thread.sleep(2000);
		
		
		i.switchTo().frame(0);
		i.findElement(By.id("Click")).click();
		
		String text = i.findElement(By.id("Click")).getText();
		System.out.println("The Text is "+ text);
		
		// return to the old window , which means leave from the frame
		i.switchTo().defaultContent();
		Thread.sleep(2000);
		
		  // Switch to second frame and then inner frame
      //  WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='page.xhtml']")); 
      //  driver.switchTo().frame(frame1);
        
      //  WebElement frame2 = driver.findElement(By.xpath("//iframe[@src='frame2.xhtml']"));
      //  driver.switchTo().frame(frame2);
		
		i.switchTo().frame(1);
		
		WebElement frame2 = i.findElement(By.xpath("//*[@id=\"frame2\"]"));
		i.switchTo().frame(frame2);
		
		
		WebElement button2 = i.findElement(By.xpath("//*[@id=\"Click\"]"));
		button2.click();
		Thread.sleep(2000);
		
		i.switchTo().defaultContent();
		
		List <WebElement> totalFrames = i.findElements(By.tagName("iframe"));
		
		int noOfFrames = totalFrames.size();
		System.out.println("Total No Of Frames = "+noOfFrames);
		

	}

}
