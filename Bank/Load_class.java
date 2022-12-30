package Bank;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load_class {
    String name;
    String passcode;
    public Load_class(String name,String passcode)
    {
        this.name = name;
        this.passcode = passcode;
    }
    public Accounts get_user() throws IOException{
        Accounts array[] = new Accounts[100];
        try {
            FileInputStream input = new FileInputStream("C:\\Users\\sigir\\Downloads\\java-alm\\Bank\\Accounts.txt");
            ObjectInputStream objectin = new ObjectInputStream(input);
            int i = 0;
            while(true)
            {
                try
                {
                    array[i] = (Accounts)objectin.readObject();
                    System.out.println(array);
                }
                catch(Exception e)
                {
                    break;
                }
                i = i + 1;

            }
            System.out.println(array);
            System.out.println(i);
            for (Accounts accounts : array) {
                if ((accounts.name == name) && (accounts.passcode == passcode)) {
                    return accounts;
                }
            }
        }
        catch (Exception e)
        {
            e.getStackTrace();
        }

        return null;
    }
}
