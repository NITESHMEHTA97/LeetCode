package Daily.RabbitInForest;

import java.util.HashMap;

public class RabbitInForest {
    
    public static void main(String[] args) {
        int[] answers = {1, 1, 1, 1, 2, 2};
        System.out.println(numRabbits(answers));
    }
    
    public  static int numRabbits(int[] answers) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            if (map.containsKey(answers[i])) {
                map.put(answers[i], map.get(answers[i]) + 1);
            } else {
                map.put(answers[i], 1);
            }
        }
        for (int key : map.keySet()) {
            int num = map.get(key);
            if (num % (key + 1) == 0) {
                count += num;
            } else {
                // If the number of rabbits is not a multiple of (key + 1), we need to take ceiling of the division
                // and multiply by (key + 1) to get the total number of rabbits
                count += ((num / (key + 1)) + 1) * (key + 1);
            }
        }
        return  count;
    }

}
