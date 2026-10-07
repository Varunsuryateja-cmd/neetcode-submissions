class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
                int n = temperatures.length;
                        int[] result = new int[n];

                                java.util.ArrayDeque<Integer> stack = new java.util.ArrayDeque<>();

                                        for (int i = 0; i < n; i++) {

                                                    while (!stack.isEmpty() &&
                                                                       temperatures[i] > temperatures[stack.peek()]) {

                                                                                       int prev = stack.pop();
                                                                                                       result[prev] = i - prev;
                                                                                                                   }

                                                                                                                               stack.push(i);
                                                                                                                                       }

                                                                                                                                               return result;
                                                                                                                                                   }
                                                                                                                                                   }
