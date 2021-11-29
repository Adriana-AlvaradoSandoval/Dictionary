package alvaradoSandoval;

public class DictionaryMain {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		dictionary.addword("money");
		dictionary.addword("kitkat");
		dictionary.addword("frogs");
		dictionary.addword("donut");
		dictionary.addword("tree");
		dictionary.addword("snake");
		dictionary.addword("apple");

		dictionary.removeWord("tree");
		dictionary.displayDictionary();
	}

}
