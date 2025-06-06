package Question2;

public class Question2{
	
	//This program partitions the main array into N/M blocks of size N.
	//These blocks will have merge sort implemented onthem individually to bring the smallest element
	//of each block to the start. Selection sort will then be implemented to sort the blocks by their
	//smallest value. Then, the blocks will merge. once two blocks merge, the partitions are kept in mind
	//and used as reference for future merges. Merge the first with the second, second with the third etc
	//Once you've merged all the blocks together going forward, repeat the process backwards to move smaller
	//elements to the front. This method allows the use of an auxiliary array of only size M each time,
	// even if it is smaller than N/M.
	
	static void subMerge(int[] arr, int start, int M) {
		int[] aux = new int[M];
		for (int i = 1; i < M; i = i+i) {
			for (int j = 0 ;j<M; j += i+i) {
				int low = j;
				int high = 0;
				int mid = 0;
				if ((j + 2*i) < M) {
					high = j+2*i;
				}
				else {
					high = M;
				}
				if ((j + i ) < M) {
					mid = j+i;
				}
				else {
					mid = M;
				}
				int low2 = mid;
				int k = 0;
				while (low < mid && low2 < high) {
					if (arr[low + start] < arr[low2+start]) {
						aux[k++] = arr[low+start];
						low++;
					}
					else {
						aux[k++] = arr[low2+start];
						low2++;
					}
				}
				while (low < mid) {
					aux[k++] = arr[low+start];
					low++;
				}
				while (low2<high) {
					aux[k++] = arr[low2+start];
					low2++;
				}
				int index = 0;
				for (int q = j; q < high; q++) {
					arr[start+q] = aux[index++];
				}
			}
		}
	}

	
	static void blockSelection(int[] arr, int M) {
		int[] aux = new int[M];
		for(int i = 0; i < arr.length; i+=M) {
			for(int j = i+M; j < arr.length; j+=M) {
				if(arr[j] < arr[i]) {
				for(int k = 0; k<M; k++) {
					aux[k] = arr[i+k];
				}
				for(int k = 0; k <M; k++) {
					arr[k+i] = arr[k+j];
					arr[j+k] = aux[k];
				}
			}
		
			}

				
		}	
			

	}
	
	static void blockMerge(int arr[], int M) {
		int[] aux = new int[M];
		for (int i = 0; i < (arr.length/M)-1; i++) {
			int low = i*M;
			int mid = low+M;
			int high = mid+M;
				
				
			int low2 = mid;
			int k = 0;
			for(int n = 0; n < M; n++) {
				aux[n] = arr[low+n];
				}
			while (k < M && low2 < high) {
				if (aux[k] < arr[low2]) {
					arr[low++] = aux[k++];
				}
				else {
					arr[low++] = arr[low2++];
				}
			}
			while (k < M) {
				arr[low++] = aux[k++];
			}
			while (low2<high) {
				arr[low++] = arr[low2++];
			}
		}
		for (int i = (arr.length/M)-2; i >=0; i--) {
			int low = i*M;
			int mid = low+M;
			int high = mid+M;
				
				
			int low2 = mid;
			int k = 0;
			for(int n = 0; n < M; n++) {
				aux[n] = arr[low+n];
				}
			while (k < M && low2 < high) {
				if (aux[k] < arr[low2]) {
					arr[low++] = aux[k++];
				}
				else {
					arr[low++] = arr[low2++];
				}
			}
			while (k < M) {
				arr[low++] = aux[k++];
			}
			while (low2<high) {
				arr[low++] = arr[low2++];
			}
		}
		
		

	}
	static void sort(int[] arr, int M) {
		int N = arr.length;
		int block_amount = N/M;
		for (int i = 0; i < block_amount; i++) {
			subMerge(arr, i*M, M);
		}
		blockSelection(arr, M);
		blockMerge(arr, M);
	}
	
	public static void main(String[] args) {
		int[] array = {4,7,6,5,9,8,2,1,12,10,11,3};
		sort(array, 4);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}