
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codespace
 */
public class CountBadPairs {

/*
Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.
*/
    public static void main(String[] args) {
        int[] nums = {4,1,3,3};
        long count = countBadPairs(nums);
        System.out.println(count);
    }
        
    public static long countBadPairs(int[] nums) {
    long n = nums.length;
    /*
        nums[j] - nums[i] != j-i
        j-nums[j] != i-nums[i]
    */

    /*
    long result = 0;
    for(int i=n-1;i>=0;i--){
            int val = i - nums[i];
        //get the count where j-nums[j] == i-nums[i]
        int count = map.getOrDefault(val,0);
        //add the number of possible pairs till n-i which is (n-i-1) subtracting the no of pairs having same i-nums[i] i.e good pairs
        result+=(n-i-1)-count;
        map.put(val, count+1);
    }
    return result;*/

    HashMap<Integer,Integer> map = new HashMap<>();
    
    long goodPairs = 0;
    long totalPairs = (n*(n-1))/2;
    for(int i=0;i<n;i++){
        int val = i - nums[i];
        int count = map.getOrDefault(val,0);
        goodPairs+=count;
        map.put(val, count+1);
    }
    return totalPairs - goodPairs;
    }
}
