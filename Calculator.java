package calculator;

//Основной класс конструктор

public class Calculator {
    public Calculator() {
        System.out.println("Введите числа для подсчёта, например 2+2 или II+II:\nДля выхода из программы наберите exit, или нажмите Ctrl+C");
        new ScannerCalculator();
        new Selector();
        if (Data.isArabic) {
            System.out.println("Спасибо! Ваш результат: " + Data.result + "\n");
        } else {
            if (Data.result <= 0) {
                throw new Error("Римские цифры должны быть больше нуля");
            }
            System.out.println("Спасибо! Ваш результат: " + NumberConverter.arabicToRoman(Data.result) + "\n");
        }
        new Calculator();
    }
}
