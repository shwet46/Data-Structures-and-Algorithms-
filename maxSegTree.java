public class maxSegTree { //Max element segment tree

    static int tree[];

    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildTree(int i, int si, int sj, int arr[]){ //time complexity O(n)
        if(si == sj){
            tree[i] = arr[si];
            return;
        }

        int mid = (si+sj)/2;
        buildTree(2*i+1, si, mid, arr);
        buildTree(2*i+2, mid+1, sj, arr);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);
    }

    public static int getMax(int arr[], int qi, int qj){
        int n = arr.length;
        return getMaxUtil(0, 0, n-1, qi, qj);
    }

    public static int getMaxUtil(int i, int si, int sj, int qi, int qj){ // time complexity O(logn)
        if(si > qj || si< qi){
            return Integer.MIN_VALUE;
        }else if(si >= qi && sj <= qj){
            return tree[i];
        }else{
            int mid = (si+sj)/2;
            int leftAns = getMaxUtil(2*i+1, si, sj, qi, qj);
            int rightAns = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
            return Math.max(leftAns, rightAns);
        }
    }

    public static void update(int arr[], int idx, int newVal){
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n-1, idx, newVal);
    }

    public static void updateUtil(int i, int si, int sj, int idx, int newVal){
        if(idx < si || idx > sj){
            return;
        }

        if(si == sj){
            tree[i] = newVal;
        }
        
        if(si != sj){
            tree[i] = Math.max(tree[i], newVal);
            int mid = (si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, newVal);
            updateUtil(2*i+2, mid+1, sj, idx, newVal);
        }
    }


    public static void main(String[] args) {

        int arr[] = {5, 8, -4, 3, 1, 0, 5, 6};
        int n = arr.length;
        init(n);
        buildTree(0,0,n-1,arr);
        
    }
    
}
