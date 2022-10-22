package calculator;

import java.util.Scanner;

// класс сканер
class ScannerCalculator {
    public ScannerCalculator() {
        Scanner console = new Scanner(System.in);
        Data.calculations = console.nextLine();
//Выход из программы через exit
        if (Data.calculations.equals("exit")) {
            console.close();
        }
    }
}

    
