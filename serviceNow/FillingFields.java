package serviceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class FillingFields {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://dev107614.service-now.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Rajinaocas_123");
		driver.findElement(By.id("sysverb_login")).click();
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='d6e462a5c3533010cbd77096e940dd8c']").click();
		shadow.setImplicitWait(10);

		shadow.findElementByXPath("//input[@id='filter']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.setImplicitWait(20);
	
		shadow.findElementByXPath("//mark[text()='Knowledge']").click();
		Thread.sleep(2000);
		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//span[@class='btn-icon icon-article-document homepage-icon']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys("IT");
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("New Test Article");
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[2]")).click();
		
		driver.findElement(By.xpath("(//div[@class='list-item arrow'])[4]/span")).click();
		driver.findElement(By.xpath("//span[text()='Java']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary category-ok-btn']")).click();
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(3000);
		driver.close();


	}

}
