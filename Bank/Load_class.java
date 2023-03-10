package Bank;
import java.io.*;
import java.util.StringTokenizer;

public class Load_class {
    String name;
    String passcode;
    public Load_class(String name,String passcode)
    {
        this.name = name;
        this.passcode = passcode;
    }
    public Accounts get_user() throws IOException {
        Accounts acc[] = new Accounts[15];
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Bank\\Accounts.txt"));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            String userId = tokenizer.nextToken();
            String password = tokenizer.nextToken();
            String balance = tokenizer.nextToken();

            if (name.equals(userId) && password.equals(password)) {
                System.out.println("Logged in successfully.");
                acc[i] =  new Accounts(name,passcode,Integer.parseInt(balance));
                i = i + 1;

            }
        }
        reader.close();
        return acc[acc.length-1];
    }
}
