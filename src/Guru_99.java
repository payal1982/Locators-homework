//login to Guru99 and add a customer
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Guru_99
{
    static protected WebDriver driver;
    public static void main (String[]args)
    {
        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver=new ChromeDriver();//assigns that our driver variable is chrome driver
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/v4/index.php");
        //tried to use x-paths even though name and class was available
        driver.findElement(By.xpath("//td/input[@type='text']")).sendKeys("mngr139541");
        driver.findElement(By.xpath("//td/input[@onkeyup='validatepassword();']")).sendKeys("qUtUdaz");
        driver.findElement(By.xpath("//td/input[@name='btnLogin']")).click();//clicks on submit button
        driver.findElement(By.xpath("//a[text()='New Customer']")).click();//selects new customer
        driver.findElement(By.xpath("//input[@type='text' and @name='name']")).sendKeys("Payal");
        driver.findElement(By.xpath("//input[@type='radio' and @value='f']")).click();//select radio button for female
        driver.findElement(By.id("dob")).sendKeys("15/10/1983");
        driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("234 Quadrant Court\nEmpire Way");
        driver.findElement(By.name("city")).sendKeys("Wembley");
        driver.findElement(By.name("state")).sendKeys("Middlesex");
        driver.findElement(By.name("pinno")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys("07986754375");
        driver.findElement(By.name("emailid")).sendKeys("payal123456@gmail.com");
        driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Submit']")).click();
        String actual_message=driver.findElement(By.xpath("//p[@class='heading3']")).getText();
        String expected_message ="Customer Registered Successfully!!!";
        if (actual_message.equals(expected_message))
        {
            System.out.println("Test passed");
        }
        else
            System.out.println("Test failed");
    }
}
