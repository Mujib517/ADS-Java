package tries;


public class TRIE {

    TrieNode root;

    public TRIE() {
        root = new TrieNode();
    }

    public void add(String str) {

        TrieNode temp = root;

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (!temp.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                temp.children.put(c, node);
                temp = node;
            } else temp = temp.children.get(c);
        }

        temp.isWord = true;
    }

    public void addRecursive(String str) {
        addRecursive(str, root, 0);
    }

    public boolean findRecursive(String word) {
        return findRecursive(word, root, 0);
    }

    public boolean find(String str) {
        TrieNode temp = root;

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!temp.children.containsKey(c)) return false;
            temp = temp.children.get(c);
        }
        return temp.isWord;
    }

    public void delete(String str) {
        delete(root, str, 0);
    }

    private void addRecursive(String word, TrieNode current, int idx) {
        if (idx == word.length()) {
            current.isWord = true;
            return;
        }

        char ch = word.charAt(idx);
        TrieNode nd = null;

        if (!current.children.containsKey(ch)) {
            nd = new TrieNode();
            current.children.put(ch, nd);
        } else nd = current.children.get(ch);

        addRecursive(word, nd, idx + 1);
    }

    private boolean findRecursive(String word, TrieNode current, int idx) {
        if (idx == word.length()) return current.isWord;

        char ch = word.charAt(idx);
        if (!current.children.containsKey(ch)) return false;
        TrieNode nd = current.children.get(ch);
        return findRecursive(word, nd, idx + 1);
    }

    private void delete(TrieNode current, String str, int idx) {
        if (idx == str.length()) {
            current.isWord = false;
            return;
        }

        char ch = str.charAt(idx);
        TrieNode nd = current.children.get(ch);
        if (nd == null) return;
        delete(nd, str, idx + 1);
        if (nd.children.size() == 0) nd.children.remove(ch);
    }
}
