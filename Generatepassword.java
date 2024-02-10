import java.util.*;
public class Generatepassword {
    Alphabet alpha;
    public static Scanner input;
    public Generatepassword(Scanner scanner)
    {
        input=scanner;
    }
    public Generatepassword(boolean IncludeUpper ,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym )
    {
        alpha = new Alphabet(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);

    }
    public void mainfunc()
    {
        System.out.println("Welcome to Jigbee Password Services:");
        displaymenu();
        while (true) 
        {
            int ch= input.nextInt();
            switch (ch) 
            {
                case 1:
                reqpassword();
                displaymenu();
                    break;
                case 2:
                checkpassword();
                displaymenu();
                    break;

                case 3:
                printinfo();
                displaymenu();
                    break;
                case 4:
                printquit();
                    break;
                default:
                System.out.println("Kindly select correct option");
                displaymenu();
                    break;
            }
            
        }
    }
    private void displaymenu()
    {
        System.out.println();
        System.out.println(" 1 - Password Generator");
        System.out.println(" 2 - Password Strength Check");
        System.out.println(" 3 - Useful Information");
        System.out.println(" 4 - Quit");
        System.out.print("Option:");
    }
    private void printquit()
    {
        System.out.println("Closing the program :)");
    }
    private void reqpassword()
    {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum= false;
        boolean IncludeSym= false;

        boolean cp;
        System.out.println();
        System.out.println("\"Hello, welcome to the Password Generator :) answer\"\r\n" + //
                        "                + \" the following questions by Yes or No \\n" + //
                        "\"");
        do 
        {
            String inp;
            cp= false;
            do
            {
                System.out.println("Do you Want to Include Lowercase Letters\"abcd..\" to be Used? ");
                inp = input.next();
                passwordreqerror(inp);
            }
            while(!inp.equalsIgnoreCase("yes") && !inp.equalsIgnoreCase("no"));
            if(isinclude(inp)) IncludeLower= true;
            do
            {
                System.out.println("Do you Want to Include Uppercase Letters\"ABCD..\" to be Used? ");
                inp = input.next();
                passwordreqerror(inp);

            }
            while(!inp.equalsIgnoreCase("yes") && !inp.equalsIgnoreCase("no"));
            if(isinclude(inp)) IncludeUpper= true;
            do
            {
                System.out.println("Do you Want to Include Numbers\"1234..\" to be Used? ");
                inp = input.next();
                passwordreqerror(inp);

            }
            while(!inp.equalsIgnoreCase("yes") && !inp.equalsIgnoreCase("no"));
            if(isinclude(inp)) IncludeNum= true;
            do
            {
                System.out.println("Do you Want to Include Symbols\"@$_..\" to be Used? ");
                inp = input.next();
                passwordreqerror(inp);

            }
            while(!inp.equalsIgnoreCase("yes") && !inp.equalsIgnoreCase("no"));
            if(isinclude(inp)) IncludeSym= true;

            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                cp = true;
            }

        }
        while (cp);
        System.out.println("Great! Now enter the length of the password");
        int length = input.nextInt();
        final Generatepassword genp = new Generatepassword(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password password = genp. gp(length);
        System.out.println("Your Generated Password ->"+ password);

    }
    private boolean isinclude(String inp)
    {
        if(inp.equalsIgnoreCase("yes"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private void passwordreqerror(String i)
    {
        if(!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no"))
        {
            System.out.println("You have entered something incorrect let's go over it again \n");
        }
    }
    private void checkpassword()
    {
        String str;
        System.out.println("Enter your password:");
        str=input.next();
        final Password p = new Password(str);
        System.out.println(p.calcscore());
    }
    private void printinfo()
    {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");

    }
    private Password gp(int length)
    {
        final StringBuilder pass = new StringBuilder("");
        final int aplen = alpha.getAlphabet().length();
        int max=aplen-1;
        int min =0;
        int range = max-min+1;
        for(int i=0;i<length;i++)
        {
            int index=(int)(Math.random()*range)+min;
            pass.append(alpha.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }

}
