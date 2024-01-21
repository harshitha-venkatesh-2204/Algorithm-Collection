import java.util.*;

public class HowSum {

    public static List<Integer> howSum(int targetSum, int[] numbers) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return howSumHelper(targetSum, numbers, memo);
    }

    private static List<Integer> howSumHelper(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> result = howSumHelper(remainder, numbers, memo);
            if (result != null) {
                result.add(num);
                memo.put(targetSum, result);
                return result;
            }
        }

        memo.put(targetSum, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println("The array elements that add that return target sum are:"); 
        System.out.println(howSum(7, new int[]{2, 3}));  // Output: [3, 2, 2]
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));  // Output: [4, 3]
        System.out.println(howSum(300, new int[]{7, 14}));  // Output: null
    }
}

