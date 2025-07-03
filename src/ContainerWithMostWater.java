
public class ContainerWithMostWater {

    // Function to find max area of water container
    public static int maxArea(int[] height) {
    	
    	int left = 0 ;
    	int right = height.length -1; 
    	int maxArea = 0; 
    	while(left < right) {
    		int area = (right -left) *(Math.min(height[right], height[left]));
    		maxArea = Math.max(maxArea, area);
    		if(height[left] < height[left+1])
    			left ++ ; 
    		else if(height[right] < height[right-1])
    			right--;
    		else {
    			left ++ ; 
    			right--;
    		}
    	}
        // Your implementation here
        return maxArea;
    }

    // Test cases
    public static void main(String[] args) {
        int[] test1 = {1,8,6,2,5,4,8,3,7}; // Expected output: 49
        int[] test2 = {1,1};               // Expected output: 1
        int[] test3 = {4,3,2,1,4};         // Expected output: 16
        int[] test4 = {1,2,1};             // Expected output: 2

        System.out.println(maxArea(test1));
        System.out.println(maxArea(test2));
        System.out.println(maxArea(test3));
        System.out.println(maxArea(test4));
    }
}
