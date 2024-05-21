package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class MultiBrowserTest {
    static String browser = "firefox";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // Launch the browser
        if (browser.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        else if (browser.equalsIgnoreCase("Firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("Browser name not valid");


        //open url into browser
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print the title of the page
        System.out.println("Title of page " + driver.getTitle());
        //Print the current URL
        System.out.println("Current URL" + driver.getCurrentUrl());
        //Print page source
        System.out.println("Page source" + driver.getPageSource());

        //Click on forgot password link
        driver.findElement(By.className("orangehrm-login-forgot-header")).click();
        System.out.println("Current URL after clicking forgot password " + driver.getCurrentUrl());

        //Navigate back to the login page
        driver.navigate().back();
        //Refresh the page
        driver.navigate().refresh();

        //Enter the credentials
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click on login button
        driver.findElement(By.className("orangehrm-login-button")).click();

        //close the browser
        driver.quit();
    }
}
