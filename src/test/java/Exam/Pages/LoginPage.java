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

public class LoginPage {
  private final String URL = "http://training.skillo-bg.com:4200/posts/all";
  WebDriverWait wait;
  WebDriver driver;
  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(this.driver, Duration.ofSeconds(8));
  }

  @FindBy(css = "form h4")
  WebElement loginText;
  @FindBy(id = "defaultLoginFormUsername")
  WebElement usernameField;
  @FindBy(id = "defaultLoginFormPassword")
  WebElement passcodeField;
  @FindBy(id = "sign-in-button")
  WebElement signinButton;
  @FindBy(id = "toast-container")
  WebElement errorInvalidUser;


  public void clickLogin() {
    wait.until(ExpectedConditions.elementToBeClickable(loginText));
    loginText.click();
  }
  public void enterUsername(String username) {
    wait.until(ExpectedConditions.visibilityOf(usernameField));
    usernameField.sendKeys(username);
  }
  public void enterPasscode(String password) {
    wait.until(ExpectedConditions.visibilityOf(passcodeField));
    passcodeField.sendKeys(password);
  }
  public void clickSignIn() {
    wait.until(ExpectedConditions.elementToBeClickable(signinButton));
    signinButton.click();
  }
  public void verifyErrorText() {
    Assert.assertTrue(errorInvalidUser.isDisplayed());
  }
}
