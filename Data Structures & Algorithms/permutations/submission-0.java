class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> currentPath, boolean[] visited, List<List<Integer>> result) {
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            currentPath.add(nums[i]);
            
            backtrack(nums, currentPath, visited, result);
            
            currentPath.remove(currentPath.size() - 1);
            visited[i] = false;
        }
    }
}