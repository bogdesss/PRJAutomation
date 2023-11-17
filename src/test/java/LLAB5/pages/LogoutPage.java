package LLAB5.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.stream.Collectors;

public class LogoutPage extends PageObject {

    @FindBy(xpath = "//img[@alt='Logout (accesskey l)']/ancestor::a") // Update according to the actual element's text or other selector
    private WebElementFacade logoutLink;

    public void logout() {
        logoutLink.click();
    }

    public String getLogoutConfirmationMessage() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.tagName("p")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList()).toString();
    }
}