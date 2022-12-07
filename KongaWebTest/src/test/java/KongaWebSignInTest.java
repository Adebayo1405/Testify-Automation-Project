import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

    public class KongaWebSignInTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //Locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //1.Object is created Chrome browser is opened
        driver = new ChromeDriver();
        //2. Input the Konga Page URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");

        //Test1. Verify the user input the right url and his on the right webpage
        String actualUrl="https://www.konga.com/";
        String expectedUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("The Web Url is correct");

        Thread.sleep(5000);
        //3.Maximize the browser
        driver.manage().window().maximize();
        //4.Get the page title
        //Test2.verify title of the webpage
        System.out.println(driver.getTitle());
       driver.get("https://www.konga.com/");
        String actualTitle=driver.getTitle();
       String expectedTitle = "Buy Phones, Fashion, Electronics in Nigeria_Konga Online Shopping | Konga Online Shopping";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Correct Tittle");


        Thread.sleep(5000);
    }

     @Test(priority = 0)
           public void positiveSignIn() throws InterruptedException {
       //5.Click on the sign-in/log in button
       driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
       //6.Locate the email address field and Input  email address on the email address field
       driver.findElement(By.id("username")).sendKeys("Coolove45@mailinator.com");
       //7.Locate the password field and Input password on the password field
       driver.findElement(By.id("password")).sendKeys("@Admin12345");
       //8.Click on the Sign in/login/Continue button
       driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
       Thread.sleep(5000);
    }
       @Test(priority = 1)
       public void logOut() throws InterruptedException {
    //9.Logout from the account
       driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")).click();
       driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
           Thread.sleep(5000);

    }

       @Test(priority = 2)
       public void invalidEmail() throws InterruptedException {
        //5.Click on the sign-in/log in button
        String homePage = "https://www.konga.com/";

        if (driver.getCurrentUrl().equals(homePage)) {
            //proceed to log in
            driver.navigate().refresh();

        } else {
            driver.navigate().to(homePage);
            Thread.sleep(5000);
        }
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //6.Locate the email address field and Input  email address on the email address field
        driver.findElement(By.id("username")).sendKeys("Coomailinator.com");
        //7.Locate the password field and Input password on the password field
        driver.findElement(By.id("password")).sendKeys("@Admin12345");
        //8.Click on the Sign in/login/Continue button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //9.Logout from the account

        Thread.sleep(3000);
    }


     @Test(priority = 3)
     public void blankField() throws InterruptedException {
        //5.Click on the sign-in/log in button
        String homePage = "https://www.konga.com/";

        if (driver.getCurrentUrl().equals(homePage)) {
            //proceed to log in
            driver.navigate().refresh();

        } else {
            driver.navigate().to(homePage);
            Thread.sleep(3000);
        }
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        //6.Locate the email address field and Input  email address on the email address field
        driver.findElement(By.id("username")).sendKeys("");
        //7.Locate the password field and Input password on the password field
        driver.findElement(By.id("password")).sendKeys("");
        //8.Click on the Sign in/login/Continue button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        //9.Logout from the account


        Thread.sleep(5000);
    }

        @Test(priority = 4)
        public void invalidPassword() throws InterruptedException {
            //5.Click on the sign-in/log in button
            String homePage = "https://www.konga.com/";

            if (driver.getCurrentUrl().equals(homePage)) {
                //proceed to log in
                driver.navigate().refresh();

            } else {
                driver.navigate().to(homePage);
                // Thread.sleep(3000);
            }
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            //6.Locate the email address field and Input  email address on the email address field
            driver.findElement(By.id("username")).sendKeys("Coolove45@mailinator.com");
            //7.Locate the password field and Input password on the password field
            driver.findElement(By.id("password")).sendKeys("Admin12345");
            //8.Click on the Sign in/login/Continue button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            //9.Logout from the account

            Thread.sleep(5000);
        }
     @AfterTest
     public void closeBrowser(){
        //10. Quit the browser
        driver.quit();
    }
   }





