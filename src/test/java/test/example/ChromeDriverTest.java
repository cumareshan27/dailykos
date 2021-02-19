package test.example;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ChromeDriverTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSignup() throws Exception {
    driver.get("https://my.katalon.com/signup?anonymous_id=&redirect_uri=https://www.katalon.com/sign-up-survey&utm_source=browser%20store");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("fullName")).click();
    driver.findElement(By.name("password")).click();
  }
  
  @Test
  public void testNavigationWell() throws Exception {
    driver.get("https://www.dailykos.com/groups/Good%20News");
    driver.findElement(By.linkText("Messages")).click();
  }
  
  @Test
  public void testSearchBar() throws Exception {
	    driver.get("https://www.dailykos.com/groups/Good%20News");
	    driver.findElement(By.name("text")).click();
	    driver.findElement(By.name("text")).clear();
	    driver.findElement(By.name("text")).sendKeys("democrats");
	    driver.findElement(By.name("text")).sendKeys(Keys.ENTER);
	  }
  
  @Test
  public void testMenu() throws Exception {
    driver.get("https://www.dailykos.com/groups/Good%20News");
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div/div/div/ul/li/div/div")).click();
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div/div/div/ul/li[2]/a/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div/div/div/ul/li[3]/a/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div/div/div/ul/li[4]/a/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div/div/div/ul/li[5]/a/div[2]")).click();
    driver.findElement(By.xpath("//div[@id='react-property-sheets-app']/div/div[2]/div[2]/section/div/article/a/div/div/div[2]/div/h4")).click();
  }
  

 
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
