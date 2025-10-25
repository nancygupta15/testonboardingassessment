import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLaunchTest {
    WebDriver driver;

    @Test
    public void testBrowserType() {
        String browser = System.getProperty("browser", "chrome");
        String url= System.getProperty("baseUrl", "www.google.com");
        System.out.println("Running tests on browser: " + browser);
        System.out.println("Navigating to URL: " + url);
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("edge")) {
           driver = new EdgeDriver();
        } else {
            System.out.println("Browser not recognized. Defaulting to Chrome logic.");
        }
        if(driver!=null) {
            driver.get(url);
            System.out.println("Page title is: " + driver.getTitle());
            driver.quit();
        } else {
            System.out.println("Driver not initialized. Skipping browser actions.");
        }
    }

}
