public class sisara { // Search in Sorted and Rotated Array

    // input -> sorted rotated array with distinct numbers (in ascendong order).
    // It is rotated at pivot point. Find the index of the given element

    public static int search(int a[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2; // (si+ei)/2

        // case found
        if (a[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (a[si] <= a[mid]) {
            // case a : left
            if (a[si] <= tar && tar <= a[mid]) {
                return search(a, tar, si, mid - 1);
            } else {
                // case b : right
                return search(a, tar, mid - 1, ei);
            }
        } else {
            // mid on L2
            if (a[mid] <= tar && tar <= a[ei]) {
                // case c : right
                return search(a, tar, si, mid + 1);
            } else {
                // case d : left
                return search(a, tar, si, mid - 1);
            }
        }

    }

    public static void main(String[] args) {

        int a[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0; // output -> 4
        int tarIdx = search(a, target, 0, a.length - 1);
        System.out.println(tarIdx);

    }

}
