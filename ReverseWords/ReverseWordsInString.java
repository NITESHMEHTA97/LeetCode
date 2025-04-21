package ReverseWords;
import java.util.Scanner;

public class ReverseWordsInString {
    
    public static void main(String[] args) {
        /*String input = "Hello World";
        String reversed = reverseWords(input);
        System.out.println(reversed); // Output: "World Hello"*/
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reversed = reverseWords(input);
        System.out.println(reversed); // Output: "World Hello"
        scanner.close();
    }

    public static String reverseWords(String sentence) {
        int left = 0;
        sentence = sentence.trim();
        StringBuilder result =new StringBuilder();
        for(int right=0;right<sentence.length();right++){
            if(sentence.charAt(right)==' '){
                String word = sentence.substring(left, right);
                result.insert(0, " " + word );
                left = right + 1;
            }
            while(right<sentence.length() && sentence.charAt(right) == ' '){
                right++;
                left=right;
            }
        }
        String lastWord = sentence.substring(left);
        result.insert(0, lastWord);
        return result.toString();
    }
}
