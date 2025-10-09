/**
* @Filename - MyString.java
* @Description - this will perform most of the string operations
* @Author - Nancy Jain
*/
class MyString{
    private String value;
    public MyString(String value){
        this.value=value;
    }
    public String getAppendedString(String newString){
         this.value += newString;
         return this.value;
    }

    //Count Words function
    public int getCountWords() {
        String trimstring = this.value.trim(); // remove leading/trailing spaces
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < trimstring.length(); i++) {
            if (trimstring.charAt(i) != ' ' && !inWord) {
                inWord = true;
                count++;
            } else if (trimstring.charAt(i) == ' ') {
                inWord = false;
            }
        }
        return count;
    }

    //Replaced function
    public String getReplacedString(String oldWord, String newWord) {
        String replaced = "";
        int i = 0;
        int oldLen = oldWord.length();
        while (i < this.value.length()) {
            boolean match = true;
            if (i + oldLen <= this.value.length()) {
                for (int j = 0; j < oldLen; j++) {
                    if (this.value.charAt(i + j) != oldWord.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    replaced += newWord;
                    i += oldLen;
                    continue;
                }
            }  
            replaced += this.value.charAt(i);
            i++;
        }
        this.value = replaced; 
        return this.value;
    }

    //Palindrome function
    public boolean isPalindrome(){
        int start=0, end = this.value.length()-1;
        while(start < end){
            if(this.value.charAt(start)!= this.value.charAt(end)){ 
            return false;
        }
        start++;
        end--;
        }
        return true;
    }

    //Splice function
    public String getSplicedString(int startIndex ,int endIndex, String replacement){
        String spliced ="";
        int j=0;
        for(int i=0;i<this.value.length();i++){
            if(i >= startIndex && i <= endIndex){
                spliced += replacement.charAt(j);
                j++;
            }else spliced += this.value.charAt(i);
        }
        this.value = spliced;
        return this.value;
    }

    //Split function
    public String[] getSplitedString(char delimiter){
        int count = 1; 
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) == delimiter) {
                count++;
            }
        }
        String[] parts = new String[count];
        int partIndex = 0;
        String word = "";
        for (int i = 0; i < this.value.length(); i++) {
            if (this.value.charAt(i) != delimiter) {
                word += this.value.charAt(i);
            } else {
                parts[partIndex++] = word;
                word = "";
            }
        }
        parts[partIndex] = word;
        return parts;
    }

    //Max Repeating Word 
    public char getMaxRepeatingCharacter(){
        int n = this.value.length();
        if (n == 0) return ' ';
        int maxCount = 1;
        int count = 1;
        char maxChar = this.value.charAt(0);
        for (int i = 1; i < n; i++) {
            if (this.value.charAt(i) == this.value.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = this.value.charAt(i);
            }
        }
        return maxChar;
    }

    //Sort function
    public String getSortedString(){
        char[] sorted = this.value.toCharArray();
        for(int i=0;i<sorted.length -1;i++){   //sorted.length is not a function (it’s a field).
                for(int j=0;j<sorted.length -i -1;j++){
                    if(sorted[j]>sorted[j+1]){
                        char temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
        }
        return new String(sorted);
    }

    //Shift function
    public String getShiftedString(int position , char direction){
        int n = this.value.length();
        position = position % n;
        String shifted = "";
        if (direction == 'L' || direction == 'l') {
        for (int i = position; i < n; i++) {
            shifted += this.value.charAt(i);
        }
        for (int i = 0; i < position; i++) {
            shifted += this.value.charAt(i);
        }
    } else if (direction == 'R' || direction == 'r') {
        for (int i = n - position; i < n; i++) {
            shifted += this.value.charAt(i);
        }
        for (int i = 0; i < n - position; i++) {
            shifted += this.value.charAt(i);
        }
    } else {
        System.out.println("Invalid direction! Use L or R only.");
        return shifted;
    }
        this.value=shifted;
        return this.value;
    }

    // Reverse Function
    public String getReverseString(){
        char[] reversed = this.value.toCharArray();
        int start=0 , end=this.value.length()-1;
        while(start < end){
            char temp = reversed[start];
            reversed[start] = reversed[end];
            reversed[end] = temp;
            start++;
            end--;
        }
        return new String(reversed);
    }
}
