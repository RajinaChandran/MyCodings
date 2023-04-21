package serviceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class NewProposal {

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
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposal");
		shadow.setImplicitWait(20);
	
		shadow.findElementByXPath("//mark[@class='filter-match']").click();
		Thread.sleep(2000);
		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Request for Help");
		
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();

		String proposal = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println("Proposal Number is:" + proposal);

		driver.close();

	}


	

}
