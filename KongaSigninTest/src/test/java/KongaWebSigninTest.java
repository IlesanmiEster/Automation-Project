import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebSigninTest {

    //Import the Konga WebDriver
    private WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1. Open the Chrome browser
        driver = new ChromeDriver();
        //2. Input the Konga webpage Url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //Test. verify the user input the right url and on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        //3. Maximize the window
        driver.manage().window().maximize();
        //4. Click on Login button to open the Login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
}
    @Test (priority =0 )
    public void positiveSignup() throws InterruptedException {
        //5.Input email address on the email field
        driver.findElement(By.id("username")).sendKeys("leoham007@yahoo.com");
        //6.  Locate the password field and Input your password on the username field
        driver.findElement(By.id("password")).sendKeys("Praisepearl@1");
        //7. Click on the signin button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //Test  verify that user clicks on the signin button,the user is directed to the signin page
        String expectedUrl = "https://www.konga.com/account/login?return_url=/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }
    @Test (priority = 1 )
    public void logoutSuccessfully() throws InterruptedException {
        //8.click on dropdown button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
        Thread.sleep(5000);
        //9. Click the Logout button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        //Test verify that when user logout, he is directed to the homepage
        String expectedUrl = "https://www.konga.com/";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        Thread.sleep(15000);
    }
     @Test (priority =2 )
     public void negativeUsernameSignin() throws InterruptedException {
         //10. Click on Login button to open the Login page
         driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
         //11.Input email address on the email field
         //Test. Confirm user cannot sign in using wrong email
         driver.findElement(By.id("username")).sendKeys("ty@yahoo.com");
         //Test. Confirm user cannot sign in using wrong password
         //12.  Locate the password field and Input your password on the username field
         driver.findElement(By.id("password")).sendKeys("Ppearl@1");
         //13. Click on the login button
         driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
         //Test  verify that user clicks on the signin button,the user is directed to the signin page
         Thread.sleep(10000);
    }
    @AfterTest
    public void closeBrowser(){
        //Quit the Browser
        driver.quit();
    }











}
