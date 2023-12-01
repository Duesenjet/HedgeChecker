import java.util.*;

public class Main {
    public static void main(String[] args) {
        sepl();
        System.out.println("    Forex Hedge Checker");
        sepl();
        //getting the trades
        getTrades("Long");
        getTrades("Short");
        //temporary output to check
        sepl();
        System.out.println("Longis: \n");
        for (int i = 0; i < longTrades.size(); i++)
            System.out.println(longTrades.get(i));

        System.out.println();
        System.out.println("Shortis: \n");
        for (int i = 0; i < shortTrades.size(); i++)
            System.out.println(shortTrades.get(i));

        hedgeChecker.hedgeCheck(longTrades, shortTrades);

        scanner.close();
    }
    static void sepl() {System.out.println("-".repeat(80));}

    static Currency currency = new Currency();                  //Currency object
    static HedgeChecker hedgeChecker = new HedgeChecker();      //Hedgechecker obejct
    static String leaveInput = "n";                                         //word that leads to next input
    static Scanner scanner = new Scanner(System.in);
    static List<String> longTrades = new ArrayList();
    static List<String> shortTrades = new ArrayList();

  
    static String getInput() {               //method for getting the correct Input
        boolean check = true;
        String input;
        do {
            System.out.print("$ ");
            input = scanner.nextLine();
            if (input.length() < 6 && !(input.equals(leaveInput)))//check if the input is long enough or the word to leave input
                System.out.println("not possible to trade idiot!");
            else
                check = false;
        } while (check);
        return input;
    }
    static void getTrades(String dir) {              //method for tracking the trades
        System.out.println(dir + " Trades");
        String input;
        boolean check = true;
        while (check) {
            input = getInput();
            if (input.equals(leaveInput)) {
                break;
            }       //if input is leaving word, break and exit from input
            boolean first = currency.checkCurr(input.substring(0, 3));
            boolean second = currency.checkCurr(input.substring(3, 6));
            if (first && second) {                       //if both currencies are correct, add the pair to the long or short list
                if (dir.equals("Long"))
                    longTrades.add(input.toUpperCase(Locale.ROOT));
                else
                    shortTrades.add(input.toUpperCase(Locale.ROOT));
            } else
                System.out.println("Currency not existing!");
        }
    }


}
