import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	
	public static void main(String[] str) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "c:\\work\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com");
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByVisibleText("AED");
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		
		for(int i=1;i<5;i++) {
			Thread.sleep(2000L);
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("divpaxOptions")).click();
		
		
		
		
	}

}
