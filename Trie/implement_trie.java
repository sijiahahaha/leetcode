implement_trie.java
class Trie{
    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> children;
        public TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0 || search(word)) return;

        Trie node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) node.children.put(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return ndoe.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }





}