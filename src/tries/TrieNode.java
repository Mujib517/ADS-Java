package tries;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public boolean isWord;
    public Map<Character, TrieNode> children;

    public TrieNode() {
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(boolean isWord) {
        this.isWord = isWord;
        children = new HashMap<Character, TrieNode>();
    }
}
