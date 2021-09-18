package Converter;

import java.util.Arrays;

public enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);

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
