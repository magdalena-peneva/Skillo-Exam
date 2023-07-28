package Exam.Tests;
import Exam.Pages.Header;
import Exam.Pages.Homepage;
import Exam.Pages.LoginPage;
import Exam.Pages.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class editProfileTest {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void editProfileTest() {
        System.out.println("1.Log in.");
        Homepage homePage = new Homepage(driver);
        homePage.navigateTo();
        Header header = new Header(driver);
        header.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("auto_user");
        loginPage.enterPasscode("auto_pass");
        loginPage.clickSignIn();
        System.out.println("2. Open Profile page");
        ProfilePage profile = new ProfilePage(driver);
        profile.clickProfile();
        System.out.println("3. Open Edit window");
        ProfilePage profileEdit = new ProfilePage(driver);
        profileEdit.editProfile();
        System.out.println("4. Edit public info.");
        profileEdit.editInfoField();
        System.out.println("5. Save new info text.");
        profileEdit.saveProfileInfo();

    }
    @AfterMethod
    public void cleanUp(){
        this.driver.close();
    }

}

