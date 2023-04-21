package serviceNow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) {
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
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='d6e462a5c3533010cbd77096e940dd8c']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog");
		 shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();

		shadow.setImplicitWait(10);
		WebElement frameelement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameelement);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles') ]  ")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("//label[text()='No']")).click();
		
		WebElement datallowance = driver.findElement(By.xpath("//select[@id='IO:33494b069747011021983d1e6253af45']"));
        Select drop=new Select(datallowance);
        drop.selectByIndex(1);
        driver.findElement(By.xpath("//label[text()='Starlight']")).click();
        
        driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
        
        String text2 = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		System.out.println(text2);
		String text = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number is:" + text);
	}

}
