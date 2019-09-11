package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static Utils.AssertCollector.assertThatListContainOneExpectedOption;

public class EducationPage extends BasePage{
    public EducationPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//h4[contains(text(), 'Subject')]")
    private WebElement subjectTitle;

    @FindBy(xpath = "//*[@class='side-panel']")
    private WebElement subjectLeftPanel;

    @FindBy(xpath = "//*[@class='side-panel']//a")
    private List<WebElement> subjectLeftPanelItemList;

    public void verifySubjectItemList(String itemName) {
        moveTo(subjectTitle);
        subjectLeftPanel.isDisplayed();
        getStringListBeWebElement(subjectLeftPanelItemList);
        assertThatListContainOneExpectedOption(getStringListBeWebElement(subjectLeftPanelItemList), itemName);

    }
}
