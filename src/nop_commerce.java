import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//complete nop commerce demo form
public class nop_commerce
{
    static protected WebDriver driver;
    public static void main(String [] args)
    {
        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");//sets the browser to chrome
        driver=new ChromeDriver();//assigns that our driver variable is chrome driver
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Register")).click();//finds register and clicks on it
        driver.findElement(By.id("gender-female")).click();//clicks on radio button
        driver.findElement(By.name("FirstName")).sendKeys("Payal");
        driver.findElement(By.name("LastName")).sendKeys("Patel");
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[@value='16']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[@value='10']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[@value='1983']")).click();
        driver.findElement(By.name("Email")).sendKeys("payal_mumbai82@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("Patel's corner");
        driver.findElement(By.id("Newsletter")).click();
        driver.findElement(By.id("Password")).sendKeys("testing123");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("testing123");
        driver.findElement(By.id("register-button")).click();
        String actualerror="The specified email already exists";
        String message=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form/div/ul/li")).getText();
        //System.out.println(message);
        //
         if (actualerror.equals(message))
         {
             System.out.println("The test case is passed");
         }
         else
         {
             System.out.println("The test case is failed");
         }

    }
}
