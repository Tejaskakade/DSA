
import java.util.*;
import java.util.LinkedList;

public class BubbleSort {

       public static void sorting(int[] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>=arr[j+1]){
                    int temp=arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
       }


    public static void main(String[] args) {
        
        int[] arr= {6,8,4,9,2,7,1};
       sorting(arr);
    

    }
    
}