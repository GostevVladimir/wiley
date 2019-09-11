package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver wd;
    protected final static int WAITING_TIME_IN_SECONDS = 30;

    public BasePage(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(WebElement locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = locator.getAttribute("value");
            if (!text.equals(existingText)) {
                locator.clear();
                locator.sendKeys(text);
            }
        }
    }

    protected void click(WebElement locator) {
        locator.click();
    }

    protected void moveTo(WebElement element) {
        Actions action = new Actions(wd);
        action.moveToElement(element).perform();
    }


    public static WebElement waitForElementPresent(WebElement element, WebDriver driver) {
        return (new WebDriverWait(driver, WAITING_TIME_IN_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected List<String> getStringListBeWebElement(List<WebElement> elementList){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < elementList.size(); i++){
            list.add(elementList.get(i).getText());
        }
        return  list;
    }

    public static WebElement elementVisibility(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAITING_TIME_IN_SECONDS);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
