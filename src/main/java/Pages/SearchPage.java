package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import static Utils.AssertCollector.assertThatListContainOneExpectedOption;
import static Utils.AssertCollector.checkListWebElementsContainsExpectedText;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
    }

    @FindBy(xpath = "//*[@class='product-title']//span")
    private List<WebElement> headerShopByCategory;

    @FindBy(xpath = "//*[contains(@href, 'E-Book')]")
    private List<WebElement> eBook;

    @FindBy(xpath = "//*[contains(@href, 'O-Book')]")
    private List<WebElement> oBook;

    @FindBy(xpath = "//*[contains(@class,'add-to-cart-button')]")
    private List<WebElement> addCartButton;

    @FindBy(xpath = "//*[contains(@href, 'Print')]")
    private List<WebElement> printButton;

    @FindBy(xpath = "//*[contains(@class,'learn-more-button')]")
    private List<WebElement> viewOnWileyOnlineLibraryButton;

    public void verifyTitleContainsExpectedText(String expectedText){
        checkListWebElementsContainsExpectedText(expectedText, headerShopByCategory);
    }

    public void verifyNumberOfHeaders(int expectedCount){
        Assert.assertTrue(expectedCount == headerShopByCategory.size());
    }

    public void verifyPrintTab(){
        for(int i = 0; i < printButton.size(); i++){
            printButton.get(i).click();
        }
        List<WebElement> addCartByPrint = wd.findElements(By.xpath("//*[contains(@class,'add-to-cart-button')]"));
        List<String> list = new ArrayList<>();
        for(int i = 0; i < addCartByPrint.size(); i++){
            if(!addCartByPrint.get(i).getText().equals("")){
                list.add(addCartByPrint.get(i).getText());
            }
        }
        assertThatListContainOneExpectedOption(list, "ADD TO CART");
    }

    public void verifyEbookTab(){
        for(int i = 0; i < eBook.size(); i++){
            eBook.get(i).click();
        }
        List<WebElement> addCartByEbook = wd.findElements(By.xpath("//*[contains(@class,'add-to-cart-button')]"));
        List<String> list = new ArrayList<>();
        for(int i = 0; i < addCartByEbook.size(); i++){
            if(!addCartByEbook.get(i).getText().equals("")){
                list.add(addCartByEbook.get(i).getText());
            }
        }
        assertThatListContainOneExpectedOption(list, "ADD TO CART");
    }

    public void verifyObookTab(){
        for(int i = 0; i < oBook.size(); i++){
            oBook.get(i).click();
        }
        List<WebElement> addCartByEbook = wd.findElements(By.xpath("//*[contains(@class,'learn-more-button')]"));
        List<String> list = new ArrayList<>();
        for(int i = 0; i < addCartByEbook.size(); i++){
            if(!addCartByEbook.get(i).getText().equals("")){
                list.add(addCartByEbook.get(i).getText());
            }
        }
        assertThatListContainOneExpectedOption(list, "VIEW ON WILEY ONLINE LIBRARY");
    }
}
