package advancedPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d;
		System.setProperty("webdriver.chrome.driver","D:\\New\\\\Lenova\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		d = new ChromeDriver();
		
		d.get("https://www.leafground.com/drag.xhtml;jsessionid=node041tuq67jg2zr1xl9juv2i5i7n262.node0");
		d.manage().window().maximize();
		Thread.sleep(2000);

		
		WebElement from = d.findElement(By.id("form:drag_content"));
		WebElement to   = d.findElement(By.id("form:drop_header"));
		
		Actions actions = new Actions(d);
		//1st method
		actions.clickAndHold(from).moveToElement(to).release(to).build().perform();
		
		
		// 2nd method
		//actions.dragAndDrop(from, to).build().perform();
		
		System.out.println("Drag And Drop Is Completed");
		

	}

}
