
public class trappedwater { // calculating the amount of water trapped in between the buildings

    public static int trappedRainWater(int height[]) { // Time complexity => O(n) {the loop runs the number of buildings
                                                       // times}
        int n = height.length;

        // calculate leftmax boundary array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // calculate rightmax boundary array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            // water level = min(leftmax bound, rightmax bound)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
    }

    // code from the notes
    public static int trappedRainWater1(int height[]) {
        int n = height.length;

        int res = 0, l = 0, r = n - 1;

        int rmax = height[r], lmax = height[l];

        while (l < r) {

            if (lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                res += lmax - height[l];
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                res += rmax - height[r];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        int a[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int a2[] = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trappedRainWater(height));
        System.out.println(trappedRainWater1(a));
        System.out.println(trappedRainWater(a2));

    }
}