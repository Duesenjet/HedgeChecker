import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Currency {

    static List<String> currencies = new ArrayList();
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
    public Currency() {}
    public boolean checkCurr(String currency) {              //method for checking if the currency is existing
        for (int i = 0; i < currencies.size(); i++) {
            if (currency.toUpperCase(Locale.ROOT).equals(currencies.get(i)))
                return true;
        }
        return false;
    }
}
