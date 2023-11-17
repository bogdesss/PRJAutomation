package LLAB5.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class HomePage extends PageObject {

    @FindBy(xpath = "//input[@value='New dir']")
    private WebElementFacade newDirButton;

    @FindBy(name = "newNames[1]")
    private WebElementFacade firstTextInput;

    @FindBy(xpath = "//img[@alt='Submit (accesskey v)']/ancestor::a")
    private WebElementFacade yesButton;

    @FindBy(xpath = "//img[@alt='Back (accesskey b)']/ancestor::a")
    private WebElementFacade backButton;


    @FindBy(name = "list[1][dirfilename]")
    private WebElementFacade checkboxForFirstDirectory;



    @FindBy(xpath = "//input[@value='Delete']")
    private WebElementFacade deleteButton;

    @FindBy(xpath = "//img[@alt='Submit (accesskey v)']/ancestor::a")
    private WebElementFacade confirmDeleteButton;


    public void createNewDir() {
        newDirButton.click();
    }

    public void setNewDirName(String dirName) {
        firstTextInput.type(dirName);
    }

    public void confirmYes() {
        yesButton.click();
    }

    public void goBack() {
        backButton.click();
    }

    public void selectFirstDirectory() {
        checkboxForFirstDirectory.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void confirmDelete() {
        confirmDeleteButton.click();
    }
}