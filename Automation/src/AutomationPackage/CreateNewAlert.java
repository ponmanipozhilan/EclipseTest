package AutomationPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreateNewAlert {

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://atqa.testqa-lcbs.honeywell.com");
		
		driver.findElement(By.id("cred_userid_inputtext")).sendKeys("JSmith1@atqa.lcbsconnect.com");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_password_inputtext")).sendKeys("lcbs@123");
		Thread.sleep(2000);
		driver.findElement(By.id("cred_sign_in_button")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id='main-nav']/ul/li[2]/a")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='main-content']/ul/li/div[1]/a/article/span[contains(text(), 'Shinola South store')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='alert-config-nav']/a[3]")).click();
		Thread.sleep(5000);

		int i;
		
		for(i=4; i<=4; i++){
		
		driver.findElement(By.xpath("//*[@id='alert-settings-sort']/a")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[1]/div/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[1]/div/ul/li/a[contains(text(), 'RTU_101')]")).click();

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[2]/div/a")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[2]/div/ul/li/a[contains(text(), 'Digital')]")).click();


		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[3]/input")).sendKeys("ponmani" + i);


		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[4]/div/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[4]/div/ul/li/a[contains(text(), 'High')]")).click();


		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[5]/div/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[5]/div/ul/li/a[contains(text(), 'Dirty Filter')]")).click();

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[6]/input")).clear();
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[6]/input")).sendKeys("2");

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[7]/div/div")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[7]/div/ul/li/a[contains(text(), '0-Normally Closed')]")).click();
		
		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/div[10]/textarea")).sendKeys("ponmani" + i);
		

		driver.findElement(By.xpath("//*[@id='add-alert-container']/section/section/button")).click();
		
		Thread.sleep(10000);
			
		}
		
		
		System.out.println("Process Finished successfully in master2");
		
	}

}
