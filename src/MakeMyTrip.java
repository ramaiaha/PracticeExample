import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "c:\\work\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).clear();
		//driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("ban");
		//driver.findElement(By.id("react-autowhatever-1-section-0-item-0"))
		//react-autosuggest__input.react-autosuggest__input--open
		//react-autosuggest__input react-autosuggest__input--open

	}

}
