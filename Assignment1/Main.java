/**
* @Filename - Main.java
* @Description - this will perform most of the string operations
* @Author - Nancy Jain
*/

import java.util.*;
public class Main{
public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        MyString myString = new MyString(input);
        int choice;
    do {
        System.out.println("Enter the function : Append-1 , CountWords-2, Replace-3, isPalindrome-4,Splice-5, Split-6, MaxRepeatingCharacter-7, Sort-8, Shift-9, Reverse-10 , Exit - 11");
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.println("Enter string to append");
                String stringToAppend=sc.nextLine();
                System.out.println("Appended string "+ myString.getAppendedString(stringToAppend));
                break;
            case 2:
                int wordCount = myString.getCountWords();
                System.out.println("Word count: " + wordCount);
                break;
            case 3:
                System.out.println("Enter substring to replace");
                String oldSubString = sc.nextLine();
                System.out.println("Enter substring to replace with");
                String newSubString = sc.nextLine();
                System.out.println("Replaced String is : "+ myString.getReplacedString(oldSubString,newSubString));
                break;
            case 4:
                if(myString.isPalindrome()) {
                    System.out.println("String is palindrome");
                }
                else {
                    System.out.println("String is not palindrome");
                }
                break;
            case 5:
                System.out.println("Enter starting index to splice (0-indexed)");
                int startIndex = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter ending index to splice (0-indexed)");
                int endIndex = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter replacement string of length "+ (endIndex -startIndex +1));
                String replacement = sc.nextLine();
                System.out.println("Spliced string is : "+myString.getSplicedString(startIndex,endIndex,replacement));
                break;
            case 6:
                System.out.print("Enter character to split by: ");
                char delimiter = sc.nextLine().charAt(0);
                String[] parts = myString.getSplitedString(delimiter);
                System.out.print("Result: [");
                for (int i = 0; i < parts.length; i++) {
                    System.out.print("\"" + parts[i] + "\"");
                    if (i < parts.length - 1) System.out.print(", ");
                }
                System.out.println("]");
                break;
            case 7:
                char maxChar = myString.getMaxRepeatingCharacter();
                System.out.println("Max repeating character: " + maxChar);
                break;
            case 8:
                System.out.println("Sorted: " + myString.getSortedString());
                break;
            case 9:
                System.out.println("Enter number of positions to shift:");
                int position = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter direction (L for Left, R for Right):");
                char direction = sc.nextLine().charAt(0);
                System.out.println("Result: " + myString.getShiftedString(position ,direction));
                break;
            case 10:
                String reversed =myString.getReverseString();
                System.out.println("Reversed String: " + reversed);
                break;
            case 11:
                System.out.println("Exiting...");
                System.exit(0);   //myString.exit(); wrong
            default:
                System.out.println("Wrong choice");
             }
         } while (choice != 11);
     }
}