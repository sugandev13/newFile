package advancedPrograms;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadedFile {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver f;
		System.setProperty("webdriver.chrome.driver","D:\\New\\Lenova\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		f = new ChromeDriver();
		
		f.get("https://www.leafground.com/file.xhtml;jsessionid=node0xtombh8r58dlkq98whnbso0g184114.node0");
		f.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement downloadedLink = f.findElement(By.id("j_idt93:j_idt95"));
		downloadedLink.click();
		
		File fileLocation = new File("C:\\Users\\kk\\Downloads");
		
		File[] totalFiles = fileLocation.listFiles();
		
		for (File file : totalFiles) {
			if(file.getName().equals("TestLeaf Logo	.png")) {
				System.out.println("File is Downloaded");
				break;
			} 
		}
		
		f.quit();
		
		//

	}

}
