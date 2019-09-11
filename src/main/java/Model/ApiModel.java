package Model;
import java.util.List;

public class ApiModel {

  public static class Model{
    public List<Product> products;
    public List<Page> pages;
    public List<Suggestion> suggestions;
  }

  public static class Suggestion{
    public String term;
  }

  public static class Page{
    public String title;

    @Override
    public String toString() {
      return "Page{" +
              "title='" + title + '\'' +
              '}';
    }
  }

  public static class Term {

    public String term;

    @Override
    public String toString() {
      return "Item{" +
              "term='" + term + '\'' +
              '}';
    }
  }

  public static class Product {
    public List<Image> images;
    public String name;
  }

  public static class Image {
    public String url;

    @Override
    public String toString() {
      return "Url{" +
              "url='" + url + '\'' +
              '}';
    }
  }
}
