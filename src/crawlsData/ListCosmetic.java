package crawlsData;

import model.Makeup;
import model.SkinCare;

import java.util.ArrayList;
import java.util.List;

public class ListCosmetic {
    private final FileBinary<SkinCare> skinCareFileBinary;
    private final FileBinary<Makeup> makeupFileBinary;
    private NewDataCosmetic newDataCosmetic;
    public ListCosmetic() {
        skinCareFileBinary =new FileBinary<>();
        makeupFileBinary =new FileBinary<>();
        newDataCosmetic = new NewDataCosmetic();
    }
    public ArrayList<SkinCare> setListCosmetic() {
        ArrayList<SkinCare> ListSkinCare = newDataCosmetic.newListSkinCare();
        skinCareFileBinary.writerFile(listSkinCare, "FileDataSkinCare");
        return listSkinCare;
    }
    public ArrayList<Makeup> setListMakeup() {
        ArrayList<Makeup> listMakeup = newDataCosmetic.newListMakeup();
        makeupFileBinary.writerFile(listMakeup,"FileDataMakeup");
        return listMakeup;
    }
    public ArrayList<SkinCare> getListSkinCare() {
        return skinCareFileBinary.readFile("FileDataSkinCare");
    }
    public ArrayList<Makeup> getListMakeup() {
        return makeupFileBinary.readFile("FileDataMakeup");
    }
    public static void main(String[] args) {
        ListCosmetic listCosmetic = new ListCosmetic();
        listCosmetic.setListSinCare();
        listCosmetic.getListSkinCare();
        listCosmetic.setListMakeup();
        listCosmetic.getListMakeup();
    }
}
