package view;

import login.Login;
import model.Cosmetic;
import serviceManager.CosmeticFacade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    public static void main(String[] args) {
        RunByUser run = new RunByUser();
        run.menuCosmeticOfUser();
    }
    private final Scanner scanner = new Scanner(System.in);
    private final CosmeticFacade cosmeticFacade = CosmeticFacade.getInstance();
    private final RunByAdmin runByAdmin = new RunByAdmin();
    private ArrayList<Cosmetic> listCart = new ArrayList<>();

    public RunByUser() {
    }
    public void menuCosmeticOfUser() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Hiển thị sản phẩm trong shop                          ║");
                System.out.println("║>[2]. Tìm kiếm sản phẩm trong shop theo tên                 ║");
                System.out.println("║>[3]. Thêm sản phẩm vào giỏ hàng                            ║");
                System.out.println("║>[4]. Xóa sản phẩm khỏi giỏ hàng                            ║");
                System.out.println("║>[5]. Hiển thị sản phẩm trong giỏ hàng                      ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.println("Mời bạn chọn chức năng");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        runByAdmin.display();
                        break;
                    case 2:
                        cosmeticFacade.searching();
                        break;
                    case 3:
                        runByAdmin.display();
                        addCosmeticToCart();
                        break;
                    case 4:
                        displayCart();
                        removeCosmeticFromCart();
                        break;
                    case 5:
                        displayCart();
                        break;
                    case 0:
                        System.out.println("Đã thoát khỏi hệ thống user");
                        System.out.println("----------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("Nhập sai lựa chọn, thử lại");
                        break;

                }
            }while (true);
        }catch (Exception e) {
            System.out.println("Nhập sai lựa chọn, thử lại");
            menuCosmeticOfUser();
        }
    }
    public void addCosmeticToCart() {
        try {
            System.out.print("Nhap mã san phẩm vào giỏ hàng");
            int id = Integer.parseInt(scanner.nextLine());
            Cosmetic cosmetic = cosmeticFacade.findCosmetictById(id);
            if (cosmetic == null) {
                System.out.println("Không đúng mã sản phẩm");
            } else {
                listCart.add(cosmetic);
                System.out.println("Đã thêm sản phẩm vào giỏ hàng");
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            addCosmeticToCart();
        }
    }
    public void displayCart() {
        if (listCart.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào trong giỏ hàng");
        } else {
            for (Cosmetic x:
                    listCart) {
                System.out.println(x);
            }
        }
    }
    public void removeCosmeticFromCart() {
        try {
            if (listCart.isEmpty()) {
                System.out.println("Giỏ hàng trống rỗng");
            } else {
                System.out.print("Nhập id của sản phẩm bạn muốn xoá trong giỏ hàng");
                int idCheck = Integer.parseInt(scanner.nextLine());
                boolean check = listCart.removeIf(p -> p.getId() == idCheck);
                if (!check) {
                    System.out.println("Không có sản phẩm có mã ID trên trong giỏ hàng");
                } else {
                    System.out.println("Đã xóa sản phẩm thành công khỏi giỏ hàng");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            addCosmeticToCart();
        }
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Cosmetic x : listCart) {
            totalPrice += x.getPrice();
        }
        return totalPrice;
    }

}
