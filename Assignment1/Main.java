/**
* @Filename - MyString.java
* @Description - this will perform most of the string operations
* @Author - Nancy Jain
*/

import java.util.*;
public class Main{
public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String input = sc.nextLine();
		MyString obj = new MyString(input);
		while(true){
		System.out.println("Enter the function : Append-1 , CountWords-2, Replace-3, isPalindrome-4,Splice-5, Split-6, MaxRepeatingCharacter-7, Sort-8, Shift-9, Reverse-10 , Exit - 11");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 1:
				System.out.println("Enter string to append");
				String toAppend=sc.nextLine();
				obj.Append(toAppend);
				System.out.println("Appended string "+obj.getValue());
				break;
			case 2:
				int wordCount = obj.CountWords();
                System.out.println("Word count: " + wordCount);
				break;
			case 3:
				System.out.println("Enter substring to replace");
				String toreplace = sc.nextLine();
				System.out.println("Enter substring to replace with");
				String replaceby = sc.nextLine();
				obj.Replace(toreplace,replaceby);
				System.out.println("Replaced String is : "+ obj.getValue());
				break;
			case 4:
				boolean flag =obj.isPalindrome();
				if(flag) {
					System.out.println("String is palindrome");
				}
				else {
					System.out.println("String is not palindrome");
				}
				break;
			case 5:
				System.out.println("Enter starting index to Splice (0-indexed)");
				int start = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter ending index to Splice (0-indexed)");
				int end = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter string to replace of length"+ (end-start+1));
				String replace = sc.nextLine();
				obj.Splice(start,end,replace);
				System.out.println("Spliced string is : "+obj.getValue());
				break;
			case 6:
				System.out.print("Enter pattern to split by: ");
			 	char delimiter = sc.nextLine().charAt(0);
				String[] parts = obj.Split(delimiter);
				System.out.print("Result: [");
				for (int i = 0; i < parts.length; i++) {
					System.out.print("\"" + parts[i] + "\"");
					if (i < parts.length - 1) System.out.print(", ");
				}
				System.out.println("]");
				break;
			case 7:
				char maxChar = obj.MaxRepeatingCharacter();
                System.out.println("Max repeating character: " + maxChar);
				break;
			case 8:
				String sorted = obj.Sort();
            	System.out.println("Sorted: " + sorted);
				break;
			case 9:
				System.out.println("Enter number of positions to shift:");
				int position = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter direction (L for Left, R for Right):");
				char direction = sc.nextLine().charAt(0);
				obj.Shift(position ,direction);
				System.out.println("Result: " + obj.getValue());
				break;
			case 10:
				String reversed =obj.Reverse();
				System.out.println("Reversed String: " + reversed);
				break;
			case 11:
				 System.exit(0);   //obj.exit(); wrong
			default:
				System.out.println("Wrong choice");
		}
		}
	}
}