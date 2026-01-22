/**
* @Filename - Main.java
* @Description - this will perform most of the string and number operations
* @Author - Nancy Jain
*/ 


import java.util.*;

public class Main{
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = sc.nextLine();
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
         MyFunctions  operation= new MyFunctions(string,number);
        int choice;
     do {
        System.out.println("Enter the function : Count Unique Palindromes -1  Fibonacci Sequence -2  Snake Case to Camel Case Conversion-3  Count Consonants in a String -4  Binary to Decimal Conversion-5  Characters in a String-6  Character Frequency-7  Check Prime Number -8  Convert Number to Words -9  Longest Substring Without Repeating Characters -10  Exit - 11 ");
        choice = sc.nextInt();
         sc.nextLine();
         switch(choice){
             case 1:
                 System.out.println(" Total number of unique palindromes are:  "+ operation.countUniquePalindrome());
                 break;
             case 2:
                 System.out.println("Enter Nth Number to find the Nth number in the Fibonacci sequence");
                 int nthNumber= sc.nextInt();
                 System.out.println("The Nth number in the Fibonacci sequence is : " + operation.getNthFibonacciNum(nthNumber));
                 break;
             case 3:
                 System.out.println(" snake_case string coverted to camelCase format : "+ operation.getCamelcaseString());
                 break;
             case 4:
                 System.out.println("Number of  Consonants in a String are : " + operation.countConstants());
                 break;
             case 5:
                 System.out.println("Enter binary string to convert into decimal equivalent ");
                 String binaryString = sc.nextLine();
                 System.out.println(" Binary string into its decimal equivalent is : " + operation.getDecimalEquivalent(binaryString));
                break;
             case 6:
                 System.out.print("Enter string containing characters followed by digits: ");
                 String expandedString = sc.nextLine();
                 System.out.println("Expanded String is : " + operation.getExpandedString(expandedString));
                 break;
             case 7:
                 System.out.println("The frequency of each character: " + operation.getCompressedForm());
                 break;
             case 8:
                 System.out.println("Given integer is a prime number: " + operation.isPrimeNumber());
                 break;
             case 9:
                 System.out.println("Enter number to write in its English form");
                 int num = sc.nextInt();
                 System.out.println(" Integer into its written English form is: " + operation.getEnglishForm(num));
                 break;
             case 10:
                 System.out.println("Length of the longest substring without repeating characters: " + operation.getLongestSubstringLen());
                 break;
             case 11:
                 System.out.println("Exiting...");
                 System.exit(0);   
             default:
                 System.out.println("Wrong choice");
        }
         } while (choice != 11); 
         sc.close();
     }
} 