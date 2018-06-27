import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//program to automate filling in the form for the new tours ltd.
// Since the user will already be registered once, error message would be displayed
public class New_Tours
{
    static protected WebDriver driver;
    public static void main(String[]args)
    {
    System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=649bc8cf2ce17ae2d091bce2b50775af");
    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Payal");
    driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Patel");
    driver.findElement(By.name("phone")).sendKeys("1234567");
    driver.findElement(By.id("userName")).sendKeys("payal@gmail.com");
    driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Flat 234 Quadrant Court");
    driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Empire Way");
    driver.findElement(By.name("city")).sendKeys("Wembley");
    driver.findElement(By.xpath("//td/input[@name='state']")).sendKeys("Middlesex");
    driver.findElement(By.name("postalCode")).sendKeys("HA9 0EY");
    driver.findElement(By.xpath("//select/option[@value='214']")).click();
    driver.findElement(By.id("email")).sendKeys("payalpatel");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
    driver.findElement(By.name("confirmPassword")).sendKeys("test123");
    driver.findElement(By.name("register")).click();
    String actual_message=driver.findElement(By.xpath("//p/font/b")).getText();
      //  System.out.println(actual_message);
        if (actual_message.contains("Dear"))
        {
            System.out.println("User logged in successfully");
        }
    }
}
