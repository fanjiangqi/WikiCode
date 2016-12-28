import java.util.Scanner;
public class Sort {
	//冒泡排序
	public static void bubbleSort(Comparable[] a){
		for (int i=0;i<a.length;i++ ) 
			for (int j=1;j<a.length-i;j++ ) 
				if(less(a[j],a[j-1])) exch(a,j,j-1);
		
	}
	// 插入排序
	public static void insertionSort(Comparable[] a){
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0 && less(a[j],a[j-1]);j--)
				exch(a,j,j-1);
		}
	}
	 //插入排序，我自己的思路
    	private static void insertionSortFan(Comparable[] a){
		for(int i=1;i<a.length;i++){
		    if(less(a[i],a[i-1])) {
			exch(a,i,i-1);
			for(int j=i-1;j>0;j--){
			    if(less(a[j],a[j-1]))
				exch(a,j,j-1);
			}
		    }

		}
	    }
	
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}

	public static void exch(Comparable[] a, int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		//int length = Integer.parseInt(args[0]); 
		Integer[] a = new Integer[6];
		Scanner in = new Scanner(System.in);
		int i = 0;
		while(in.hasNext()){
			a[i++] = in.nextInt();
		}
		in.close();
		Sort.insertionSort(a);
		for (int j : a) {
			System.out.print(j + " ");
		}
		//System.out.print(a.toString());
	}

}
