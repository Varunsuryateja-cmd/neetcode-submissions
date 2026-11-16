class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0, result);
        return result;
    }
    
    private void backtrack(int[] nums, int target, int index, List<Integer> current, int currentSum, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (currentSum > target || index == nums.length) {
            return;
        }
        
        current.add(nums[index]);
        backtrack(nums, target, index, current, currentSum + nums[index], result);
        current.remove(current.size() - 1);
        
        backtrack(nums, target, index + 1, current, currentSum, result);
    }
}