package view;

import serviceManager.CosmeticFacade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
    public static void main(String[] args) {
        RunByAdmin runByAdmin =new RunByAdmin();
        runByAdmin.menuCosmeticOfAdmin();
    }
    private final Scanner scanner = new Scanner(System.in);
    private final CosmeticFacade cosmeticFacade = CosmeticFacade.getInstance();
    public RunByAdmin() {
    }
    public void menuCosmeticOfAdmin() {
        try {
            do{
                System.out.println("╔************************************************************╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG ADMIN █ ▆ ▅ ▃ ▂            ║");
                System.out.println("╠************************************************************╣");
                System.out.println("║>[1]. Thêm sản phẩm                                         ║");
                System.out.println("║>[2]. Sửa thông tin                                         ║");
                System.out.println("║>[3]. Xóa sản phẩm                                          ║");
                System.out.println("║>[4]. Hiển thị sản phẩm                                     ║");
                System.out.println("║>[5]. Khôi phục dữ liệu                                     ║");
                System.out.println("║>[6]. Tìm kiếm sản phẩm theo id                             ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚************************************************************╝");
                System.out.println("Mời bạn vui lòng chọn chức năng");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        menuAddCosmetic();
                        break;
                    case 2:
                        try {
                            System.out.println("Nhập id sản phẩm muốn sửa");
                            int id = Integer.parseInt(scanner.nextLine());
                            if (cosmeticFacade.checkID(id)){
                                editCosmetic(id);
                                System.out.println("Thông tin sản phẩm mỹ phẩm đã được cập nhật");
                            }else {
                                System.out.println("Không tìm thấy sản phẩm trong danh sách của cửa hàng");
                                System.out.println("---------------------------------------");
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Sai kiểu dữ liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 3:
                        deleteCosmetic();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        System.out.println("Bạn vui lòng đợi trong giây lát");
                        cosmeticFacade.backUpData();
                        break;
                    case 6:
                        System.out.println("Mời bạn vui lòng nhập id sản phẩm bạn muốn tìm");
                        int id = Integer.parseInt(scanner.nextLine());
                        cosmeticFacade.findCosmetictById(id);
                        break;

                    case 0:
                        System.out.println("Bạn đã thoát khỏi hệ thống Admin");
                        System.out.println("---------------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("Không có lựa chọn phù hợp");
                        break;

                }
            }while (true);
        }catch (Exception e){
            System.out.println("Bạn đã nhập sai dữ liệu, mời bạn vui lòng nhập lại dữ liệu!!!");
            System.out.println("-----------------------------------");
            menuCosmeticOfAdmin();
        }
    }
    public void menuAddCosmetic(){
        try {
            do{
                System.out.println("╔===========================================╗");
                System.out.println("║ ▂ ▃ ▅ ▆ █ THÊM SẢN PHẨM MỸ PHẨM █ ▆ ▅ ▃ ▂ ║");
                System.out.println("╠===========================================╣");
                System.out.println("║>[1]. Mỹ phẩm chăm sóc da                  ║");
                System.out.println("║>[2]. Mỹ phẩm trang điểm                   ║");
                System.out.println("║>[0]. Thoát                                ║");
                System.out.println("╚===========================================╝");
                System.out.println("Mời bạn chọn chức năng: ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                if (choiceAdd == 0) {
                    break;
                } else if (choiceAdd < 0 || choiceAdd > 3) {
                    System.out.println("Bạn đã chọn sai lựa chọn mời bạn vui lòng chọn lại");
                    menuAddCosmetic();
                }
                System.out.println("Nhập id sản phẩm:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập tên sản phẩm: ");
                String name = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm: ");
                double price = Double.parseDouble(scanner.nextLine());
                if (!cosmeticFacade.checkID(id)){
                    cosmeticFacade.add(id, name, price, choiceAdd);
                    System.out.println("Thêm sản phẩm thành công vào danh sách");
                }else {
                    System.out.println("Sản phẩm đã bị trùng id mời bạn chọn id mới");
                    System.out.println("--------------------------");
                }
                break;
            }while (true);
        }catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu, vui lòng nhập lại");
            System.out.println("---------------------------------------");
            menuAddCosmetic();
        }
    }
    public void editCosmetic(int id) {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █  SỬA SẢN PHẨM   █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Sửa tên                              ║");
            System.out.println("║>[2]. Sửa giá                              ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            display();
            System.out.println("Mời bạn chọn chức năng: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            cosmeticFacade.edit(id, choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu, vui lòng nhập lại");
            System.out.println("------------------------------------");
            editCosmetic(id);
        }
    }
    public void deleteCosmetic() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █ XOÁ SẢN PHẨM  █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Xóa sản phẩm theo ID                 ║");
            System.out.println("║>[2]. Xóa tất cả sản phẩm                  ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("Mời bạn chọn chức năng");
            int choiceAdd = Integer.parseInt(scanner.nextLine());

            switch (choiceAdd) {
                case 1:
                    System.out.println("Mời bạn nhập mã id");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (cosmeticFacade.checkID(id)) {
                        cosmeticFacade.delete(id);
                        System.out.println("Xoá thành công");
                        System.out.println("--------------------------------------");
                    } else {
                        System.out.println("Không có mã id trên");
                        System.out.println("---------------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("Bạn có chắc chắn muốn xoá hết dữ liệu");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")){
                        cosmeticFacade.deleteAll();
                        System.out.println("Đã xoá hết dữ liệu");
                        System.out.println("-----------------------");
                    }else {
                        break;
                    }
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Sai lựa chọn");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu vui lòng nhập lại");
            System.out.println("-------------------------------");
            deleteCosmetic();
        }
    }
    public void display() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║  ▂ ▃ ▅ ▆ █ HIỂN THỊ SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Tất cả sản phẩm                      ║");
            System.out.println("║>[2]. Mỹ phẩm chăm sóc da                  ║");
            System.out.println("║>[3]. Mỹ phẩm chăm trang điểm              ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.println("Mời bạn chọn chức năng");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            cosmeticFacade.displayChoice(choiceAdd);
        }catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu vui lòng nhập lại");
            System.out.println("-------------------------------");
            display();
        }
    }


}
