import java.util.*;
class MyString{
	static Scanner sc = new Scanner(System.in);  //sc not static, cannot be accessed from static main
	public void Append(){
		System.out.println("Enter number of strings to append");
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr= new String[n];
		System.out.println("Enter strings");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextLine();
		}
		String ans="";
		for(int i=0;i<n;i++){
			ans += arr[i];
			ans+=' ';
		}
		System.out.println("Appended string is: "+ans);
	}
	public void CountWords() {
		System.out.println("Enter string");
		String s = sc.nextLine().trim(); // remove leading/trailing spaces
		int count = 0;
		boolean inWord = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && !inWord) {
				inWord = true;
				count++;
			} else if (s.charAt(i) == ' ') {
				inWord = false;
			}
		}
		System.out.println("Number of words in \"" + s + "\" are: " + count);
	}
	public void Replace(){
		System.out.println("Enter string");
        String s = sc.nextLine();
        System.out.println("Enter letter to replace");
        char l = sc.nextLine().charAt(0);
        System.out.println("Enter letter to replace with");
        char r = sc.nextLine().charAt(0);
		String ans = "";
		for (int i = 0; i < s.length(); i++){
			if(s.charAt(i) == l) ans += r;
			else ans += s.charAt(i);
		}
		System.out.println("Replaced String is : "+ ans);
	}
	public void isPalindrome(){
		System.out.println("Enter string");
		String s = sc.nextLine();
		boolean flag = true;
		int l=0,r = s.length()-1;
		while(l < r){
			if(s.charAt(l)!= s.charAt(r)){ 
			System.out.println("String " + s + " is not palindrome");
			flag = false;
			break;
		}
		l++;
		r--;
		}
		if(flag){
			System.out.println("String " + s+" is palindrome");
		}
	}
	public void Splice(){
		System.out.println("Enter string");
		String s = sc.nextLine();
		System.out.println("Enter starting index to Splice (0-indexed)");
		int a = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter ending index to Splice (0-indexed)");
		int b = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter string to replace of length"+ (b-a+1));
		String rep = sc.nextLine();
		String ans ="";
		int j=0;
		for(int i=0;i<s.length();i++){
			if(i >= a && i <= b){
				ans += rep.charAt(j);
				j++;
			}else ans += s.charAt(i);
		}
		System.out.println("Spliced string is : "+ans);
	}
	public void Split(){
		System.out.println("Enter string to split");
		String s = sc.nextLine();
		System.out.println("Enter the delimiter");
		char delimiter = sc.nextLine().charAt(0);
		String word="";
		System.out.println("Split strings");
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) != delimiter) word+= s.charAt(i);
			else {
				System.out.println(word);
				word="";
			}
		}
		if(!word.equals("")){
			System.out.println(word);
		}
	}
	public void MaxRepeatingCharacter(){
		System.out.println("Enter a string");
		String s = sc.nextLine();
		int maxCount=0;
		char maxChar=' ';
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			int count=0;
			for(int j=0;j<s.length();j++){
				if(s.charAt(j) == ch){
					count++;
				}
			}
			if(count>maxCount){
				maxCount=count;
				maxChar = ch;
			}
		}
		System.out.println("Max Repeating Character is :"+ maxChar);
	}
	public void Sort(){
		System.out.println("Enter a string");
		String s = sc.nextLine();
		char[] ans = s.toCharArray();
		for(int i=0;i<ans.length -1;i++){   //ans.length() is not a function (it’s a field).
				for(int j=0;j<ans.length -i -1;j++){
					if(ans[j]>ans[j+1]){
						char temp = ans[j];
						ans[j] = ans[j + 1];
						ans[j + 1] = temp;
					}
				}
		}
		System.out.println("The Sorted String is :"+ new String(ans)); //Directly printing a char[] will not show characters properly. 
	}
	public void Shift(){
		System.out.println("Enter a string");
		String s = sc.nextLine();
		System.out.println("Enter number of positions to shift:");
		int k = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter direction (L for Left, R for Right):");
		char dir = sc.nextLine().charAt(0);
		int n = s.length();
		k = k % n;
		String shifted = "";
		if (dir == 'L' || dir == 'l') {
        for (int i = k; i < n; i++) {
            shifted += s.charAt(i);
        }
        for (int i = 0; i < k; i++) {
            shifted += s.charAt(i);
        }
    } else if (dir == 'R' || dir == 'r') {
        for (int i = n - k; i < n; i++) {
            shifted += s.charAt(i);
        }
        for (int i = 0; i < n - k; i++) {
            shifted += s.charAt(i);
        }
    } else {
        System.out.println("Invalid direction! Use L or R only.");
        return;
    }
    System.out.println("Shifted string is: " + shifted);
	}
	public void Reverse(){
		System.out.println("Enter a string");
		String s = sc.nextLine();
		char[] arr = s.toCharArray();
		int l=0,r=s.length()-1;
		while(l<r){
			char temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
		System.out.println("The Reverse String is : "+ new String(arr));
	}
	public static void main(String[] args){
		MyString obj = new MyString();
		while(true){
		System.out.println("Enter the function : Append-1 , CountWords-2, Replace-3, isPalindrome-4,Splice-5, Split-6, MaxRepeatingCharacter-7, Sort-8, Shift-9, Reverse-10 , Exit - 11");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice){
			case 1:
				obj.Append();
				break;
			case 2:
				obj.CountWords();
				break;
			case 3:
				obj.Replace();
				break;
			case 4:
				obj.isPalindrome();
				break;
			case 5:
				obj.Splice();
				break;
			case 6:
				obj.Split();
				break;
			case 7:
				obj.MaxRepeatingCharacter();
				break;
			case 8:
				obj.Sort();
				break;
			case 9:
				obj.Shift();
				break;
			case 10:
				obj.Reverse();
				break;
			case 11:
				 System.exit(0);   //obj.exit(); wrong
			default:
				System.out.println("Wrong choice");
		}
		}
	}
}