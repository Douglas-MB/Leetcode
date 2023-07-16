import java.util.HashMap;

public class Selector {

	private Selector(){}
	private final HashMap<String, Object> functionList = new HashMap<>();


	public void add(String tag, Object aux){
		functionList.put(tag, aux);
	}

	public HashMap<String, Object> getFunctionList() {
		return functionList;
	}
}
