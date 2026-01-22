/**
* @Filename - MyFunctions.java
* @Description - this will perform most of the string and number operations
* @Author - Nancy Jain
*/

import java.util.ArrayList;
import java.util.HashSet;

class MyFunctions{
    private String string;
    private int number;
    public MyFunctions(String string , int number){
        this.string=string;
        this.number=number;
    }

 // 1. Count Unique Palindromes
    boolean checkPalindrome(String value) {
        int leftPointer = 0, rightPointer = value.length() - 1;
        while (leftPointer < rightPointer) {
            if (value.charAt(leftPointer) != value.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    // Count all unique palindromic substrings in the input
    int countUniquePalindrome() {
        String input = this.string;
        int countUniquePalindrome = 0;
        ArrayList<String> uniquePalindrome = new ArrayList<>();
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String sub = input.substring(i, j + 1);
                if (checkPalindrome(sub) && !uniquePalindrome.contains(sub)) {
                    uniquePalindrome.add(sub);
                    countUniquePalindrome++;
                }
            }
        }
        return countUniquePalindrome;
    }

// 2. Fibonacci Sequence – Nth Number 
    public int getNthFibonacciNum(int nthNumber){
        if (nthNumber == 0 || nthNumber == 1) {
            return nthNumber;
        }
        return getNthFibonacciNum(nthNumber - 1) + getNthFibonacciNum(nthNumber - 2);
    }

// 3. Snake Case to Camel Case Conversion
    public String getCamelcaseString(){
        String camelCase = "";
        boolean upperNext = false;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '_') {
                upperNext = true;
            } else {
                if (upperNext && ch >= 'a' && ch <= 'z') {
                    camelCase += (char) (ch - ('a' - 'A'));
                    upperNext = false;
                } else {
                    camelCase += ch;
                }
            }
        }
        return camelCase;
    }

// 4. Count Consonants in a String
    public int countConstants(){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                char lowerC = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
                if (lowerC != 'a' && lowerC != 'e' && lowerC != 'i' && lowerC != 'o' && lowerC != 'u') {
                    count++;
                }
            }
        }
        return count;
    }

// 5. Binary to Decimal Conversion 
    public int getDecimalEquivalent(String binaryString){
        int decimal = 0;
        int power = 1;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            char ch = binaryString.charAt(i);
            if (ch == '1') {
                decimal += power;
            } else if (ch != '0') {
                return -1;
            }
            power *= 2;
        }
        return decimal;
    }

// 6. Characters in a String
    public String getExpandedString( String compressedString){
        String result = "";
        int len = compressedString.length();
        for (int i = 0; i < len; ) {
            char ch = compressedString.charAt(i);
            i++;
            int count = 0;
            while (i < len && compressedString.charAt(i) >= '0' && compressedString.charAt(i) <= '9') {
                count = count * 10 + (compressedString.charAt(i) - '0');
                i++;
            }
            for (int j = 0; j < count; j++) {
                result += ch;
            }
        }
        return result;
    }

// 7. Character Frequency in a String 
    public String getCompressedForm() {
        String result = "";
        int countCharacter = 1;
        String input = this.string;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                    countCharacter++;
                } else {
                    result += input.charAt(i) + String.valueOf(countCharacter);
                    countCharacter = 1; // Reset count
                }
            }
            return result;
}

// 8. Prime Number Checker
    public boolean isPrimeNumber(){
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
 
// 10. Longest Substring Without Repeating Characters 
    public int getLongestSubstringLen(){
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < string.length(); i++) {
            for (int j = start; j < i; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    start = j + 1;
                    break;
                }
            }
            int length = i - start + 1;
            if (length > maxLen) maxLen = length;
        }
        return maxLen;
    }
}