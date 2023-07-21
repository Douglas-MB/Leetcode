public sealed interface Leetcode permits FirstTry, OtherSTries {
	int[] twoSum(int[] nums, int target);
	boolean isPalindrome(int x);
	int romanToInt(String romanNum);
	String longestCommonPrefix(String[] test);
	boolean isValid(String s);

	int removeDuplicates(int[] nums);
	int removeElement(int[] nums, int val);

	int strStr(String haystack, String needle);

	int searchInsert(int[] nums, int target);
	int lengthOfLastWord(String s);

	int[] plusOne(int[] digits);

	String addBinary(String a, String b);
}
