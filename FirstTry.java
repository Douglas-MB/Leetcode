import java.util.HashMap;
import java.util.Map;

public non-sealed class FirstTry implements Leetcode{
	@Override
	public int strStr(String haystack, String needle) {

		if (needle.length() > haystack.length()){
			return -1;
		}

		if (needle.length() == haystack.length()){
			if (needle.equals(haystack)){
				return 0;
			}
			return -1;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int k = 0;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)){
					k = j;
					break;
				}
				k = j+1;
			}
			System.out.println(k);
			if(k == needle.length()){
				return i;
			}
			System.out.println("!!! "+i);
		}
		return -1;
	}

	@Override
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int aux = target - num;

			if (hashtable.containsKey(aux)) {
				return new int[]{hashtable.get(aux), i};
			}

			hashtable.put(num, i);
		}

		return new int[0];
	}

	@Override
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}

		int reversed = 0;
		int original = x;

		while (x != 0) {
			reversed = (reversed * 10) + (x % 10);
			x /= 10;
		}

		return original == reversed;
	}

	@Override
	public int romanToInt(String romanNum) {
		Map<Character, Integer> romanValues = new HashMap<>();
		romanValues.put('I', 1);
		romanValues.put('V', 5);
		romanValues.put('X', 10);
		romanValues.put('L', 50);
		romanValues.put('C', 100);
		romanValues.put('D', 500);
		romanValues.put('M', 1000);

		int result = 0;
		int prevValue = 0;

		for (int i = romanNum.length() - 1; i >= 0; i--) {
			char auxChar = romanNum.charAt(i);
			int auxNum = romanValues.get(auxChar);

			if (auxNum < prevValue) {
				result -= auxNum;
			} else {
				result += auxNum;
			}

			prevValue = auxNum;
		}

		return result;
	}

	@Override
	public String longestCommonPrefix(String[] test) {
		if (test == null || test.length == 0) {
			return "";
		}

		for (int i = 1; i < test.length; i++) {
			String key = test[i];
			int j = i - 1;

			while (j >= 0 && test[j].length() > key.length()) {
				test[j + 1] = test[j];
				j--;
			}

			test[j + 1] = key;
		}
		String smallest = test[0];
		StringBuilder commonPrefix = new StringBuilder();

		for (int i = 0; i < smallest.length(); i++) {
			char c = smallest.charAt(i);

			for (int j = 1; j < test.length; j++) {
				if (test[j].charAt(i) != c) {
					return commonPrefix.toString();
				}
			}
			commonPrefix.append(c);
		}

		return commonPrefix.toString();

	}

	@Override
	public boolean isValid(String s) {
		char[] stack = new char[s.length()];
		int top = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack[++top] = c;
			} else if (c == ')' || c == '}' || c == ']') {
				if (top == -1 || ! SupportFunctions.checkMatchPair(stack[top], c)) {
					return false;
				}
				top--;
			}
		}

		return top == -1;
	}

	@Override
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int n : nums){
			if (i == 0 || n != nums[i-1]){
				nums[i++] = n;
			}
		}
		return i;
	}

	@Override
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
}
