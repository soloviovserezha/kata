package service;

public interface Converter {

    boolean isRoman(String number);

    String intToRoman(int number);

    int romanToInt(String s);
}
