//Shortest Completing Word
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
		int len = 0;
		for (char c : licensePlate.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				count[c - 'a']++;
				len++;
			} else if (c >= 'A' && c <= 'Z') {
				count[c - 'A']++;
				len++;
			}
		}

		String res = "";
		for (String word : words) {
			int tLen = len;
			int[] tCount = count.clone();
			for (char c : word.toCharArray()) {
				if (tCount[c - 'a'] > 0) {
					tLen--;
					tCount[c- 'a']--;
				}
			}

			if (tLen == 0 && (res.isEmpty() || res.length() > word.length())) {
				res = word;
			}
		}
		return res;
    }
}





