package LLAB5.steps.serenity;



import net.thucydides.core.annotations.Step;
import LLAB5.pages.LoginPage;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

public class EndUserLoginSteps {

    LoginPage loginPage;

    // Step to navigate to the FTP page
    @Step
    public void goto_home_ftppage() {
        loginPage.open();
    }
    @Step
    public void goto_home_ftppage_with_credentials(String username, String password) {
        String baseUrl = "https://www.scs.ubbcluj.ro/vvta/net2ftp/"; // base URL of your application
        WebDriver driver = ThucydidesWebDriverSupport.getDriver();
        String authUrl = "https://" + username + ":" + password + "@" + baseUrl.substring(8); // Skips 'https://'
        driver.get(authUrl); // Directly opens the URL with credentials
    }
    // Step to perform login using SCS UBB Cluj credentials
    @Step
    public void enter_data_and_click_login(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
    @Step
    public void acceptCookiesIfPresent() {
        loginPage.acceptCookies();
    }
    // Step to perform login on net2ftp page after SCS UBB Cluj portal login
    @Step
    public void login_to_net2ftp(String server, String username, String password) {
        // Assumes that the server input is present on the same login page
        // If it's a separate action/page, then additional navigation steps would be required
        loginPage.select_server(server);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }
}