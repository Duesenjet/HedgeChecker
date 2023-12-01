import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class HedgeChecker {
    static List<String> recommendations = new ArrayList<>();
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
    public HedgeChecker(){}
    static void sepl(){
        System.out.println("-".repeat(80));
    }
    public void hedgeCheck(List<String> longTrades, List<String> shortTrades) {      //calcs about the riskmanagement with output
        for (int i = 0; i < longTrades.size(); i++) {
            switch (longTrades.get(i).substring(0, 3)) {
                case "EUR":
                    lEUR++;
                    break;
                case "GBP":
                    lGBP++;
                    break;
                case "NZD":
                    lNZD++;
                    break;
                case "AUD":
                    lAUD++;
                    break;
                case "USD":
                    lUSD++;
                    break;
                case "CAD":
                    lCAD++;
                    break;
                case "CHF":
                    lCHF++;
                    break;
                case "JPY":
                    lJPY++;
                    break;
            }
            switch (longTrades.get(i).substring(3, 6)) {
                case "EUR":
                    sEUR++;
                    break;
                case "GBP":
                    sGBP++;
                    break;
                case "NZD":
                    sNZD++;
                    break;
                case "AUD":
                    sAUD++;
                    break;
                case "USD":
                    sUSD++;
                    break;
                case "CAD":
                    sCAD++;
                    break;
                case "CHF":
                    sCHF++;
                    break;
                case "JPY":
                    sJPY++;
                    break;
            }
        }
        for (int i = 0; i < shortTrades.size(); i++) {
            switch (shortTrades.get(i).substring(0, 3)) {
                case "EUR":
                    sEUR++;
                    break;
                case "GBP":
                    sGBP++;
                    break;
                case "NZD":
                    sNZD++;
                    break;
                case "AUD":
                    sAUD++;
                    break;
                case "USD":
                    sUSD++;
                    break;
                case "CAD":
                    sCAD++;
                    break;
                case "CHF":
                    sCHF++;
                    break;
                case "JPY":
                    sJPY++;
                    break;
            }
            switch (shortTrades.get(i).substring(3, 6)) {
                case "EUR":
                    lEUR++;
                    break;
                case "GBP":
                    lGBP++;
                    break;
                case "NZD":
                    lNZD++;
                    break;
                case "AUD":
                    lAUD++;
                    break;
                case "USD":
                    lUSD++;
                    break;
                case "CAD":
                    lCAD++;
                    break;
                case "CHF":
                    lCHF++;
                    break;
                case "JPY":
                    lJPY++;
                    break;
            }
        }
        sepl();
        System.out.println("    Summary");
        sepl();
        if (lEUR != 0 || sEUR != 0)
            System.out.println("Euro:   " + lEUR + " Long / " + sEUR + " Short");recommendationsListMaker(lEUR,sEUR,"EUR");

        if (lGBP != 0 || sGBP != 0)
            System.out.println("GBP     " + lGBP + " Long / " + sGBP + " Short");recommendationsListMaker(lGBP,sGBP,"GBP");

        if (lNZD != 0 || sNZD != 0)
            System.out.println("NZD     " + lNZD + " Long / " + sNZD + " Short");recommendationsListMaker(lNZD,sNZD,"NZD");

        if (lAUD != 0 || sAUD != 0)
            System.out.println("AUD     " + lAUD + " Long / " + sAUD + " Short");recommendationsListMaker(lAUD,sAUD,"AUD");

        if (lUSD != 0 || sUSD != 0)
            System.out.println("USD     " + lUSD + " Long / " + sUSD + " Short");recommendationsListMaker(lUSD, sUSD, "USD");

        if (lCAD != 0 || sCAD != 0)
            System.out.println("CAD     " + lCAD + " Long / " + sCAD + " Short");recommendationsListMaker(lCAD,sCAD, "CAD");

        if (lCHF != 0 || sCHF != 0)
            System.out.println("CHF     " + lCHF + " Long / " + sCHF + " Short");recommendationsListMaker(lCHF,sCHF,"CHF");

        if (lJPY != 0 || sJPY != 0)
            System.out.println("JPY     " + lJPY + " Long / " + sJPY + " Short");recommendationsListMaker(lJPY,sJPY,"JPY");

    recommendationListOutput();
    }
     static void recommendationsListMaker(int l, int s, String currency){ //method for putting recomms in the list
        if (l - s >= 2 || l - s <= -2){
            if (l - s >= 2){
                recommendations.add(currency + " Short suchen ");
            }else{
                recommendations.add(currency + " Long suchen");
            }
        }
    }
     static void recommendationListOutput(){          //output of recomms
        sepl();
        System.out.println("    Recommendations");
        sepl();
        for (int i = 0; i < recommendations.size(); i++){
            System.out.println(recommendations.get(i));
        }
        sepl();
    }
}
