/**
* @Filename - MyNumber.java
* @Description - this will perform most of the string and number operations
* @Author - Nancy Jain
*/

import java.util.*;

class MyNumber{

// 2. Fibonacci Sequence – Nth Number 
    public int getNthFibonacciNum(int nthNumber){
        if (nthNumber <= 1) return nthNumber;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= nthNumber; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

// 8. Prime Number Checker
    public boolean isPrimeNumber(int number){
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i <= number / i; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

// 9. Number to Words Converter 
    public String getEnglishForm(int num){
        String[] units = {
                "", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };

        if (num == 0)
            return "Zero";

        if (num < 20)
            return units[num];
        else if (num < 100)
            return tens[num / 10] + ((num % 10 != 0) ? " " + units[num % 10] : "");
        else if (num < 1000)
            return units[num / 100] + " Hundred" + ((num % 100 != 0) ? " " + getEnglishForm(num % 100) : "");
        else if (num < 10000)
            return units[num / 1000] + " Thousand" + ((num % 1000 != 0) ? " " + getEnglishForm(num % 1000) : "");
        else
            return "Number out of range (0–9999)";
    }
 
}