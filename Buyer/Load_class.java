package Buyer;
import Bank.Accounts;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Load_class {
    String name;
    String passcode;
    public Load_class(String name, String passcode)
    {
        this.name = name;
        this.passcode = passcode;
    }
    public BuyerAccount get_user() throws IOException {
        BuyerAccount buy_acc[] = new BuyerAccount[15];
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Buyer\\Accounts.txt"));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            String userId = tokenizer.nextToken();
            String password = tokenizer.nextToken();
            String balance = tokenizer.nextToken();
            if (name.equals(userId) && password.equals(password)) {
                System.out.println("Logged in successfully.");
                Bank.Load_class lc = new Bank.Load_class(userId,password);
                Accounts la = lc.get_user();

                buy_acc[i] = new BuyerAccount(userId,password,la);
                i = i + 1;;
            }
        }
        reader.close();
        return buy_acc[buy_acc.length -1];
    }
}
