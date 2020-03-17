package server;

public class Main
{
    public static void main(String[] args)
    {
        // 1 Attempt to connect to Database
        // 1.1 Gather required data to connect to database from db.props

        PropsParser propsParser;

        try
        {
            propsParser = new PropsParser("./resources/db.props");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
