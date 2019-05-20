import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "c:\\work\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		
		System.out.println("The tile of the Website"+ driver.getTitle());
		//hrefIncAdt
		//driver.findElement(By.id("divpaxinfo")).click();
		Select obj = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		obj.selectByValue("AED");
		
		//driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		for(int i=1;i<5;i++) {
			Thread.sleep(2000L);
			driver.findElement(By.id("hrefIncAdt")).click();

		}
		//driver.findElement(By.id("divpaxOptions")).click();
		
		driver.findElement(By.cssSelector("#divpaxOptions")).click();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		System.out.println(driver.findElement(By.cssSelector("input#ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		//Bengaluru (BLR)
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		
		Thread.sleep(2000L);
		////div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']
		//li[@class='city_selected'] //a[@value='Delhi (DEL)']
		  driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();
		 
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//div[id='ui-datepicker-div']
		//div[class='ui-datepicker-group ui-datepicker-group-first']
		//data-handler="selectDay"
		//data-handler="selectDay"
		//div[class='ui-datepicker-group ui-datepicker-group-first'] div[class='ui-datepicker-title']
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		System.out.println(driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText());
		
		while(!driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("November"))
		{
			System.out.println("inside while");
			System.out.println(driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText());
			if(driver.findElement(By.cssSelector("[class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("November"))
			{
				
				System.out.println("Inside if");
				//driver.findElement(By.cssSelector("[class='ui-datepicker-next ui-corner-all'] span[class='ui-icon ui-icon-circle-triangle-e']")).click();
				break;
			}
			driver.findElement(By.cssSelector("a[class='ui-datepicker-next ui-corner-all'] span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		//[class='ui-datepicker-group ui-datepicker-group-first'] [data-handler='selectDay']
		List <WebElement> dates= driver.findElements(By.cssSelector("[data-handler='selectDay']"));
		int count = driver.findElements(By.cssSelector("[data-handler='selectDay']")).size();
		for(int i=0;i<count;i++)
		{
			//td[data-handler='selectDay'] a[class='ui-state-default']
			String text=driver.findElement(By.cssSelector("td[data-handler='selectDay'] a[class='ui-state-default']")).getText();
			if(text.equals("30")) {
				driver.findElement(By.cssSelector("td[data-handler='selectDay'] a[class='ui-state-default']")).click();
				break;
		}
		}
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		//driver.findElement(By.xpath("//span[@class='trip-modify-btn']")).click();
		WebDriverWait d = new WebDriverWait(driver, 20);
		
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='trip-modify-btn']")));
		driver.findElement(By.xpath("//span[@class='trip-modify-btn']")).click();
	}

}
