package Buyer;
import Bank.Accounts;

import java.io.*;
public class BuyerAccount{
    String name;
    public Accounts account;
    String passcode;

    public BuyerAccount(String name, String passcode) {
        this.name = name;
        this.account = new Accounts(name,passcode);
        this.passcode = passcode;
    }

    public BuyerAccount(String name, String passcode, Accounts account) {
        this.name = name;
        this.account = account;
        this.passcode = passcode;
    }
    public String getUsername()
    {
        return this.name;
    }
    public void commit() throws IOException {
        FileWriter fileOut = new FileWriter("Buyer/Accounts.txt", true);
        BufferedWriter Out = new BufferedWriter(fileOut);
        try {
            Out.write(this.name + "," + this.passcode + "," + this.account.getBalance());
            Out.newLine();
            Out.close();
            fileOut.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String toString() {
        return "Name is " + this.name + " and Password is" + passcode;
    }


    public void setPasscode(String old, String passcode) throws Wrong_password {
        if (this.passcode == old) {
            this.passcode = passcode;
        } else {
            throw new Buyer.Wrong_password();
        }
    }


}
