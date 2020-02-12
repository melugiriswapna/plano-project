package dashboard;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class DashboardTesting {
	
	@Test
	public void userAddingDiposit() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("techfiosdemo@gmail.com");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'assword') and contains(@class,'form-')]")).sendKeys("abc123");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')  and @name='login']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(), 'Add Deposit')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='account']/option[@value='housedownpayment']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("bike");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(5000);
		//System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'chase')]")).getText());
		String expectedText = "bike";
		String actualText = driver.findElement(By.xpath("//a[contains(text(), 'bike')]")).getText();
		Assert.assertEquals(expectedText, actualText);
		
		driver.close();
		driver.quit();
		
	}
	

}
