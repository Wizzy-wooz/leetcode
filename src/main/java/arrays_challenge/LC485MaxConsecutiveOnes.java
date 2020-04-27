package arrays_challenge;

public class LC485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, currentMax = 0;
        for(int num : nums){
            currentMax = num == 1? currentMax + 1 : 0;
            max = Math.max(max, currentMax);
        }
        return max;
    }
}
