import java.util.Arrays;

public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        System.out.println(solution.canBeEqual(target1, arr1));  // Output: true

        int[] target2 = {7};
        int[] arr2 = {7};
        System.out.println(solution.canBeEqual(target2, arr2));  // Output: true

        int[] target3 = {3, 7, 9};
        int[] arr3 = {3, 7, 11};
        System.out.println(solution.canBeEqual(target3, arr3));  // Output: false
    }
}
