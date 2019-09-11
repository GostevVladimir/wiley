package Utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataProviderImpl {

    private DataProviderImpl() {
    }

    @DataProvider(name = "Who-We-Serve")
    public static Object[][] whoWeServeDataProvider() throws URISyntaxException, IOException {
        URL resource = DataProviderImpl.class.getClassLoader().getResource("WhoWeServeTitles.csv");
        List<String> list = Files.readAllLines(Paths.get(resource.toURI()));

        String[][] array = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = new String[]{list.get(i)};
        }
        return array;
    }


    @DataProvider(name = "Subject")
    public static Object[][] subjectDataProvider() throws URISyntaxException, IOException {
        URL resource = DataProviderImpl.class.getClassLoader().getResource("SubjectItem.csv");
        List<String> list = Files.readAllLines(Paths.get(resource.toURI()));

        String[][] array = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            array[i] = new String[]{list.get(i)};
        }
        return array;
    }
}
