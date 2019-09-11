package Utils;
import Model.ApiModel;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiHelper {

  public static final String URL = "https://www.wiley.com/en-us/search/autocomplete/comp_00001H9J?term=Java";

  public static HttpResponse<String> getApiResponse(String url){
    HttpResponse<String> json = Unirest.get(url)
            .asString();
    return json;
  }

  public static HttpResponse<String> postApiResponse(String url){
    HttpResponse<String> json = Unirest.post(url)
            .asString();
    return json;
  }

  public static File getImageResponse(String url){
    File result = Unirest.get(url)
            .asFile("src/main/resources/file.JPEG")
            .getBody();
    return result;
  }

  public static List<String> getTermList(){
    HttpResponse<String> json = getApiResponse(URL);
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ApiModel.Model model = null;
    try {
      model = mapper.readValue(json.getBody(), ApiModel.Model.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> resultList = new ArrayList<>();
    for (ApiModel.Suggestion suggestion : model.suggestions) {
      resultList.add(suggestion.term);
    }
    return resultList;
  }

  public static List<String> getNameList(){
    HttpResponse<String> json = getApiResponse(URL);
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ApiModel.Model model = null;
    try {
      model = mapper.readValue(json.getBody(), ApiModel.Model.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> resultList = new ArrayList<>();
    for (ApiModel.Product product : model.products) {
      resultList.add(product.name);
    }
    return resultList;
  }

  public static List<String> getTitleList(){
    HttpResponse<String> json = getApiResponse(URL);
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ApiModel.Model model = null;
    try {
      model = mapper.readValue(json.getBody(), ApiModel.Model.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    List<String> resultList = new ArrayList<>();
    for (ApiModel.Page page : model.pages) {
      resultList.add(page.title);
    }
    return resultList;
  }

  public static String getFirstUrl(){
    HttpResponse<String> json = getApiResponse(URL);
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ApiModel.Model model = null;
    try {
      model = mapper.readValue(json.getBody(), ApiModel.Model.class);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String url = "";
    for (ApiModel.Product product : model.products) {
      for (ApiModel.Image image : product.images) {
        url = image.url;
        break;
      }
    }
    return url;
  }

  public static void checkListContainsExpectedText(List<String> list, String expectedText){
    for(int i = 0; i < list.size(); i++){
      Assert.assertTrue(list.get(i).contains(expectedText));
    }
  }
}
