class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two runners in the cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find the entrance to the cycle (the duplicate number)
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        
        return slow;
    }
}