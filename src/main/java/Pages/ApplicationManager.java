package Pages;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private WileyMainPage wileyMainPage;
    private SearchPage searchPage;
    private EducationPage educationPage;
    private Properties properties;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));

        if(browser.equals(BrowserType.CHROME)) {
            if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            }else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
        }

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        wileyMainPage = new WileyMainPage(wd);
        searchPage = new SearchPage(wd);
        educationPage = new EducationPage(wd);
    }

    public void stop() {
        wd.quit();
    }

    public WileyMainPage getWileyMainPage() {
        return wileyMainPage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public EducationPage getEducationPage() {
        return educationPage;
    }

    public byte[] takeScreenshot(){
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
}
