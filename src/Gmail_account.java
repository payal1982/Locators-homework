import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//create gmail account using automation
public class Gmail_account
{
    static protected WebDriver driver;
    public static void main(String[]args)
    {
        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.findElement(By.id("firstName")).sendKeys("pay");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("all");
        driver.findElement(By.id("username")).sendKeys("allpay621");
        driver.findElement(By.xpath("//input[@type='password' and @aria-label='Password']")).sendKeys("Test123*");
        driver.findElement(By.xpath("//input[@type='password' and @aria-label='Confirm password']")).sendKeys("Test123*");
        driver.findElement(By.xpath("//div[@id='accountDetailsNext']/content")).click();
        //driver.findElement(By.xpath("//div[@id='identifierLink']/div[2]/p")).click();
        driver.findElement(By.id("phoneNumberId")).sendKeys("07896543421");
        driver.findElement(By.xpath("//select[@id='month']/option[@value='10']")).click();
        driver.findElement(By.xpath("//input[@aria-label='Day']")).sendKeys("14");
        driver.findElement(By.xpath("//input[@aria-label='Year']")).sendKeys("1983");
        driver.findElement(By.xpath("//select[@id='gender']/option[@value='2']")).click();
        driver.findElement(By.xpath("//div[@id='personalDetailsNext']")).click();
        driver.findElement(By.xpath("//div[@id='c0']")).click();
        driver.findElement(By.xpath("//div[@id='c2']")).click();
        driver.findElement(By.xpath("//div[@id='termsofserviceNext']")).click();
        driver.findElement(By.xpath("confirmdialog-confirm")).click();
        String actualmessage=driver.findElement(By.xpath("//div[@class='ZrQ9j']")).getText();
        if (actualmessage.contains("Welcome"))
        {
            System.out.println("User logged in successfully");
        }
        else
        {
            System.out.println("It looks like the user name is already used up. Please try again with new details");
        }
    }

}
