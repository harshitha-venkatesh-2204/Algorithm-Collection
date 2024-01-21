import java.util.ArrayList;
import java.util.List;

public class SubsetsGenerator {
    public static void main(String[] args) {
        int[] testCases = {3, 5, 7};
        
        for (int n : testCases) {
            List<List<Integer>> subsets = generateSubsets(n);
            int totalSubsets = subsets.size();
            
            System.out.println("Subsets for n=" + n + ":");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
            System.out.println("Total subsets for n=" + n + ": " + totalSubsets);
            System.out.println();
        }
    }
    
    public static List<List<Integer>> generateSubsets(int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(subsets, new ArrayList<>(), 1, n);
        return subsets;
    }
    
    public static void backtrack(List<List<Integer>> subsets, List<Integer> currentSubset, int start, int n) {
        subsets.add(new ArrayList<>(currentSubset));
        
        for (int i = start; i <= n; i++) {
            currentSubset.add(i);
            backtrack(subsets, currentSubset, i + 1, n);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
