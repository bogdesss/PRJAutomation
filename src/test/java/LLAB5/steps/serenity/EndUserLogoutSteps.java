package LLAB5.steps.serenity;


import net.thucydides.core.annotations.Step;
import LLAB5.pages.LogoutPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class EndUserLogoutSteps {

    LogoutPage logoutPage;

    @Step
    public void logout() {
        logoutPage.logout();
    }

    @Step
    public void verify_message(String message) {
        String logoutMessage = logoutPage.getLogoutConfirmationMessage();
        assertThat(logoutMessage, containsString(message));
    }
}