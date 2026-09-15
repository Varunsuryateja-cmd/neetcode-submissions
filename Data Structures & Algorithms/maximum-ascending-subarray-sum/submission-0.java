class Solution {
        public int maxAscendingSum(int[] nums) {
                int currentSum = nums[0];
                        int maxSum = nums[0];

                                for (int i = 1; i < nums.length; i++) {

                                            // If current element is greater, continue ascending subarray
                                                        if (nums[i] > nums[i - 1]) {
                                                                        currentSum += nums[i];
                                                                                    } 
                                                                                                // Otherwise, start a new ascending subarray
                                                                                                            else {
                                                                                                                            currentSum = nums[i];
                                                                                                                                        }

                                                                                                                                                    // Update maximum sum
                                                                                                                                                                maxSum = Math.max(maxSum, currentSum);
                                                                                                                                                                        }

                                                                                                                                                                                return maxSum;
                                                                                                                                                                                    }
                                                                                                                                                                                    }
