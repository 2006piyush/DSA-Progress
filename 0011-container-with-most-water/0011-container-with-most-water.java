class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length-1;
        while(i<j){
            int len = Math.min(height[i], height[j]);
            int bth = j-i;
            int currentArea = len * bth;
            area = Math.max(area,currentArea);
            if (height[i] < height[j]) {
                 i++;
            } else {
                 j--;
             }
        }
        return area;
    }
}