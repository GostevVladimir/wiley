import Utils.DataProviderImpl;
import org.testng.annotations.Test;
public class UiTest extends TestBase{

    @Test(dataProvider = "Who-We-Serve", dataProviderClass = DataProviderImpl.class)
    public void itemsUnderWhoWeServe(String option){
        app.getWileyMainPage().moveToWhoWeServeDropDow();
        app.getWileyMainPage().verifyOptionListByWeServeDropDown(option);
    }

    @Test
    public void searchFunctionality(){
        app.getWileyMainPage().inputBySearch("Java");
        app.getWileyMainPage().verifyVisibleSearchList();
    }

    @Test
    public void searchInputAndPressTheSearchButton(){
        app.getWileyMainPage().inputBySearch("Java");
        app.getWileyMainPage().clickSearchButton();
        app.getSearchPage().verifyTitleContainsExpectedText("Java");
        app.getSearchPage().verifyNumberOfHeaders(10);
        app.getSearchPage().verifyPrintTab();
        app.getSearchPage().verifyEbookTab();
        app.getSearchPage().verifyObookTab();
    }

    @Test(dataProvider = "Subject", dataProviderClass = DataProviderImpl.class)
    public void subjectsTopMenuAndSelectEducation(String itemName){
        app.getWileyMainPage().moveToSubjectDropDow();
        app.getWileyMainPage().clickEducationOption();
        app.getEducationPage().verifySubjectItemList(itemName);
    }
}
