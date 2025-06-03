package Question1;

public class Question1{
	
	public static void ScoreArrange(int[] scores, int start, int end) {
		if (start >= end) {
			return;
		}
		
		if (scores[start]%2 != 0) {
			ScoreArrange(scores, start+1, end);
		}
		else if (scores[end]%2 == 0){
			ScoreArrange(scores, start, end-1);
		}
		else {
			int temp = scores[start];
			scores[start] = scores[end];
			scores[end] = temp;
			ScoreArrange(scores, start+1, end-1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,34,76,5,34,56,67,90,43};
		ScoreArrange(array, 0, array.length -1);
		for (int i = 0; i<array.length; i++) {
			System.out.println(array[i]);
		}
 	}
}