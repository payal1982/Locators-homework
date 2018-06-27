//program to register the user and showing the appropriate result after logging in and comparing it after second attempt
//when you run the test you error message will pop up, since user is already registered once.
// If you change the email address in the coding the program will allow you to register the user.
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Automation_Practice
{
    static protected WebDriver driver;
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("payal.82@gmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Payal");
        driver.findElement(By.id("customer_lastname")).sendKeys("Patel");
        driver.findElement(By.id("passwd")).sendKeys("test123");
        driver.findElement(By.xpath("//select[@id='days']/option[@value='15']")).click();
        driver.findElement(By.xpath("//select[@name='months']/option[@value='10']")).click();
        driver.findElement(By.xpath("//select[@name='years']/option[@value='1993']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Payal" );
        driver.findElement(By.id("lastname")).sendKeys("Patel");
        driver.findElement(By.id("company")).sendKeys("Patel's Corner");
        driver.findElement(By.id("address1")).sendKeys("Quadrant Court");
        driver.findElement(By.id("address2")).sendKeys("211");
        driver.findElement(By.id("city")).sendKeys("London");
        driver.findElement(By.xpath("//select[@id='id_state'] /option[@value='9']")).click();
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.xpath("//select[@id='id_country'] /option[@selected='selected']"));
        driver.findElement(By.id("other")).sendKeys("Please call before delivery");
        driver.findElement(By.id("phone")).sendKeys("123456");
        driver.findElement(By.id("phone_mobile")).sendKeys("9876543");
        driver.findElement(By.id("alias")).sendKeys("Office");
        driver.findElement(By.xpath("//button[@name='submitAccount']")).click();
        String actual_reult=driver.findElement(By.xpath("//ol/li")).getText();
        if (actual_reult.contains("already been registered"))
        {
            System.out.println("Test is passed since the user is already registered");
            System.out.println("Try changing the email address, in the code above and you should be able to register");
        }

    }
}
