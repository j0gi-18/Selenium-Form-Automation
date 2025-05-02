package seleniumautomat;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class FormAutomation {
    public static void main(String[] args) {
        // path to the GeckoDriver
        System.setProperty("webdriver.gecko.driver", "C:/Users/Administrator/Desktop/driver/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        // basic details
        driver.findElement(By.id("firstName")).sendKeys("Sagar");
        driver.findElement(By.id("lastName")).sendKeys("Kumbhar");
        driver.findElement(By.id("userEmail")).sendKeys("sagar.kumbhar@yahoo.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");

        // Scroll to Date of Birth field
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dob);

        // Open date picker
        dob.click();

        // Select year
        WebElement yearSelect = driver.findElement(By.className("react-datepicker__year-select"));
        Select year = new Select(yearSelect);
        year.selectByVisibleText("2025");

        // Select month
        WebElement monthSelect = driver.findElement(By.className("react-datepicker__month-select"));
        Select month = new Select(monthSelect);
        month.selectByVisibleText("May");

        // Select day
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='1']")).click();

        // Subjects
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys(Keys.ENTER);

        // Hobbies
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        driver.findElement(By.xpath("//label[text()='Reading']")).click();
        driver.findElement(By.xpath("//label[text()='Music']")).click();

        // Picture Upload
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\\\Users\\\\Administrator\\\\Desktop\\\\download.jpg");

        // Address
        driver.findElement(By.id("currentAddress")).sendKeys("Gahunje Nagar, New Delhi");

        // Scroll for dropdowns
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");

        // State and City
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();

        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();

        // Submit
        driver.findElement(By.id("submit")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
