package AutomationPackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AccessingEmailLink {

	@Test(dataProviderClass = TestData.class, dataProvider = "mailinatorData")
	public static void accessEmail(String emailid, String phno, String firstname,
			String lastname) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.mailinator.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("inboxfield")));

		driver.findElement(By.id("inboxfield")).sendKeys(emailid);

		driver.findElement(
				By.xpath("html/body/section[1]/div/div[3]/div[2]/div[2]/div[1]/span/button"))
				.click();
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='public_maildirdiv']/div/div/div/div[5]/div[contains(text(), 'You have been authorized to use the new temperature control system in your building')]")));

		String handle = driver.getWindowHandle();

		// driver.findElement(By.xpath("//*[@id='row_public_1481895406-100040578409-sit6']/div[2]/div[5]/div")).click();

		driver.findElement(
				By.xpath("//*[@id='public_maildirdiv']/div/div/div/div[5]/div[contains(text(), 'You have been authorized to use the new temperature control system in your building')]"))
				.click();

		Thread.sleep(5000);

		driver.switchTo().frame("publicshowmaildivcontent");

		driver.findElement(
				By.xpath("html/body/table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr/td/a[1]/span[contains(text(), 'GET STARTED')]"))
				.click();

		Thread.sleep(2000);

		Set<String> handle1 = driver.getWindowHandles();

		for (String windowHandle : handle1) {

			if (!windowHandle.equals(handle)) {

				driver.switchTo().window(windowHandle);

				System.out.println("Switched to Child window successfully");

				// driver.findElement(By.xpath("//*[@id='eula-wrapper']/div[2]/label")).click();
				// driver.findElement(By.xpath("//*[@id='eula-wrapper']/div[3]/button")).click();
				Thread.sleep(60000);

				System.out.println("Accepted the invite");

				Thread.sleep(5000);

				driver.switchTo().window(handle);
				System.out.println("Switched to Parent window successfully");
			}
		}

		Thread.sleep(5000);

		driver.findElement(
				By.xpath("//*[@id='publicInboxCtrl']/div[1]/div[3]/div/div/button"))
				.click();
		WebDriverWait wait2 = new WebDriverWait(driver, 5);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='public_maildirdiv']/div/div[1]/div/div[5]/div[contains(text(), 'LCBS Connect Verification Code')]")));

		// driver.findElement(By.xpath("//*[@id='row_public_1481895551-3000179684447-sit6']/div[2]/div[5]/div")).click();

		driver.findElement(
				By.xpath("//*[@id='public_maildirdiv']/div/div[1]/div/div[5]/div[contains(text(), 'LCBS Connect Verification Code')]"))
				.click();

		Thread.sleep(5000);

		driver.switchTo().frame("publicshowmaildivcontent");

		String passcode = driver
				.findElement(
						By.xpath("html/body/table/tbody/tr[3]/td/table/tbody/tr[1]/td/b"))
				.getText();

		System.out.println(passcode);

		Thread.sleep(3000);

		for (String windowHandle : handle1) {

			if (!windowHandle.equals(handle)) {

				driver.switchTo().window(windowHandle);

				Thread.sleep(5000);

				// Registration
				driver.findElement(
						By.xpath("//*[@id='onboarding-wrapper']/div[1]/section/div[2]/div[1]/input"))
						.sendKeys(firstname);

				driver.findElement(
						By.xpath("//*[@id='onboarding-wrapper']/div[1]/section/div[2]/div[2]/input"))
						.sendKeys(lastname);

				driver.findElement(
						By.xpath("//*[@id='onboarding-wrapper']/div[1]/section/div[3]/input"))
						.sendKeys(phno);

				driver.findElement(
						By.xpath("//*[@id='onboarding-wrapper']/div[1]/section/div[4]/input"))
						.sendKeys(passcode);

				Thread.sleep(2000);

				driver.findElement(
						By.xpath("//*[@id='onboarding-wrapper']/div[1]/section/footer/button"))
						.click();
				WebDriverWait wait3 = new WebDriverWait(driver, 360);
				wait3.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("html/body/div[4]/div/div/div[2]/div[1]/a")));

				// Getting user name & password
				String username = driver.findElement(
						By.xpath("html/body/div[4]/div/div/div[2]/div[1]/a"))
						.getText();

				System.out.println(username);
				//credentials.add(username);

				String tempPassword = driver.findElement(
						By.xpath("html/body/div[4]/div/div/div[2]/div[2]/a"))
						.getText();

				System.out.println(tempPassword);
				//credentials.add(tempPassword);
				driver.findElement(
						By.xpath("html/body/div[4]/div/div/div[3]/button"))
						.click();

				driver.close();

				Thread.sleep(2000);

				driver.switchTo().window(handle);
				System.out.println("Switched to Parent window successfully");

			}

		}

		driver.close();

	}

}
