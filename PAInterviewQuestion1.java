import java.util.ArrayList;
//Check the common elements in both the arrays
class PAInterviewQuestion1 {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 4, 5, 8 };
		int[] arr2 = { 2, 3, 5, 6, 9 };

		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0, j = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] > arr2[j])
				j++;
			else if (arr1[i] < arr2[j])
				i++;
			else {
				res.add(arr1[i]);
				i++;
				j++;
			}
		}
		System.out.println(res);
	}
}

