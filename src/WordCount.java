import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyStore.Entry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCount {

	public static void main(String args[]) throws Exception {
		Map<String, Integer> occurrence = new LinkedHashMap<String, Integer>();
		FileReader fr = new FileReader("macbeth.txt");
		BufferedReader br = new BufferedReader(fr);
		for (String macbeth; (macbeth = br.readLine()) != null;) {
			StringTokenizer st = new StringTokenizer(macbeth, ",.?:;!' - ");
			while (st.hasMoreTokens()) {
				String word = st.nextToken().toLowerCase();
				if (word.length() > 4) {
					if (occurrence.get(word) == null)
						occurrence.put(word, 1);
					else
						occurrence.put(word, occurrence.get(word) + 1);
				}
			}
		}
		secondCommonWord(occurrence);
	}

	private static void secondCommonWord(Map<String, Integer> occurrence) {
		int first = 0;
		int second = 0;
		for (int wordCount : occurrence.values()) {
			if (first < wordCount) {
				second = first;
				first = wordCount;
			} else if (second < wordCount) {
				second = wordCount;
			}
		}
		for (java.util.Map.Entry<String, Integer> entry : occurrence.entrySet()) {
			if (entry.getValue().equals(second)) {
				System.out.println(
						"Second most Common Word in MacBeth is: " + entry.getKey() + " at " + entry.getValue());
			}
		}
	}
}
