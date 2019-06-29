package MySolutions.LeetCodeGoogleExplore;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        if(height == null || height.length == 1) return maxArea;

        for(int li=0, ri=height.length-1; li<ri;)
        {
            maxArea = Math.max(maxArea, (ri-li) * Math.min(height[li],height[ri]));
            if(height[li] > height[ri]) ri--;
            else li++;
        }
        return maxArea;
    }
}
