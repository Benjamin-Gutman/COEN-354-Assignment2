package Question3;

public class Question3{
	
	//There is a typo in the question description so these are the assumptions being made
	//Lower ranking is for a lower score. if employee a has score 9, b with 5 and c with 10
	//the order will b->a->c (0,1,2)
	
	
	// as well, if there are multiple of the same number, each employee of the same number will receive
	//the smallest value and the later employees will be accounted for like in sports
	//eg 1, 2, 2, 4, 5, 6, 7, 7, 7, 10
	static int[] employeeRankings(int[] scores) {
		int N = scores.length;
		int[] copy = new int[N];
		int[] aux = new int[N];
		int[] rankings = new int[N];
		for (int i = 0; i < N; i++) {
			copy[i] = scores[i];
		}
		for (int i = 1; i < N; i = i+i) {
			int k = 0;
			for (int j = 0 ;j<N; j += i+i) {
				int low = j;
				int high = 0;
				int mid = 0;
				if ((j + 2*i) <N) {
					high = j+2*i;
				}
				else {
					high = N;
				}
				if ((j + i ) < N) {
					mid = j+i;
				}
				else {
					mid = N;
				}
				int low2 = mid;
				while (low < mid && low2 < high) {
					if (copy[low] < copy[low2]) {
						aux[k++] = copy[low++];
					}
					else {
						aux[k++] = copy[low2++];
					}
				}
				while (low < mid) {
					aux[k++] = copy[low++];
				}
				while (low2<high) {
					aux[k++] = copy[low2++];
				}
			}
			for (int j = 0; j < N; j++) {
				copy[j] = aux[j];
			}
		}
		for (int i =0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if (scores[i] == copy[j]) {
					rankings[i] = j;
					break;
				}
			}
		}
		return rankings;
	}
	
	
	public static void main(String[] args) {
		int[] scores = {5,4,9,8,6,0,2,1,4,4,6,7,4};
		int[] results = employeeRankings(scores);
		for(int i = 0; i <results.length; i++) {
			System.out.println(results[i]);
		}
		
		
	}
	
	
}