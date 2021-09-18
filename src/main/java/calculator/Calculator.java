package calculator;

import Converter.NumberConverter;

import java.util.Scanner;

//Основной класс конструктор
public class Calculator {
    final int MAX_NUMBER = 10;
    //переменная для вводимой строки
    public String calculations;
    //массив для вводимой строки
    public String[] numbersEnterString;
//    public int[] numbersEnteInt;
    //переменные
    public int number1;
    public int number2;
    public int result;
    public int indexPlus;
    public int indexMinus;
    public int indexMyltiply;
    public int indexDivide;
    public boolean isArabic;

    public Calculator() {
        System.out.println("Введите числа для подсчёта, например 2+2 или II+II:\nДля выхода из программы наберите exit, или нажмите Ctrl+C");
        new ScannerCalculator();
        new Selector();

        if(isArabic) {
            System.out.println("Спасибо! Ваш результат: " + result + "\n");
        } else {

            if(result <= 0) {
                throw new Error("Римские цифры должны быть больше нуля");
            }
            System.out.println("Спасибо! Ваш результат: " + NumberConverter.arabicToRoman(result) + "\n");
        }

        new Calculator();
    }

    //вложенный класс сканер
    class ScannerCalculator {
        public ScannerCalculator() {
            Scanner console = new Scanner(System.in);
            calculations = console.nextLine();
            //Выход из программы через exit
            if (calculations.equals("exit")) {
                console.close();
            }
        }
    }

    //вложенный класс селектор
    class Selector {
        public Selector() {
//Ищем плюс,минус,умножить и делить
            indexPlus = calculations.indexOf('+');
            indexMinus = calculations.indexOf('-');
            indexMyltiply = calculations.indexOf('*');
            indexDivide = calculations.indexOf('/');
//Если плюс найден....

            if (indexPlus > 0) {
                // делим строку пополам создав массив с ограничением в два индекса, //вдруг там второй плюс
                numbersEnterString = calculations.split("\\+");

                if (numbersEnterString.length > 2) {
                    throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                }

                isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                if (isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                    throw new Error("Неверный формат");
                }

                if(isArabic) {
                    number1 = NumberConverter.parseArabicNumberString(numbersEnterString[0]);
                    number2 = NumberConverter.parseArabicNumberString(numbersEnterString[1]);
                } else {
                    number1 = NumberConverter.romanToArabic(numbersEnterString[0]);
                    number2 = NumberConverter.romanToArabic(numbersEnterString[1]);
                }

                //ограничиваем числа до 10
                if (number1 > MAX_NUMBER || number2 > MAX_NUMBER) {
                    throw new Error("формат математической операции не удовлетворяет заданию - вводимые числа от 0 до 10");
                }

                result = number1 + number2;
            } else if (indexMinus > 0) {
                //Ищем минус
                //Если минус найден....

//.... делим строку пополам создав массив с ограничением в два //индекса,вдруг там второй минус
                numbersEnterString = calculations.split("\\-");

                if (numbersEnterString.length > 2) {
                    throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                }

                isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                if (isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                    throw new Error("Неверный формат");
                }

                if(isArabic) {
                    number1 = NumberConverter.parseArabicNumberString(numbersEnterString[0]);
                    number2 = NumberConverter.parseArabicNumberString(numbersEnterString[1]);
                } else {
                    number1 = NumberConverter.romanToArabic(numbersEnterString[0]);
                    number2 = NumberConverter.romanToArabic(numbersEnterString[1]);
                }

                //ограничиваем числа до 10
                if (number1 > MAX_NUMBER || number2 > MAX_NUMBER) {
                    throw new Error("формат математической операции не удовлетворяет заданию - вводимые числа от 0 до 10");
                }
                result = number1 - number2;
            } else if (indexMyltiply > 0) {
                //Ищем умножить
                //Если умножить найден....

                // делим строку пополам создав массив с ограничением в два //индекса,вдруг там второе умножить
                numbersEnterString = calculations.split("\\*");
                if (numbersEnterString.length > 2) {
                    throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                }

                isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                if (isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                    throw new Error("Неверный формат");
                }

                if(isArabic) {
                    number1 = NumberConverter.parseArabicNumberString(numbersEnterString[0]);
                    number2 = NumberConverter.parseArabicNumberString(numbersEnterString[1]);
                } else {
                    number1 = NumberConverter.romanToArabic(numbersEnterString[0]);
                    number2 = NumberConverter.romanToArabic(numbersEnterString[1]);
                }

                //ограничиваем числа до 10
                if (number1 > MAX_NUMBER || number2 > MAX_NUMBER) {
                    throw new Error("формат математической операции не удовлетворяет заданию - вводимые числа от 0 до 10");
                }

                result = number1 * number2;
            } else if (indexDivide > 0) {
                //Ищем деление
                //Если деление найдено....
                //.... делим строку пополам создав массив с ограничением в два //индекса,вдруг там второе умножить
                numbersEnterString = calculations.split("\\/");
                if (numbersEnterString.length > 2) {
                    throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                }

                isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                if (isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                    throw new Error("Неверный формат");
                }

                if(isArabic) {
                    number1 = NumberConverter.parseArabicNumberString(numbersEnterString[0]);
                    number2 = NumberConverter.parseArabicNumberString(numbersEnterString[1]);
                } else {
                    number1 = NumberConverter.romanToArabic(numbersEnterString[0]);
                    number2 = NumberConverter.romanToArabic(numbersEnterString[1]);
                }

                //ограничиваем числа до 10
                if (number1 > MAX_NUMBER || number2 > MAX_NUMBER) {
                    throw new Error("формат математической операции не удовлетворяет заданию - вводимые числа от 0 до 10");
                }

                result = number1 / number2;
            } else {
                throw new Error("формат математической операции не удовлетворяет заданию - должны быть операторы [+]или[-]или[*]или[/]");
            }
        }
    }
}
