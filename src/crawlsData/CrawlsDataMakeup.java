package crawlsData;

import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataMakeup {
    private final String url = "https://hasaki.vn/";
    private ArrayList<String> nameMakeup = new ArrayList<>();
    private ArrayList<String> priceMakeup = new ArrayList<>();
    public CrawlsDataMakeup() {
    }
    public ArrayList<String> getNameMakeup() {
        return nameMakeup;
    }
    public ArrayList<String> getPriceMakeup() {
        return priceMakeup;
    }
    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("name product-title");
            ArrayList<Element> elements1 = doc.getElementsByClass("woocommerce-Price-amount amount");
            for (int i = 1; i <=5 ; i++) {
                nameMakeup.add(elements.get(i).getElementsByTag("a").text());
                priceMakeup.add(elements1.get(i).getElementsByTag("span").text());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
