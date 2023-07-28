package Exam.Tests;
import Exam.Pages.Header;
import Exam.Pages.Homepage;
import Exam.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


    public class invalidLoginTest {
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
        public void invalidLoginTest() {
            System.out.println("1. Go to Homepage");
            Homepage homePage = new Homepage(driver);
            homePage.navigateTo();
            System.out.println("2. Go to Login page");
            Header header = new Header(driver);
            header.goToLogin();
            System.out.println("3. Type invalid username at input field");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUsername("test");
            System.out.println("4. Type invalid passcode at input field");
            loginPage.enterPasscode("test");
            System.out.println("5. Click on Login button");
            loginPage.clickSignIn();
            System.out.println("6. Verify that error is displayed.");
            loginPage.verifyErrorText();
        }

        @AfterMethod
        public void cleanUp(){
            this.driver.close();
        }

    }

