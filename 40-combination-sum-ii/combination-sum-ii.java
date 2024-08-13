import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    void findCombinations(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue; // Skip duplicates

            if (arr[i] > target) break; // No point in continuing if arr[i] is greater than the target

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds); // Move to the next element
            ds.remove(ds.size() - 1); // Backtrack
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the candidates array to handle duplicates easily
        List<List<Integer>> array = new ArrayList<>();
        findCombinations(0, candidates, target, array, new ArrayList<>());

        return array;
    }
}