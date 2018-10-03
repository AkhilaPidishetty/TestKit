package appium.appium;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Android extends BaseTest{
	private AndroidDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception {
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps");
		File app = new File(appDir.getCanonicalPath(), "Turnkey.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("VERSION", "7.0");
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("deviceName", "ZY223GDVDP");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.thefloow.thefloowltd.floowdrive.app");
		capabilities.setCapability("appActivity", "com.thefloow.turnkey.ui.launcher.LauncherActivity");
		driver = new AndroidDriver<WebElement>(getServiceUrl(), capabilities);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@org.junit.Test
	public void testFindElementsByAccessibilityId() {
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_email_address"))
				.sendKeys("abcde4@gmail.com");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_password")).sendKeys("Welcome@01");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_confirm_password")).sendKeys("Welcome@01");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_forename")).sendKeys("Sai");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_surname")).sendKeys("Karthik");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_dob")).sendKeys("");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/register_postcode")).sendKeys("01/19/2018");
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/chk_agree")).click();
		driver.findElement(By.id("com.thefloow.thefloowltd.floowdrive.app:id/btn_already_registered")).click();
	}
}
