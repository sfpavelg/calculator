package calculator;

//класс селектор

class Selector {
    //переменные для поиска знаков +, - и т.д.
    public int indexPlus;
    //переменные для поиска знаков +, - и т.д.
    public int indexMinus;
    //переменные для поиска знаков +, - и т.д.
    public int indexMyltiply;
    //переменные для поиска знаков +, - и т.д.
    public int indexDivide;
    //массив для цифровых частей
    public String[] numbersEnterString;
    //переменная для первого числа
    public int number1;
    //переменная для второго числа
    public int number2;
    //константа максимального значения вводимого числа
    final int MAX_NUMBER = 10;

    public Selector() {
//Ищем плюс,минус,умножить и делить
        indexPlus = Data.calculations.indexOf('+');
        indexMinus = Data.calculations.indexOf('-');
        indexMyltiply = Data.calculations.indexOf('*');
        indexDivide = Data.calculations.indexOf('/');
//Если плюс найден....
        if (indexPlus > 0) {
// делим строку пополам создав массив с ограничением в два индекса,
            numbersEnterString = Data.calculations.split("\\+");
            if (numbersEnterString.length > 2) {
                throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
            }
            Data.isArabic = NumberConverter.isArabic(numbersEnterString[0]);
            if (Data.isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                throw new Error("Оба числа должны быть в одном формате, либо в арабском, либо в римском.");
            }
            if (Data.isArabic) {
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
            Data.result = number1 + number2;
        } else
//Если минус найден....
            if (indexMinus > 0) {
//.... делим строку пополам создав массив с ограничением в два индекса
                numbersEnterString = Data.calculations.split("\\-");
                if (numbersEnterString.length > 2) {
                    throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                }
                Data.isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                if (Data.isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                    throw new Error("Оба числа должны быть в одном формате, либо в арабском, либо в римском.");
                }
                if (Data.isArabic) {
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
                Data.result = number1 - number2;
            } else
//Если умножить найден....
                if (indexMyltiply > 0) {
// делим строку пополам создав массив с ограничением в два индекса
                    numbersEnterString = Data.calculations.split("\\*");
                    if (numbersEnterString.length > 2) {
                        throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                    }
                    Data.isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                    if (Data.isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                        throw new Error("Оба числа должны быть в одном формате, либо в арабском, либо в римском.");
                    }
                    if (Data.isArabic) {
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
                    Data.result = number1 * number2;
                } else
//Если деление найдено....
                    if (indexDivide > 0) {
//.... делим строку пополам создав массив с ограничением в два индекса
                        numbersEnterString = Data.calculations.split("\\/");
                        if (numbersEnterString.length > 2) {
                            throw new Error("формат математической операции не удовлетворяет заданию - может быть только два операнда и один оператор");
                        }
                        Data.isArabic = NumberConverter.isArabic(numbersEnterString[0]);
                        if (Data.isArabic != NumberConverter.isArabic(numbersEnterString[1])) {
                            throw new Error("Оба числа должны быть в одном формате, либо в арабском, либо в римском.");
                        }
                        if (Data.isArabic) {
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
                        Data.result = number1 / number2;
                    } else {
                        throw new Error("формат математической операции не удовлетворяет заданию - должны быть операторы [+]или[-]или[*]или[/]");
                    }
    }
}

