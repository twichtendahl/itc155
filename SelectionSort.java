
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortMe = {9, 8, 10, 7, 1, 4, 3, 5, 2, 6};
		reverseSort(sortMe);
		for(int i = 0; i < sortMe.length; i++) {
			System.out.println(i + " => " + sortMe[i]);		
		}
	}
	
	public static void reverseSort(int[] sortMe) {
		for(int i = sortMe.length - 1; i > 0; i--) {
			// Find the largest element and swap its index with element at i.
			int largest = i;
			for(int j = i - 1; j >= 0; j--) {
				if(sortMe[j] > sortMe[largest]) {
					largest = j;
				}
			}
			swap(sortMe, largest, i);
		}
	}
	
	public static void swap(int[] a, int index1, int index2) {
		if(index1 == index2) {
			return;
		} else {
			int storage = a[index1];
			a[index1] = a[index2];
			a[index2] = storage;
		}
	}

}
