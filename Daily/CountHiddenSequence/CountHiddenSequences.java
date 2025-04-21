package Daily.CountHiddenSequence;

import java.util.Scanner;

public class CountHiddenSequences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        do{
            String input = scanner.nextLine();
            String[] words = input.split(" ");
            for (String word : words) {
                System.out.println(word);
            }
            String[] arrString = words[0].replaceAll("\\[", "")
            .replaceAll("]", "")
            .split(",");

            int[] arr = new int[arrString.length];
            for (int i = 0; i < arrString.length; i++) {
                arr[i] = Integer.parseInt(arrString[i]);
            }
            System.out.println(numberOfArrays(arr, Integer.parseInt(words[1]), Integer.parseInt(words[2])));
        }while(scanner.hasNextLine());
        scanner.close();
    }
    
    public static int numberOfArrays(int[] differences, int lower, int upper) {
        // Calculate the minimum and maximum possible values of the first element
        long min = 0;
        long max = 0;
        long sum = 0;
        
        for (int i = 0; i < differences.length; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        
        // Calculate the range of possible values for the first element
        long rangeMin = lower - min;
        long rangeMax = upper - max;
        
        // Calculate the number of valid starting points
        return (int) Math.max(0, rangeMax - rangeMin + 1);
    }

    //Brute force
    // Time complexity: O(n*m)
    public static int numberOfArraysbrute(int[] differences, int lower, int upper) {
        int count = 0;
        for(int i = lower;i<=upper;i++){
            int sum = i;
            for(int j = 0;j<differences.length;j++){
                sum += differences[j];
                if(sum < lower || sum > upper){
                    break;
                }
                if(j == differences.length - 1){
                    count++;
                }
            }
        }
        return count;
    }
}
