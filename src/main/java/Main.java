import java.util.*;

public class Main {

    static void sepl(){System.out.println("-".repeat(80));}
    static List<String> currencies = new ArrayList();
    static String leaveInput = "next";
    static Scanner scanner = new Scanner(System.in);
    static List<String> longTrades = new ArrayList();
    static List<String> shortTrades = new ArrayList();
    static {
        currencies.add("EUR");
        currencies.add("GBP");
        currencies.add("NZD");
        currencies.add("AUD");
        currencies.add("USD");
        currencies.add("CAD");
        currencies.add("CHF");
        currencies.add("JPY");
    }

    static boolean checkCurr(String currency){              //method for checking if the currency is existing
        for (int i = 0; i < currencies.size(); i++){
            if (currency.toUpperCase(Locale.ROOT).equals(currencies.get(i)))
                return true;
        }
        return false;
    }

    static String getInput(){               //method for getting the correct Input
        boolean check = true;
        String input;
        do {
            System.out.print("$ ");
            input = scanner.nextLine();
            if (input.length() < 6 && !(input.equals(leaveInput)))//check if the input is long enough or the word to leave input
                System.out.println("not possible to trade idiot!");
            else
                check = false;

        }while (check);
        return input;
    }

    static void getTrades(String dir){              //method for tracking the trades
        System.out.println(dir + " Trades");
        String input;
        boolean check = true;
        while (check){
            input = getInput();
            if (input.equals(leaveInput)){break;}       //if input is leaving word, break and exit of input
            boolean first = checkCurr(input.substring(0,3));
            boolean second = checkCurr(input.substring(3,6));
            if (first && second){  //if both currencies are correct, add the pair to the long or short list
                if (dir.equals("Long"))
                    longTrades.add(input.toUpperCase(Locale.ROOT));
                else
                    shortTrades.add(input.toUpperCase(Locale.ROOT));
            }else
                System.out.println("Currency not existing!");
        }
    }

    public static void main(String[] args) {

        sepl();System.out.println("    Forex Hedge Checker");sepl();
        //getting the trades
        getTrades("Long");
        getTrades("Short");
        //temporary output to check
        System.out.println("Longis: ");
        for (int i = 0; i < longTrades.size(); i++)
            System.out.println(longTrades.get(i));

        System.out.println("Shortis: ");
        for (int i = 0; i < shortTrades.size(); i++)
            System.out.println(shortTrades.get(i));


        scanner.close();
    }
}
