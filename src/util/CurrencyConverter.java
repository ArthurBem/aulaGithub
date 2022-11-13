package util;

public class CurrencyConverter {
    public static double price, dollars;
    public static final double iof = 1.06;
    public static double convert(){
        return dollars * price * iof;
    }
    
}
