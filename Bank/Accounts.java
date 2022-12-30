package Bank;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
public class Accounts {
  String name;
  int balance;
  String passcode;

  public Accounts(String name, String passcode) throws IOException {
    this.name = name;
    this.balance = 0;
    this.passcode = passcode;
    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\sigir\\Downloads\\java-alm\\Bank\\Accounts.txt",true);
    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
    try
    {
      objectOut.writeObject(this);
      objectOut.close();
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
