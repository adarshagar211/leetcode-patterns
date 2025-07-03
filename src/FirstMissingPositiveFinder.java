import java.util.PriorityQueue;

public class FirstMissingPositiveFinder {

    // TODO: Implement this method in O(n) time and constant space
    public static int firstMissingPositive(int[] nums) {
         int  k = 2 ; 
    	 PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> a.compareTo(b));
         for(int num: nums){
             queue.offer(num);
             if(queue.size() > k)
             queue.poll();
         }
          
    	return queue.peek();
    }

    public static void main(String[] args) {
        int[][] testInputs = {
            {1, 2, 0},                 // 3
            {3, 4, -1, 1},             // 2
            {7, 8, 9, 11, 12},         // 1
            {1},                       // 2
            {-1, -2},                  // 1
            {2, 1},                    // 3
            {1, 1, 1, 1},              // 2
        };

        int[] expectedOutputs = {3, 2, 1, 2, 1, 3, 2};

        for (int i = 0; i < testInputs.length; i++) {
            try {
                int result = firstMissingPositive(testInputs[i]);
                System.out.printf("Test %d: Expected = %d, Got = %d → %s%n",
                    i + 1, expectedOutputs[i], result,
                    (result == expectedOutputs[i] ? "PASS" : "FAIL"));
            } catch (UnsupportedOperationException e) {
                System.out.printf("Test %d: Method not implemented yet.%n", i + 1);
            }
        }
    }
}
