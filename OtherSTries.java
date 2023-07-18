import java.util.Arrays;

public non-sealed class OtherSTries implements Leetcode{
	@Override
	public int[] twoSum(int[] nums, int target) {
		return new int[0];
	}

	@Override
	public boolean isPalindrome(int x) {
		return false;
	}

	@Override
	public int romanToInt(String romanNum) {
		return 0;
	}

	@Override
	public String longestCommonPrefix(String[] test) {
		return null;
	}

	@Override
	public boolean isValid(String s) {
		return false;
	}

	@Override
	public int removeDuplicates(int[] nums) {
		return 0;
	}

	@Override
	public int removeElement(int[] nums, int val) {
		return 0;
	}

	@Override
	public int searchInsert(int[] nums, int target) {
		return 0;
	}

	@Override
	public int strStr(String haystack, String needle) {

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			StringBuilder aux = new StringBuilder();
			for (int j = 0; j < needle.length(); j++) {
				aux.append(haystack.charAt(i + j));
			}
			if (needle.equals(aux+"")){
				return i;
			}
		}
		return -1;
	}
}
