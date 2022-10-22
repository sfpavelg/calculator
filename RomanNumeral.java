package calculator;

import java.util.Arrays;

public enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XII(12), XIV(14), XV(15), XVI(16), XVIII(18), XX(20), XXI(21), XXIV(24), XXV(25), XXVII(27), XXVIII(28), XXX(30), XXXV(35), XXXVI(36), XL(40), XLII(42), XLV(45), XLVII(48), XLIX(49), L(50), LIV(54), LVI(56), LX(60), LXIII(63), LXIV(64), LXX(70), LXXII(72), LXXX(80), LXXXI(81), XC(90), C(100);
    private int value;

    RomanNumeral(int value) {
        this.value = value;
    }

    public static RomanNumeral findByKeyRoman(String key) {
        return Arrays.stream(values()).filter(item -> item.name().equals(key)).findFirst().orElse(null);
    }

    public static RomanNumeral findByValueRoman(int value) {
        return Arrays.stream(values()).filter(item -> item.getValue() == value).findFirst().orElse(null);
    }

    public int getValue() {
        return value;
    }
}
