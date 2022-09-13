package account;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountAdmin  implements Serializable {
    private String accountName;
    private String password;
    private final ArrayList<AccountAdmin> accountAdmins = new ArrayList<>();

    public AccountAdmin(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }
    public String getAdminAcc() {
        return accountName;
    }

    public String getAdminPass() {
        return password;
    }
    public AccountAdmin() {
        accountAdmins.add(new AccountAdmin("ADMIN","123456"));
        accountAdmins.add(new AccountAdmin("ADMIN1","123456"));
    }
    public ArrayList<AccountAdmin> getAdminAccountList() {
        return accountAdmins;
    }

    @Override
    public String toString() {
        return "AccountAdmin{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
