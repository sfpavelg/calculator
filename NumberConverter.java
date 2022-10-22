package calculator;

public class NumberConverter {
    /**
     * @param input String includes char I, V, X
     */
    public static int romanToArabic(String input) {
        String romanUpperNumber = input.toUpperCase();
        RomanNumeral roman = RomanNumeral.findByKeyRoman(romanUpperNumber);
        if (roman != null) {
            return roman.getValue();
        }
        throw new Error("Только числа от I до X");
    }

    /**
     * @param n int includes int
     */
    public static String arabicToRoman(int n) {
        RomanNumeral roman = RomanNumeral.findByValueRoman(n);
        if (roman != null) {
            return roman.name();
        }
        throw new Error("Только числа от 1 до 10");
    }

    /**
     * @param s String checked string
     */

    public static boolean isRoman(String s) {
        return !isArabic(s);
    }

    /**
     * @param s String checked string
     */

    public static boolean isArabic(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException err) {
            return false;
        }
    }

    public static int parseArabicNumberString(String s) {
        return Integer.parseInt(s);
    }
}
