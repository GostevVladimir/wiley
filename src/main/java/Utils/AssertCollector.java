package Utils;
import org.openqa.selenium.WebElement;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertCollector {

    public static void assertThatListContainOneExpectedOption(List<String> list, String expectedOption) {
        try {
            assertThat(list).contains(expectedOption);
        } catch (Throwable e) {
            throw new RuntimeException("Verification is not passed - ACTUAL LIST not contain EXPECTED VALUES " + expectedOption);
        }
    }

    public static void checkListWebElementsContainsExpectedText(String expectedText, List<WebElement> list) {
        for (WebElement webElement : list) {
            assertThat(webElement.getText()).as("COMPARISON OF WEB-ELEMENT PARTIAL TEXT").contains(expectedText);
        }
    }
}
