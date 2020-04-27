package leetcode_30_days_challenge.day1;

class LC136SingleNumber {
    //Given a non-empty array of integers, every element appears twice except for one. Find that single one.
    //Example 1: Input: [2,2,1] Output: 1 Example 2: Input: [4,1,2,1,2] Output: 4

    //Solution: bit manipulation XOR:
    // If we take XOR of zero and some bit, it will return that bit
    //If we take XOR of two same bits, it will return 0
    int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
