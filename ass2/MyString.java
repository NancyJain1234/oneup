/**
* @Filename - MyString.java
* @Description - this will perform most of the string and number operations
* @Author - Nancy Jain
*/

import java.util.*;

class MyString{

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
    int countUniquePalindrome(String uniquePalindromes) {
        String input = uniquePalindromes;
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

// 3. Snake Case to Camel Case Conversion
    public String getCamelcaseString(String snake_caseString){
        String camelCase = "";
        boolean upperNext = false;
        for (int i = 0; i < snake_caseString.length(); i++) {
            char ch = snake_caseString.charAt(i);
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
    public int countConsonants(String countConsonant){
        int count = 0;
        for (int i = 0; i < countConsonant.length(); i++) {
            char ch = countConsonant.charAt(i);
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
            if (Character.isLetter(ch)) {
                i++;
                int count = 0;
                while (i < len && Character.isDigit(compressedString.charAt(i))) {
                    count = count * 10 + (compressedString.charAt(i) - '0');
                    i++;
                }
                if (count == 0) count = 1;
                for (int j = 0; j < count; j++) {
                    result += ch;
                }
            } else {
                i++;
            }
        }
        return result;
    }

// 7. Character Frequency in a String 
    public String getCompressedForm(String input) {
        String result = "";
        int countCharacter = 1;
        for (int i = 0; i < input.length(); i++) {
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                countCharacter++;
            } else {
                result += String.valueOf(input.charAt(i)) + countCharacter;
                countCharacter = 1; // Reset count
            }
        }
        return result;
}
 
// 10. Longest Substring Without Repeating Characters 
    public int getLongestSubstringLen(String string){
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