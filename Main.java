import java.util.*;
public class Main
{
    public static final Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        Generatepassword genp = new Generatepassword(input);
        genp.mainfunc();
        input.close();

    }
}