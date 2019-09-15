add_and_search_word.java 
class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int index) {
        if (word == null || word.length() == 0) return false;
        if (index == word.length()) return node.isEnd;
        char c = word.charAt(index);
        if (node.children.containsKey(c)) {
            return searchHelper(word, node.children.get(c), index + 1);
        } else if (c == '.') {
            for (char x : node.children.keySet()) {
                if (searchHelper(word, node.children.get(x), index + 1)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
