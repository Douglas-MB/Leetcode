import java.util.HashMap;
import java.util.Map;

public non-sealed class FirstTry implements Leetcode{

	@Override
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();

		int aux = Math.max(a.length(), b.length());
		int carry = 0;

		for (int i = 0; i < aux; i++) {
			int charA = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			int charB = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;

			int sum = charA ^ charB ^ carry;
			carry = (charA & charB) | (charA & carry) | (charB & carry);

			result.insert(0, (char) (sum + '0'));
		}

		if (carry == 1) {
			result.insert(0, '1');
		}

		return result+"";
	}


	@Override
	public int lengthOfLastWord(String s) {
		if (s.length() == 1){
			return 1;
		}
		int i = 0;
		int cntChar = 0;

		while ( i++ < s.length() ){
			if (s.charAt(s.length() - i) != 32 ){
				cntChar++;
			}
			if (s.charAt(s.length() - i) == 32 && cntChar > 0 ){
				break;
			}
		}
		return cntChar;
	}

	@Override
	public int[] plusOne(int[] digits) {

		if (digits.length == 1 && digits[0] == 9){
			digits = new int[digits.length + 1];
			digits[0] = 1;
			digits[1] = 0;
			return digits;
		}
		if (digits[digits.length - 1] != 9){
			digits[digits.length - 1]++;
			return digits;
		}
		for (int i = digits.length - 1; i > 0 ; i--) {
			if (digits[i] == 9){
				digits[i] = 0;
			}
			if (digits[i] == 0 && digits[i - 1] != 9){
				digits[i - 1]++;
				return digits;
			}
			if (i == 1 && digits[i] == 0 && digits[i-1] == 9){
				digits = new int[digits.length + 1];
				digits[0] = 1;
				for (int j = 1; j < digits.length; j++) {
					digits[j] = 0;
				}
			}
		}

		return digits;
	}

	@Override
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left <= right) {
			mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}


		if (target > nums[mid]){
			return mid + 1;
		}
		if (target < nums[mid]){
			return mid;
		}
		return -1;
	}

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
