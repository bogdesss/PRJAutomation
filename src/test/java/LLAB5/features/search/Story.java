package LLAB5.features.search;



import LLAB5.pages.LoginPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import LLAB5.steps.serenity.*;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class Story {

    @Managed(uniqueSession = true, driver="firefox")
    public WebDriver webdriver;

    @Steps
    public EndUserLoginSteps loginsteps;

    @Steps
    public EndUserCreateDeleteFolder createdeletesteps;

    @Steps
    public EndUserLogoutSteps logoutsteps;

    @Before
    public void initialisation() {
        // Initialize the web driver
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        loginsteps.goto_home_ftppage_with_credentials("vvss","strugure");

        loginsteps.acceptCookiesIfPresent();
    }
    @Issue("login valid")
    @Test
    public void login_valid() {

        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta30", "vvta30");
    }

    @Issue("create directory")
    @Test
    public void create_dir() {

        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta30", "vvta30");

        // Perform the create directory steps
        createdeletesteps.createDir("dir1");
    }

    @Issue("delete directory")
    @Test
    public void delete_dir() {

        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta30", "vvta30");

        // Perform the create and delete directory steps
        createdeletesteps.createDir("dir1");
        createdeletesteps.deleteDir();
    }

    @Issue("logout")
    @Test
    public void logout() {

        // After SCS login, proceed to net2ftp login with application credentials
        loginsteps.login_to_net2ftp("localhost", "vvta30", "vvta30");

        // Perform the logout steps
        webdriver.manage().window().maximize();
        logoutsteps.logout();
        logoutsteps.verify_message("logged out");
    }
}