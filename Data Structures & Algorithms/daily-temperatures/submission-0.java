class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //[30(0), 38(1) -> [38(1)  res[0] = 1  
        //[38(1), 30(2), 36(3) -> [38, 36  res[2] = 3 - 2 = 1
        //[38(1), 36(3), 35(4), 40(5) -> [40   res[4] = 1, res[3] = 2, res[1] = 4 
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
