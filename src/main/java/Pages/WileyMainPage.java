package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static Utils.AssertCollector.*;

public class WileyMainPage extends BasePage{

    public WileyMainPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//*[@id='main-header-navbar']//a[contains(text(),'WHO WE SERVE')]")
    private WebElement whoWeServeDropDown;

    @FindBy(xpath = "//*[@id='main-header-navbar']//a[contains(text(),'SUBJECT')]")
    private WebElement subjectDropDown;

    @FindBy(xpath = "//*[@id='Level1NavNode1']//a")
    private List<WebElement> whoWeServeDropDownOptions;

    @FindBy(id = "country-location-form")
    public WebElement undetectedCountyModel;

    @FindBy(xpath = "//*[contains(@class, 'changeLocationConfirmBtn')]")
    public WebElement confirmButton;

    @FindBy(id = "js-site-search-input")
    public WebElement searchInput;

    @FindBy(xpath = "//*[@id='js-site-search-input']/following-sibling::span/button")
    public WebElement searchButton;

    @FindBy(id = "ui-id-2")
    public WebElement searchList;

    @FindBy(xpath = "//*[@id='Level1NavNode2']//a[contains(@href, 'Education-c-ED00')]")
    public WebElement educationSubMenu;

    @Step("Move to WE SERVE DropDown")
    public void moveToWhoWeServeDropDow(){
        moveTo(whoWeServeDropDown);
    }

    @Step("Move to SUBJECT DropDown")
    public void moveToSubjectDropDow(){
        moveTo(subjectDropDown);
    }

    public void verifyOptionListByWeServeDropDown(String option){
        assertThatListContainOneExpectedOption(getStringListBeWebElement(whoWeServeDropDownOptions), option);
    }

    @Step("Click YES by Modal window")
    public void acceptUndetectedCounty(){
        if(whoWeServeDropDown.isDisplayed()){
            confirmButton.click();
        }
    }

    @Step ("Input {text} by search")
    public void inputBySearch(String text){
        type(searchInput,text);
    }

    @Step ("Verify visible search list")
    public void verifyVisibleSearchList(){
        elementVisibility(searchList, wd);
        Assert.assertTrue(searchList.isDisplayed());
    }

    @Step ("Click search button")
    public void clickSearchButton(){
         searchButton.click();
    }

    @Step ("Click Education Sub Menu")
    public void clickEducationSubMenu(){
        educationSubMenu.click();
    }

    public void clickEducationOption(){
        moveToSubjectDropDow();
        waitForElementPresent(educationSubMenu, wd);
        clickEducationSubMenu();
    }
}

