import java.util.*;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long sum = 0;
        int maxReduce = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;

            int index = Arrays.binarySearch(sorted, nums2[i]);

            if (index < 0) {
                index = -index - 1;
            }

            
            if (index < n) {
                maxReduce = Math.max(maxReduce,
                        diff - Math.abs(sorted[index] - nums2[i]));
            }

            
            if (index > 0) {
                maxReduce = Math.max(maxReduce,
                        diff - Math.abs(sorted[index - 1] - nums2[i]));
            }
        }

        return (int)((sum - maxReduce + MOD) % MOD);
    }
}
