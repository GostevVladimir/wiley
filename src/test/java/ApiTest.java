import org.testng.Assert;
import org.testng.annotations.Test;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static Utils.ApiHelper.*;

public class ApiTest {

  public static final String DELAY_URL = "https://httpbin.org/delay/5";


  @Test
  public void verifyTerm(){
    List<String> list = getTermList();
    checkListContainsExpectedText(list, "<span class=\"search-highlight\">java</span>");
  }

  @Test
  public void verifyName(){
    List<String> list = getNameList();
    checkListContainsExpectedText(list, "<span class='search-highlight'>Java</span>");
  }

  @Test
  public void verifyTitle(){
    List<String> list = getTitleList();
    checkListContainsExpectedText(list, "Wiley");
  }

  @Test
  public void verifyWidthByImage() throws IOException{
    String url = getFirstUrl();
    getImageResponse(url);
    File file = new File("src/main/resources/file.JPEG");
    BufferedImage image = ImageIO.read(file);
    image.getWidth();
    Assert.assertTrue(300 == image.getWidth());
    file.delete();
  }

  @Test(timeOut = 10000L)
  public void verifyTimeout() {
    postApiResponse(DELAY_URL);
  }
}
