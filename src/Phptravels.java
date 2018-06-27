import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//register a user
public class Phptravels
{
    static private WebDriver driver;
    public static void main(String []args) {
        System.setProperty("webdriver.chrome.driver", "src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/register");
        driver.findElement(By.name("firstname")).sendKeys("Payal");
        driver.findElement(By.xpath("//input[@placeholder='Last Name' and @name='lastname']")).sendKeys("Patel");
        driver.findElement(By.name("phone")).sendKeys("98765");
        driver.findElement(By.name("email")).sendKeys("payal.1821@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("confirmpassword")).sendKeys("test123");
        driver.findElement(By.xpath("//button[@type='submit' and @class='signupbtn btn_full btn btn-action btn-block btn-lg']")).click();
       // the program works fine if the user is registering first time and the below code works fine showing the output below as user
       // logged in successfully
        /*String actual_message=driver.findElement(By.xpath("//h3[@style='margin-left: 17px' and @class='RTL']")).getText();
        if (actual_message.contains("Hi"))
        {
            System.out.println("User registered successfully");
        }
        else
        {
            System.out.println("Please check the error message:" +
                    "\nIf email address already exists, try using a different mail address and registering yourself");
        }*/
        //but if the user is trying to log in again with the same name the below problem is faced
        //Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element:
        // Unable to locate element: {"method":"xpath","selector":"//h3[@style='margin-left: 17px' and @class='RTL']"}
        //this will be because the x-path of the error would be different to the one mentioned above. Please guide.

    }
}
