public class SupportFunctions<T> {

	private SupportFunctions(){}
	public static boolean checkMatchPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
	}

	public static <T extends Comparable<T>> int binarySearch(T[] array, T target) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid].equals(target)) {
				return mid;
			} else if (array[mid].compareTo(target) < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}



}
