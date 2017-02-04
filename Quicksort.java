import java.util.Scanner;

public class QuickSort implements Runnable{

public static void main(String[] args){

QuickSort qs1=new QuickSort();
QuickSort qs2=new QuickSort();
Thread t1=new Thread(qs1);
Thread t2=new Thread(qs1);
t1.start();
t2.start();


}

public synchronized void run(){
 
read();

}
public synchronized void  read(){
    int n,pivot,low=0;
    int[] A=new int[100];
    System.out.println("Enter the number of elements:");
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    for(int i=0;i<n;++i){
        A[i]=sc.nextInt();
    }
    quicksort(A,low,n-1);
    print(A,n);


}
public synchronized void print(int A[],int n){

    for(int i=0;i<n;++i)
        System.out.print(A[i]+" ");
}

public synchronized void quicksort(int A[],int low,int high)
{
    int i=low,j=high;

    int pivot=A[low+(high-low)/2];
 //  System.out.println("Pivot:"+pivot);
    while(i<=j){

        while(A[i]<pivot){
            i++;


        }
        while(A[j]>pivot)
        {
            j--;
        }
        if(i<=j)
        {
        //      System.out.println("Swapping:"+A[i]+A[j]);
            swap(A,i,j);

            i++;
            j--;
        }



    }
    //System.out.println("j value:"+j+" "+A[j]);
    if(low<j)
        quicksort(A,low,j);
    if(i<high)
        quicksort(A, i, high);


}

static void swap(int A[],int i,int j){
    int temp;
    temp=A[i];
    A[i]=A[j];
    A[j]=temp;


}








}

