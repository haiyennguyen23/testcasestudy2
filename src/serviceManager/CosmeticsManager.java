package serviceManager;

import model.Cosmetic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CosmeticsManager implements CosmeticManager<Cosmetic>{
    private static final String FILE_DATA_PRODUCT ="FileDataProduct";
    private ArrayList<Cosmetic> cosmeticArrayList;
    private FileBinary<Cosmetic> cosmeticFileBinary = new FileBinary<>();

    public CosmeticsManager() {
        if(!new File(FILE_DATA_PRODUCT).exists()){
            try{
                new File(FILE_DATA_PRODUCT).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(new File(FILE_DATA_PRODUCT).length()==0){
            cosmeticArrayList = new ArrayList<>();
        }else{
            cosmeticArrayList = cosmeticFileBinary.readFile(FILE_DATA_PRODUCT);
        }
    }

    public void setCosmeticArrayList() {
     ListCosmetic listCosmetic = new LisCosmetic();
     cosmeticArrayList.addAll(listCosmetic.setListSkinCare());
     cosmeticArrayList.addAll(listCosmetic.setListMakeup());
     cosmeticFileBinary.writerFile(cosmeticArrayList,FILE_DATA_PRODUCT);
    }
    public void getListCosmetic() {
        cosmeticFileBinary.readFile(FILE_DATA_PRODUCT);
    }
    public ArrayList<Cosmetic> getCosmeticArrayList() {
        return cosmeticArrayList;
    }
    @Override
    public void display() {
        if(cosmeticArrayList.isEmpty()){
            System.out.println("Chưa có thông tin sản phẩm nào");
        }else {
            cosmeticArrayList=cosmeticFileBinary.readFile(FILE_DATA_PRODUCT);
            for (Cosmetic x:
                    cosmeticArrayList){
                System.out.println(x);
            }
        }
    }

    @Override
    public void delete(int id) {
        cosmeticArrayList.removeIf(x->x.getId()==id);
        cosmeticFileBinary.writerFile(cosmeticArrayList,FILE_DATA_PRODUCT);
    }

    @Override
    public void deleteAll() {
        cosmeticArrayList.clear();
        cosmeticFileBinary.writerFile(cosmeticArrayList,FILE_DATA_PRODUCT);
    }

    @Override
    public void add(Cosmetic cosmetic) {
        cosmeticArrayList.add(cosmetic);
        cosmeticFileBinary.writerFile(cosmeticArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void editName(int id, String name) {
        for (int i = 0; i < cosmeticArrayList.size(); i++) {
            if ((cosmeticArrayList.get(i).getId())==id){
                cosmeticArrayList.get(i).setName(name);
            }
        }
        cosmeticFileBinary.writerFile(cosmeticArrayList, FILE_DATA_PRODUCT);
    }

    @Override
    public void editPrice(int id, double price) {
        for (int i = 0; i < cosmeticArrayList.size(); i++) {
            if ((cosmeticArrayList.get(i).getId())==id){
                cosmeticArrayList.get(i).setPrice(price);
            }
        }
        cosmeticFileBinary.writerFile(cosmeticArrayList, FILE_DATA_PRODUCT);
    }
    private boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }
    public ArrayList<Cosmetic> findProductByKey(String keyword){
        ArrayList<Cosmetic> listBySearch = new ArrayList<>();
        for (Cosmetic p: cosmeticArrayList) {
            if(checkKey(keyword,p.getName())) {
                listBySearch.add(p);
            }
        }
        return listBySearch;
    }
}
