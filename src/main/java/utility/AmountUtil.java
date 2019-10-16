package utility;

public class AmountUtil {

    public static int countDecimalPlaces(double value) {
        return String.valueOf(value).split("\\.")[1].length();
    }

}
