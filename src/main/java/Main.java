import java.util.*;

public class Main {

    static void sepl(){System.out.println("-".repeat(80));}
    static List<String> currencies = new ArrayList();
    static String leaveInput = "next";
    static Scanner scanner = new Scanner(System.in);
    static List<String> longTrades = new ArrayList();
    static List<String> shortTrades = new ArrayList();
    static int lAUD = 0;
    static int lGBP = 0;
    static int lNZD = 0;
    static int lEUR = 0;
    static int lUSD = 0;
    static int lCAD = 0;
    static int lCHF = 0;
    static int lJPY = 0;
    static int sAUD = 0;
    static int sGBP = 0;
    static int sNZD = 0;
    static int sEUR = 0;
    static int sUSD = 0;
    static int sCAD = 0;
    static int sCHF = 0;
    static int sJPY = 0;
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
            if (first && second){                       //if both currencies are correct, add the pair to the long or short list
                if (dir.equals("Long"))
                    longTrades.add(input.toUpperCase(Locale.ROOT));
                else
                    shortTrades.add(input.toUpperCase(Locale.ROOT));
            }else
                System.out.println("Currency not existing!");
        }
    }

    static void hedgeCheck(){

        for(int i = 0; i < longTrades.size(); i++){
            switch (longTrades.get(i).substring(0,3)){
                case "EUR": lEUR++; break;
                case "GBP": lGBP++; break;
                case "NZD": lNZD++; break;
                case "AUD": lAUD++; break;
                case "USD": lUSD++; break;
                case "CAD": lCAD++; break;
                case "CHF": lCHF++; break;
                case "JPY": lJPY++; break;
            }
            switch (longTrades.get(i).substring(3,6)){
                case "EUR": sEUR++; break;
                case "GBP": sGBP++; break;
                case "NZD": sNZD++; break;
                case "AUD": sAUD++; break;
                case "USD": sUSD++; break;
                case "CAD": sCAD++; break;
                case "CHF": sCHF++; break;
                case "JPY": sJPY++; break;
            }
        }
        for(int i = 0; i < shortTrades.size(); i++){
            switch (shortTrades.get(i).substring(0,3)){
                case "EUR": sEUR++; break;
                case "GBP": sGBP++; break;
                case "NZD": sNZD++; break;
                case "AUD": sAUD++; break;
                case "USD": sUSD++; break;
                case "CAD": sCAD++; break;
                case "CHF": sCHF++; break;
                case "JPY": sJPY++; break;
            }
            switch (shortTrades.get(i).substring(3,6)){
                case "EUR": lEUR++; break;
                case "GBP": lGBP++; break;
                case "NZD": lNZD++; break;
                case "AUD": lAUD++; break;
                case "USD": lUSD++; break;
                case "CAD": lCAD++; break;
                case "CHF": lCHF++; break;
                case "JPY": lJPY++; break;
            }
        }
        sepl();
        System.out.println("    Summary");
        sepl();
        if (lEUR != 0 || sEUR != 0)
            System.out.println("Euro:   " + lEUR + " Long / " + sEUR + " Short");

        if (lGBP != 0 || sGBP != 0)
            System.out.println("GBP     " + lGBP + " Long / " + sGBP + " Short");

        if (lNZD != 0 || sNZD != 0)
            System.out.println("NZD     " + lNZD + " Long / " + sNZD + " Short");

        if (lAUD != 0 || sAUD != 0)
            System.out.println("AUD     " + lAUD + " Long / " + sAUD + " Short");

        if (lUSD != 0 || sUSD != 0)
            System.out.println("USD     " + lUSD + " Long / " + sUSD + " Short");

        if (lCAD != 0 || sCAD != 0)
            System.out.println("CAD     " + lCAD + " Long / " + sCAD + " Short");

        if (lCHF != 0 || sCHF != 0)
            System.out.println("CHF     " + lCHF + " Long / " + sCHF + " Short");

        if (lJPY != 0 || sJPY != 0)
            System.out.println("JPY     " + lJPY + " Long / " + sJPY + " Short");
    }

    public static void main(String[] args) {

        sepl();System.out.println("    Forex Hedge Checker");sepl();
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



        hedgeCheck();

        scanner.close();
    }
}
