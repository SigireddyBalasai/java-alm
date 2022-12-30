package Buyer;
import Bank.Accounts;

import java.util.Scanner;

public class Register
{
    int id;

    String name;
    Accounts account;
    String Password;

    Register()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Enter you Name");
        name = input.next();
        System.out.println("Please Enter Your Password");
        Password = input.next();
        System.out.println("PLease Enter your account number");

    }
}
