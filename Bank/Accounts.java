package Bank;
import java.io.*;
public class Accounts{
  String name;
  int balance;
  String passcode;

  public Accounts(String name, String passcode)
  {
    this.name = name;
    this.balance = 0;
    this.passcode = passcode;
  }
  public Accounts(String name, String passcode, int balance)
  {
    this.name = name;
    this.balance = balance;
    this.passcode = passcode;
  }
  public void commit() throws IOException {
    FileWriter fileOut = new FileWriter("C:\\Users\\Balasai\\IdeaProjects\\java-alm\\Bank\\Accounts.txt",true);
    BufferedWriter Out = new BufferedWriter(fileOut);
    try
    {
      Out.write(this.name+","+this.passcode+","+this.balance);
      Out.newLine();
      Out.close();
      fileOut.close();
    }
    catch (Exception e)
    {
      e.getStackTrace();
    }
  }

  public String toString() {
    return "Name is "+this.name+ " and Password is"+passcode;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public void setPasscode(String old, String passcode) throws Bank.Wrong_password {
    if (this.passcode == old) {
      this.passcode = passcode;
    } else {
      throw new Bank.Wrong_password();
    }
  }
  public void transfer(Accounts Sender, Accounts Reciver, int amount, String passcode) throws Wrong_password, Low_balance {
    if (Sender.balance < amount) {
      throw new Bank.Low_balance();
    }
    if (Sender.passcode == passcode) {
      throw new Bank.Wrong_password();
    }
    Sender.balance -= amount;
    Reciver.balance += amount;
  }

  public void transfer(Accounts Sender, int amount, String passcode) throws Wrong_password, Low_balance {
    if (Sender.balance < amount) {
      throw new Bank.Low_balance();
    }
    if (Sender.passcode == passcode) {
      throw new Bank.Wrong_password();
    }
    Sender.balance -= amount;
  }

}
