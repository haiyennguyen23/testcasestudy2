package login;

import account.AccountAdmin;
import validate.Validate;
import view.Main;
import view.RunByAdmin;
import view.RunByUser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private Scanner scanner = new Scanner(System.in);
    private RunByAdmin runByAdmin = new RunByAdmin();
    private RunByUser runByUser = new RunByUser();
    private AccountAdmin accountAdmin = new AccountAdmin();
    private Validate validate = new Validate();
    public Main loginSystem(){
        try{
            menuLogin();
        } catch (Exception e){
            System.out.println("Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            loginSystem();
        }
        return null;
    }
    public void menuLogin() throws NumberFormatException {
        do {
            System.out.println("╔============================================╗");
            System.out.println("║   ▂ ▃ ▅ ▆ █   MỸ PHẨM KOREA   █ ▆ ▅ ▃ ▂    ║");
            System.out.println("╠============================================╣");
            System.out.println("║>[1]. ĐĂNG NHẬP ADMIN                       ║");
            System.out.println("║>[2]. TẠO TÀI KHOẢN USER                    ║");
            System.out.println("║>[0]. THOÁT                                 ║");
            System.out.println("╚============================================╝");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    loginManager();
                    break;
                case 2:
                    System.out.println("Tạo tài khoản đăng nhập với danh nghĩa user");
                    accountUser();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại");
                    break;
            }
        } while (true);
    }
    public void loginManager() throws InputMismatchException {
        System.out.println("ĐĂNG NHẬP");
        System.out.println("Nhập tài khoản");
        String account = scanner.nextLine();
        System.out.println("Nhập mật khẩu");
        String password = scanner.nextLine();
        checkAccount(account, password);
    }
    public void checkAccount(String account, String password) {
        try {
            if (checkLoginAccountAdmin(account, password)) {
                System.out.println("Đặng nhập hệ thống bởi ADMIN thành công");
                runByAdmin.menuCosmeticOfAdmin();
            } else {
                System.out.println("Sai thông tin tài khoản hoặc mật khẩu");
                loginManager();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Đăng nhập thất bại. Vui lòng đăng nhập lại !!!");
            System.out.println("-------------------------------------------------------");
            loginSystem();
        }
    }
    public boolean checkLoginAccountAdmin(String account, String password) {
        for (AccountAdmin accAdmin : accountAdmin.getAdminAccountList()) {
            boolean checkAccountAdmin = account.equals(accAdmin.getAdminAcc()) && password.equals(accAdmin.getAdminPass());
            if (checkAccountAdmin) {
                return true;
            }
        }
        return false;
    }
    public void accountUser() {
        registerAccountName();
        registerPassword();
        System.out.println("Đăng nhập hệ thống bởi USER thành công");
        System.out.println("----------------------------------------------------------");
        runByUser.menuCosmeticOfUser();
    }
    public String registerAccountName() {
        String accountUser;
        while (true) {
            System.out.println("Nhập tài khoản: ");
            String account = scanner.nextLine();
            if (!validate.validateAccount(account)) {
                System.out.println("Tài khoản không hợp lệ");
                System.out.println(">[Chú ý]: Tài khoản phải từ 8 - 12 ký tự (a,1,...)");
                System.out.println("---------------------------------------------------");
            } else {
                accountUser = account;
                break;
            }
        }
        return accountUser;
    }
    public String registerPassword() {
        String passwordUser;
        while (true) {
            System.out.println("Nhập passwword: ");
            String password = scanner.nextLine();
            if (!validate.validatePassword(password)) {
                System.out.println("Mật khẩu không hợp lệ");
                System.out.println(">[Chú ý]: Mật khẩu phải từ 8 - 16 ký tự (a,A,1,...) hoặc ký tự đặc biệt");
                System.out.println("-----------------------------------------");
            } else {
                passwordUser = password;
                break;
            }
        }
        return passwordUser;
    }
}
