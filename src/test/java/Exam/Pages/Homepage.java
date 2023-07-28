package Exam.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Homepage {
    private WebDriver driver;
    WebDriverWait wait;
    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    @FindBy(id = "homeIcon")
    WebElement logoLink;

    public void navigateTo(){
        String URL = "http://training.skillo-bg.com:4200/posts/all";
        driver.get(URL);
    }
    public void navigate() {
        wait.until(ExpectedConditions.elementToBeClickable(logoLink));
        logoLink.click();
    }
}

