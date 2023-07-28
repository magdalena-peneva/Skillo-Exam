package Exam.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.time.Instant;

public class Header {
    private WebDriver driver;
    WebDriverWait wait;
    private final String URL = "http://training.skillo-bg.com:4200/posts/all";
    @FindBy(id = "homeIcon")
    WebElement logoLink;
    @FindBy(id = "nav-link-home")
    WebElement homeButton;
    @FindBy(id = "nav-link-login")
    WebElement loginButton;
    @FindBy(id = "nav-link-profile")
    WebElement profileButton;
    @FindBy(id = "nav-link-new-post")
    WebElement newPostButton;
    @FindBy(id = "search-bar")
    WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"navbarColor01\"]/form/div/app-search-dropdown/div/div/app-small-user-profile/div/div[1]/a")
    WebElement searchResult;
    @FindBy(css = "#navbarColor01 > form > i")
    WebElement searchButton;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));

    }
    public void clickLogo(){
        wait.until(ExpectedConditions.elementToBeClickable(logoLink));
        logoLink.click();
    }
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }
    public void clickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
    }
    public void clickNewPost() {
        wait.until(ExpectedConditions.elementToBeClickable(newPostButton));
        newPostButton.click();
    }
    public void search() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        searchBar.sendKeys("magdalena");
        searchButton.click();
    }
    public void searchResult() {
        Assert.assertTrue(searchResult.isDisplayed());
    }
    public void openSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        searchResult.click();
    }
    public void goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
    public void profileButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            Assert.assertTrue(loginButton.isDisplayed());
    }

}
