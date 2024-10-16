import java.util.*;

public class removedupli {
    public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
                int n=sc.nextInt();
                int arr[]=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=sc.nextInt();
                }
                int newLength = removeDuplicates(arr,n);
                for (int i = 0; i < newLength; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
    public static int removeDuplicates(int[] arr ,int n) {
        if (arr.length == 0) return 0;
        
        int index = 1; 
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
             arr[index] = arr[i];
             index++;
            }
        }
        return index;
    }
        
}

