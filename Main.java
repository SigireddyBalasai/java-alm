import java.io.IOException;
import java.util.*;
import Bank.Accounts;
import Bank.Load_class;
class Main {
  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter your choice");
    int i = 0;
    Accounts a1 = null;
    System.out.println("1.Create account\n2.Update Account\n3.Enter Balnce\n4.check Balance");
    i = input.nextInt();
    while(true)
      {
        switch (i)
        {
          case 1:
          {
            System.out.println("Please Enter The name1");
            String name = input.next();
            System.out.println("Please Enter the Password");
            String passcode = input.next();
            //System.out.println("The name is "+name+"and password is"+passcode);
            a1 = new Load_class(name,passcode).get_user();
            System.out.println(a1);
            if(a1 != null)
            {
              System.out.println(a1.toString());
            }
            else
            {
              System.out.println("New account Creating");
              a1 = new Accounts(name,passcode);
            }
            break;
          }
          case 2:
          {
            System.out.println("Please Enter The balance");
            a1.setBalance(input.nextInt());
            break;
          }
          case 3 :
          {
            System.out.println("The value is" + a1.getBalance());
            break;
          }
        }
        System.out.println("1.Create account\n2.Update Account\n3.Enter Balnce\n4.check Balance");
        i = input.nextInt();
      }
  }
}