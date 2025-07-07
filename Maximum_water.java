package array;


class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int maxWater = 0;

        while(start < end){
            int length = end - start;
            int minHeight = Math.min(height[start], height[end]);
            int area = length * minHeight;
            maxWater = Math.max(maxWater,area);
        if(height[start] < height[end]){
            start ++;
        } else {
            end--;
         }
        }
        return maxWater;
    }
}