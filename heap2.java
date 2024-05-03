public class heap2 {

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[right] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, i);
        }
    }

    public static void heapSort(int arr[]) { // time complexity - O(nlogn)
        // step1 - build max heap
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step2 - push the largest at end
        for (int i = n - 1; i >= 0; i--) {
            // swap(largest first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {

        int a[] = { 1, 2, 4, 5, 3 };
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}
