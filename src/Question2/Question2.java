package Question2;

public class Question2{
	static void merge(int[] arr, int M) {
		int N = arr.length;
		int block_amount = N/M;
		
		for (int i = 0; i < N; i+=M) {
			int low = i;
			for (int j = i+1; j >0; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		for (int i = 1; i < block_amount; i++) {
			int start1 = 0;
			int start2 = start1+(i*M);
			int[] merged = new int[(i+1)*M];
			for(int j = 0; j < (i+1)*M; j++) {
				if (arr[start1] <= arr[start2]) {
					merged[j] = arr[start1];
					start1++;
				}
				else {
					merged[j] = arr[start2];
					start2++;
				}
			}
			for (int j = 0; j < (i+1)*M; j++) {
				arr[j] = merged[j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4,7,6,5,9,8,1,2,10,12,3,11};
		merge(array, 3);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}