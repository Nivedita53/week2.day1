package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// webdriver setup
		
		WebDriverManager.chromedriver().setup();
		//String driverpath = System.getProperty("Webdriver.chrome.driver");
		//System.out.println(driverpath);
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//login
		
		driver.findElement(By.id("username")).sendKeys("DemosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//clicking on CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//clicking on Leads
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Filling the fields using id locator
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nive");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("K");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("abc");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("test");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("test");
		
		//selecting Dropdown options
		
	 WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(source);
		dd.selectByValue("LEAD_CONFERENCE");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stdd=new Select(state);
		stdd.selectByVisibleText("Alabama");
		
		//Submit button
		
		driver.findElement(By.name("submitButton")).click();
		
		//webpage title
		
		System.out.println(driver.getTitle());
		
		//closing the browser
		
		Thread.sleep(1000);
		driver.close();
		
		
		
		

	}

}
