package crawlsData;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataSkinCare {
    private final String url = "https://hasaki.vn/";
    private ArrayList<String> nameSkinCare = new ArrayList<>();
    private ArrayList<String> priceSkinCare = new ArrayList<>();
    private ArrayList<Integer> idSkinCare = new ArrayList<>();
    public CrawlsDataSkinCare() {
    }
    public ArrayList<String> getNameSkinCare() {
        return nameSkinCare;
    }
    public ArrayList<String> getPriceSkinCare() {
        return priceSkinCare;
    }
    public ArrayList<Integer> getIdSkinCare() {
        return idSkinCare;
    }
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("name product-title");
            ArrayList<Element> elements1 = doc.getElementsByClass("woocommerce-Price-amount amount");
            int id = 0;
            for (int i = 1; i <=5 ; i++) {
                String name = elements.get(i).getElementsByTag("a").text();
                String price = elements1.get(i).getElementsByTag("span").text();
                id++;
                idSkinCare.add(id);
                nameSkinCare.add(name);
                priceSkinCare.add(price);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
