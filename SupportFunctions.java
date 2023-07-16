public class SupportFunctions {

	private SupportFunctions(){}
	public static boolean checkMatchPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
	}
}
