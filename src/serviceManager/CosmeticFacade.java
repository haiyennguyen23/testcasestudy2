package serviceManager;

import model.Cosmetic;
import model.Makeup;
import model.SkinCare;

import java.util.ArrayList;
import java.util.Scanner;

public class CosmeticFacade {
    private CosmeticsManager cosmeticsManager;
    private SkinCareManager skinCareManager;
    private MakeupManager makeupManager;
    private static CosmeticFacade instance;
    private final Scanner scanner = new Scanner(System.in);
    private CosmeticFacade() {
        cosmeticsManager = new CosmeticsManager();
        skinCareManager = new SkinCareManager();
        MakeupManager MakeupManager = new MakeupManager();

    }

    public synchronized static CosmeticFacade getInstance(){
        if (instance == null){
            instance = new CosmeticFacade();
        }
        return instance;
    }
    public void add(int id, String name, double price, int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                SkinCare skinCare = new SkinCare(id, name, price);
                SkinCare.add(skinCare);
                cosmeticsManager.add(skinCare);
                break;
            case 2:
                Makeup makeup = new Makeup(id, name, price);
                makeupManager.add(makeup);
                cosmeticsManager.add(makeup);
                break;
        }
    }
    public void displayChoice(int choice) {
        switch (choice) {
            case 1:
                cosmeticsManager.display();
                break;
            case 2:
                skinCareManager.display();
                break;
            case 3:
                makeupManager.display();
                break;
            case 0:
                System.out.println("Quay lại");
                break;
            default:
                System.out.println("Sai lựa chọn");
                break;
        }
    }
    public void delete(int id) {
        cosmeticsManager.delete(id);
        skinCareManager.delete(id);
        makeupManager.delete(id);
    }
    public void deleteAll(){
        cosmeticsManager.deleteAll();
        skinCareManager.deleteAll();
        makeupManager.deleteAll();
    }
    public void edit(int id, int choiceAdd) {
        switch (choiceAdd){
            case 1:
                System.out.println("nhap ten moi");
                String name = scanner.nextLine();
                cosmeticsManager.editName(id, name);
                skinCareManager.editName(id, name);
                makeupManager.editName(id, name);
                break;
            case 2:
                System.out.println("nhap gia moi");
                double price = scanner.nextDouble();
                cosmeticsManager.editPrice(id, price);
                skinCareManager.editPrice(id, price);
                makeupManager.editPrice(id, price);
                break;

        }
    }
    public boolean checkID(int id) {
        for (Cosmetic p : cosmeticsManager.getCosmeticArrayList()) {
            if (p.getId() == id) {
                return true;
            }
        }
        for (SkinCare p:
                skinCareManager.getSkinCareArrayList()) {
            if (p.getId() == id)
                return true;
        }
        for (Makeup p:
                makeupManager.getMakeupArrayList()) {
            if (p.getId() == id)
                return true;
        }
        return false;
    }

    public void backUpData() {
        cosmeticsManager.setListCosmetic();
        System.err.println("Khôi phục dữ liệu thành công");
        System.out.println("-----------------------------------------------------------------");
    }

    public Cosmetic findCosmetictById(int id){
        Cosmetic cosmetic = null;
        for (Cosmetic p: cosmeticsManager.getCosmeticArrayList()) {
            if(p.getId() == id) {
                cosmetic = p;
                break;
            }
        }
        if (cosmetic != null){
            System.out.println(cosmetic);
        }else {
            System.out.println("Không tìm thấy sản phẩm cần tìm");
        }

        return cosmetic;
    }
    public void searching() {
        System.out.println("Nhập tên sản phẩm cần tìm");
        String newName = scanner.nextLine();
        ArrayList<Cosmetic> list = cosmeticsManager.findProductByKey(newName);
        if (list.isEmpty()) {
            System.out.println("Không có sản phẩm cần tìm");
        }else {
            for (Cosmetic x:
                    list) {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        CosmeticFacade cosmeticFacade = new CosmeticFacade();
        cosmeticFacade.searching();
    }

}
