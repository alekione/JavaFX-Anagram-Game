import java.util.Random;

/**
 * 
 * @author Alex M.
 * Create a game and set different levels of difficulty.
 *
 */

public class CreateLevel {
	
	/**
	 * create a list of words, in this case 100 words.
	 * @return word at a certain index given by a static counter which automatically resets,
	 *   when all words are used.
	 */
	
	protected static String word() {
		String[] word = {"petition", "isolated", "geneva", "heat", "zealand", "green", 
					"configuration", "venezuela", "females", "dover", "installing", 
						"expectations", "boston", "plasma", "worry", "colorado", "prostores", 
					"compliance", "vehicles", "killed", "aquatic", "knight", "committed", 
					"representative", "excitement", "plot", "everyday", "orientation", 
					"header", "chicken", "shannon", "dark", "bush", "luke", "paperback", 
					"wash", "lines", "offer", "composite", "comp", "visa", "pain", 
					"instantly", "telephone", "harassment", "belfast", "talented", 
					"rich", "alien", "everyone", "formats", "extensive", "voters", 
					"electricity", "roommate", "occasional", "climbing", "delta", "invited", 
					"diverse", "organisations", "threshold", "derek", "mail", "pamela", 
					"jessica", "focusing", "fairfield", "sixth", "threats", "radius", "tired", "filters", 
					"naturally", "eric", "concept", "genome", "shark", "footwear", "personalized", 
					"edwards", "coins", "shall", "oclc", "sagem", "integral", "aruba", "repair", "wallpapers", 
					"walk", "canon", "dome", "advance", "special", "guam", "inspector", "photographers", "owen", 
					"recreation", "quarterly"};
		Random rand = new Random();
		int num = rand.nextInt(word.length - 1);
		return word[num];
	}
	
	/**
	 * create a simple level with characters removed from word
	 *   randomly.
	 * @return word with spaces/blanks to fill.
	 */
	
	static String createSimpleLevel(String word) {
		Random rand = new Random();
		String newWord = "";
		if (word.length() <= 5) {
			int space1 = rand.nextInt(word.length() - 1);
			for (int i = 0; i < word.length(); i++) {
				if ((space1 == i)) 
					newWord += "_";
				else
					newWord += word.charAt(i);
			}
			return newWord;
		}
		else {
			int space1 = rand.nextInt(word.length() - 1);
			int space2 = rand.nextInt(word.length() - 1);
			for (int i = 0; i < word.length(); i++) {
				if ((space1 == i) || (space2 == i)) 
					newWord += "_";
				else
					newWord += word.charAt(i);
			}
			return newWord;
		}
	}
	
	/**
	 * create a moderate level word, i.e., with more number of blanks.
	 * @return word created.
	 */
	static String createModerateLevel(String word) {
		Random rand = new Random();
		String newWord = "";
		if (word.length() <= 5) {
			int space1 = rand.nextInt(word.length() - 1);
			int space2 = rand.nextInt(word.length() - 1);
			for (int i = 0; i < word.length(); i++) {
				if ((space1 == i) || (space2 == i)) 
					newWord += "_";
				else
					newWord += word.charAt(i);
			}
			return newWord;
		}
		else {
			int space1 = rand.nextInt(word.length() - 1);
			int space2 = rand.nextInt(word.length() - 1);
			int space3 = rand.nextInt(word.length() - 1);
			for (int i = 0; i < word.length(); i++) {
				if ((space1 == i) || (space2 == i) || (space3 == i)) 
					newWord += "_";
				else
					newWord += word.charAt(i);
			}
			return newWord;
		}
	}
	
	/**
	 * create a hard level game. It consists of long words and more spaces.
	 * @return word created.
	 */
	static String createHardLevel(String word) {
		Random rand = new Random();
		String newWord = "";
		int space1 = rand.nextInt(word.length() - 1);
		int space2 = rand.nextInt(word.length() - 1);
		int space3 = rand.nextInt(word.length() - 1);
		int space4 = rand.nextInt(word.length() - 1);
		for (int i = 0; i < word.length(); i++) {
			if ((space1 == i) || (space2 == i) || (space3 == i) || (space4 == i)) 
				newWord += "_";
			else
				newWord += word.charAt(i);
		}
		return newWord;
	}
}

