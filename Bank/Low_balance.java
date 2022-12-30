package Bank;

public class Low_balance extends Exception
{
    Low_balance()
    {
        super("Low Balance to do Transaction");
    }
}
