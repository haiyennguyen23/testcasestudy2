package crawlsData;

import model.Makeup;
import model.SkinCare;

import java.util.ArrayList;

public class NewDataCosmetic {
    private CrawlsDataSkinCare crawlsDataSkinCare = new CrawlsDataSkinCare();
    private CrawlsDataMakeup crawlsDataMakeup = new CrawlsDataMakeup();

    public NewDataCosmetic() {
        crawlsDataSkinCare.getData();
        crawlsDataMakeup.getData();
    }

    public ArrayList<SkinCare> newListSkinCare(){
        ArrayList<SkinCare> skinCareArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsDataSkinCare.getNameSkinCare();
        ArrayList<String> priceList = crawlsDataSkinCare.getPriceSkinCare();
        ArrayList<Integer> idList = crawlsDataSkinCare.getIdSkinCare();
        for (int i = 0; i < nameList.size(); i++) {
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            String name = nameList.get(i);
            int id = idList.get(i);
            SkinCare skinCare = new SkinCare(id, name, price);
           skinCareArrayList.add(skinCare);
        }
        return skinCareArrayList;
    }
    public ArrayList<Makeup> newListMakeup(){
        ArrayList<Makeup> makeupArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsDataMakeup.getNameMakeup();
        ArrayList<String> priceList = crawlsDataMakeup.getPriceMakeup();
        int id = 10;
        for (int i = 0; i < nameList.size(); i++) {
            double price = Double.parseDouble(priceList.get(i).replaceAll("₫","").trim());
            id= id + 1;
            String name = nameList.get(i);
            Makeup makeup = new Makeup(id, name, price);
            makeupArrayList.add(makeup);
        }
        return makeupArrayList;
    }
    }

