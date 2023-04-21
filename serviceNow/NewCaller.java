package serviceNow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class NewCaller {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://dev107614.service-now.com");
		Cookie cookie = new Cookie("name", "value");
        driver.manage().addCookie(cookie);

        // Get all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Number of cookies: " + cookies.size());


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
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
		shadow.setImplicitWait(20);
		//shadow.findElementByXPath("//div[text()='All").click();
		shadow.findElementByXPath("//mark[text()='Callers']").click();
		Thread.sleep(2000);
		
		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Rajina");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Chandran");
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Junior Developer");
		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("rajinaocas@gmail.com");
		driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("99");
		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("91");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		shadow.setImplicitWait(10);
		String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Rajina Chandran", Keys.ENTER);
		String text2 = driver.findElement(By.xpath("//td[text()='Rajina']")).getText();

		if (text2.equals("Rajina")) {
			System.out.println("Verified");

		} else {
			System.out.println("Not Verified");
		}

	}




	}


