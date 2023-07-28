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
public class searchBarTest {
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }

    @Test
    public void searchBarTest() {
        System.out.println("1. Open Homepage.");
        Header header = new Header(driver);
        header.goToLogin();
        System.out.println("2. Log in.");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("auto_user");
        loginPage.enterPasscode("auto_pass");
        loginPage.clickSignIn();
        System.out.println("3. Type 'Magdalena' at search bar");
        Header searchBar = new Header(driver);
        searchBar.search();
        System.out.println("4. Verify that search result is shown");
        searchBar.searchResult();
    }

    @AfterMethod
    public void cleanUp(){
        this.driver.close();
    }

}

