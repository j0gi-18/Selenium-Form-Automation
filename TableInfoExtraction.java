package seleniumautomat;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.List;

public class TableInfoExtraction {
    public static void main(String[] args) {
        // path to GeckoDriver executable
        System.setProperty("webdriver.gecko.driver", "C:/Users/Administrator/Desktop/driver/geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();

        WebDriver driver = new FirefoxDriver(options);

        try {
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/webtables");

            // Find all rows in the web table
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
            System.out.println("Web Table Data:");

            for (WebElement row : rows) {
                try {
                    List<WebElement> cells = row.findElements(By.className("rt-td"));
                    for (WebElement cell : cells) {
                        System.out.print(cell.getText() + "  ");
                    }
                    System.out.println();
                } catch (NoSuchElementException e) {
                    System.out.println("Row cell not found.");
                }
            }

        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
