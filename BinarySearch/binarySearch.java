package BinarySearch;

public class binarySearch {

	public static void main(String[] args) {
		int array[] = new int[100];
		for(int i = 0;i<array.length;i++){
			array[i] = i;
		}
		
		System.out.println(recursiveBinarySearch(array,70,0,array.length));
	}
	
	private static boolean recursiveBinarySearch(int[] array,int x,int left, int right){
		int mid = (left + right) / 2;
		if(left > right) return false;
		else if(array[mid] == x) return true;
		else if(array[mid] > x) return recursiveBinarySearch(array,x,left,mid-1);
		else return recursiveBinarySearch(array,x,mid+1,right);
	}
	
	private static boolean binarySearch(int[] array,int x){
		int left = 0,right = array.length-1;
		int mid = (left + right)/2;
		while(left <= right){
			if(array[mid] == x) return true;
			else if(array[mid] > x){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	
}

