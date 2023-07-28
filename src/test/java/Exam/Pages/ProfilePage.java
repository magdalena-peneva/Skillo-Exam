package Exam.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ProfilePage {
    private WebDriver driver;
    WebDriverWait wait;
    private final String URL = "http://training.skillo-bg.com:4200/posts/all";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(8));
    }

    @FindBy(xpath = "/html/body/app-root/div[2]/app-profile/div/div[1]/app-profile-section/div/div/div[2]/div/div[1]/i")
    WebElement editProfileButton;
    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[5]/div/textarea")
    WebElement infoField;
    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/app-edit-profile-modal/div/form/div[6]/div/button")
    WebElement saveButton;
    @FindBy(id = "nav-link-profile")
    WebElement profileButton;
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profileButton));
        profileButton.click();
    }
    public void editProfile(){
        wait.until(ExpectedConditions.elementToBeClickable(editProfileButton));
        editProfileButton.click();
    }
    public void editInfoField() {
        wait.until(ExpectedConditions.elementToBeClickable(infoField));
        infoField.sendKeys("testqa");
    }
        public void saveProfileInfo(){
            wait.until(ExpectedConditions.elementToBeClickable(saveButton));
            saveButton.click();

    }
}
