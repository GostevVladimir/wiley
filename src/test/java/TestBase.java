import Listener.MyTestListener;
import Pages.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(MyTestListener.class)
public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUp(ITestContext context) throws Exception {
        app.init();
        app.getWileyMainPage().acceptUndetectedCounty();
        context.setAttribute("app", app);
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
