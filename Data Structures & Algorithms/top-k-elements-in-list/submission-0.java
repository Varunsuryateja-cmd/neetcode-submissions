class Solution {
        public int[] topKFrequent(int[] nums, int k) {

                HashMap<Integer, Integer> freq = new HashMap<>();

                        // Count frequency
                                for (int num : nums) {
                                            freq.put(num, freq.getOrDefault(num, 0) + 1);
                                                    }

                                                            // Bucket: index = frequency
                                                                    List<Integer>[] bucket = new List[nums.length + 1];

                                                                            for (int num : freq.keySet()) {
                                                                                        int count = freq.get(num);

                                                                                                    if (bucket[count] == null) {
                                                                                                                    bucket[count] = new ArrayList<>();
                                                                                                                                }

                                                                                                                                            bucket[count].add(num);
                                                                                                                                                    }

                                                                                                                                                            // Get top k
                                                                                                                                                                    int[] result = new int[k];
                                                                                                                                                                            int index = 0;

                                                                                                                                                                                    for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

                                                                                                                                                                                                if (bucket[i] != null) {
                                                                                                                                                                                                                for (int num : bucket[i]) {
                                                                                                                                                                                                                                    result[index++] = num;

                                                                                                                                                                                                                                                        if (index == k) {
                                                                                                                                                                                                                                                                                break;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                return result;
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    }

