import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver","c:\\work\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mailtoanitha.r@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Gold4me*");
		driver.findElement(By.xpath("//*[@id='u_0_2']")).click();
		//driver.close();
		
	}

}
