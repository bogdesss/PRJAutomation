package LLAB5.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DefaultUrl("https://www.scs.ubbcluj.ro/vvta/net2ftp/") // Update if there's a specific URL for the SCS login
public class LoginPage extends PageObject {

    @FindBy(name = "username") // Update according to the actual element's id or other selector
    private WebElementFacade usernameField;

    @FindBy(name = "password") // Update according to the actual element's id or other selector
    private WebElementFacade passwordField;
    @FindBy(name = "ftpserver") // Update according to the actual element's id or other selector
    private WebElementFacade serverField;
    @FindBy(id = "LoginButton1") // Update according to the actual element's selector
    private WebElementFacade loginButton;

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void select_server(String server) {
        serverField.type(server);
    }

    @FindBy(id = "LoginButton1") // Replace with the actual CSS selector for the yellow button
    private WebElementFacade saveCookieChoiceButton;

    public void acceptCookies() {
        // Wait for the cookie button to be clickable and then click it
        withTimeoutOf(Duration.ofSeconds(2)).waitFor(ExpectedConditions.elementToBeClickable(saveCookieChoiceButton));
        saveCookieChoiceButton.click();
    }
}