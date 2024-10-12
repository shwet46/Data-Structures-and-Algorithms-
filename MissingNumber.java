import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        long totalSum = (long) n * (n + 1) / 2;
        
        long arrSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arrSum += sc.nextInt();
        }
    
        long missingNumber = totalSum - arrSum;
        
        System.out.println(missingNumber);
        
        sc.close();
    }
}
