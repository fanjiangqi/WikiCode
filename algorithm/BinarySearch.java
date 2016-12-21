import java.util.Scanner;
import java.util.Arrays;
//二分查找
public class BinarySearch{
	private int[] keys;
	//迭代实现
	public static int rankIteration(int key, int[] a){
		int lo = 0;
		int hi = a.length -1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(key < a[mid]) hi = mid -1;
			else if(key > a[mid]) lo = mid +1;
			else return mid;
		}
		return lo;
	} 
	//递归实现
	public int rankRecursion(int key, int lo, int hi){
		if(hi < lo) return lo;
		int mid = lo + (hi-lo)/2;
		if(key < keys[mid]) return rankRecursion(key,lo,mid-1);
		else if(key > keys[mid]) return rankRecursion(key,mid+1,hi);
		else return mid;
	}
	public static void main(String[] args) {
		int[] whitelist = {5,7,12,45,74,89,40};
		Arrays.sort(whitelist);
		BinarySearch bs = new BinarySearch();
		bs.keys = whitelist;
		for(int i:whitelist){
			System.out.print(i + " ");
		}
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		System.out.println(BinarySearch.rankIteration(key,whitelist));
		System.out.println(bs.rankRecursion(key,0,whitelist.length);
		in.close();
		
	}
}