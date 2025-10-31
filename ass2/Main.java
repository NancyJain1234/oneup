/**
* @Filename - Main.java
* @Description - this will perform most of the string and number operations
* @Author - Nancy Jain
*/ 


import java.util.Scanner;

public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MyNumber  numoperation= new MyNumber();
        MyString stroperation = new MyString();
        int choice;
     do {
        System.out.println("Enter the function : Count Unique Palindromes -1  Fibonacci Sequence -2  Snake Case to Camel Case Conversion-3  Count Consonants in a String -4  Binary to Decimal Conversion-5  Characters in a String-6  Character Frequency-7  Check Prime Number -8  Convert Number to Words -9  Longest Substring Without Repeating Characters -10  Exit - 11 ");
        choice = sc.nextInt();
         sc.nextLine();
         switch(choice){
             case 1:
                System.out.print("Enter a string to find number of unique palindromes: ");
                String uniquePalindrome = sc.nextLine();
                System.out.println(" Total number of unique palindromes are:  "+ stroperation.countUniquePalindrome(uniquePalindrome));
                break;
             case 2:
                System.out.println("Enter Nth Number to find the Nth number in the Fibonacci sequence");
                int nthNumber= sc.nextInt();
                System.out.println("The Nth number in the Fibonacci sequence is : " + numoperation.getNthFibonacciNum(nthNumber));
                break;
             case 3:
                System.out.print("Enter a string in snake_case: ");
                String snake_caseString = sc.nextLine();
                System.out.println(" snake_case string coverted to camelCase format : "+ stroperation.getCamelcaseString(snake_caseString));
                break;
             case 4:
                System.out.print("Enter a string to find total number of consonants : ");
                String countConsonant= sc.nextLine();
                System.out.println("Number of  Consonants in a String are : " + stroperation.countConsonants(countConsonant));
                break;
             case 5:
                System.out.println("Enter binary string to convert into decimal equivalent ");
                String binaryString = sc.nextLine();
                System.out.println(" Binary string into its decimal equivalent is : " + stroperation.getDecimalEquivalent(binaryString));
                break;
             case 6:
                System.out.print("Enter string containing characters followed by digits: ");
                String expandedString = sc.nextLine();
                System.out.println("Expanded String is : " + stroperation.getExpandedString(expandedString));
                break;
             case 7:
                System.out.print("Enter a string to find frequency of each character: ");
                String countCharacter = sc.nextLine();
                System.out.println("The frequency of each character: " + stroperation.getCompressedForm(countCharacter));
                break;
             case 8:
                System.out.print("Enter a number to check if its prime or not: ");
                int number = sc.nextInt();
                System.out.println("Given integer is a prime number: " + numoperation.isPrimeNumber(number));
                break;
             case 9:
                System.out.println("Enter number to write in its English form");
                int num = sc.nextInt();
                System.out.println(" Integer into its written English form is: " + numoperation.getEnglishForm(num));
                break;
             case 10:
                System.out.print("Enter a string to find length of longest subsequence: ");
                String string = sc.nextLine();
                System.out.println("Length of the longest substring without repeating characters: " + stroperation.getLongestSubstringLen(string));
                break;
             case 11:
                System.out.println("Do you want to exit if yes press 1 else press 0");
                int action = sc.nextInt();
                if(action==1){
                System.out.println("Exiting...");
                System.exit(0); 
                }  
             default:
                System.out.println("Wrong choice");
        }
         } while (choice != 11); 
         sc.close();
     }
} 