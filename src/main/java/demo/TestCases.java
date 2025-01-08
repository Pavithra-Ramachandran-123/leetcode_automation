package demo;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    WebDriverWait wait;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        Assert.isTrue(driver.getCurrentUrl().contains("leetcode"), "url is wrong");
        System.out.println("end Test case: testCase01\n");
    }

    public void testCase02(){
        System.out.println("Start Test case: testCase02");
        WebElement viewQuestions= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'View Questions')]")));
        viewQuestions.click();
        wait.until(ExpectedConditions.urlContains("problemset"));
        Assert.isTrue(driver.getCurrentUrl().contains("problemset"), "url doesnt contain problemset");
        List<WebElement> questions=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='row']")));
        for(int i=2;i<=6;i++){
            System.out.println(questions.get(i).getText());
        }
        System.out.println("end Test case: testCase02\n");
    }

    public void testCase03(){
        System.out.println("Start Test case: testCase03");
        WebElement twoSum=driver.findElement(By.partialLinkText("Two Sum"));
        twoSum.click();
        Assert.isTrue(driver.getCurrentUrl().contains("description"), "url doesnt render problem page");
        System.out.println("end Test case: testCase03\n");
    }

    public void testCase04(){
        System.out.println("Start Test case: testCase04");
        WebElement submissionsTab=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"submissions_tab\"]/div[2]/div[2]")));
        submissionsTab.click();
        WebElement registerOrSignup=wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Register or Sign In")));
        // Actions actions=new Actions(driver);
        // actions.moveToElement(submit).perform();
        Assert.isTrue(registerOrSignup.getText().contains("Register or Sign In"), "Register or Sign In up message doesnt show up");
        System.out.println("end Test case: testCase04\n");
    }    


}
