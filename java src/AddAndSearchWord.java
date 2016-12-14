/*
 * Add and Search Word - Data structure design
 * Tag: Trie
 * Tag: Backtracking
 * Tag: Design
 */
import java.util.*;

class TrieNode {
    boolean hasWord;
    Map<Character, TrieNode> mp;
    public TrieNode() {
        hasWord = false;
        mp = new HashMap<Character, TrieNode>();
    }
}

public class AddAndSearchWord {
    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i <= word.length() - 1; i ++) {
            char c = word.charAt(i);
            if(!cur.mp.containsKey(c))
                cur.mp.put(c, new TrieNode());
            cur = cur.mp.get(c);
        }
        cur.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchFromStart(word, root, 0);
    }
    
    // check whether substring of word from s exists after parNode
    private boolean searchFromStart(String word, TrieNode parNode, int s) {
        // Note: type: when s = word.length(), parNode is the node for last character, 
        // check whether we have word ending there
        if(s == word.length()) return parNode.hasWord;
        if(word.charAt(s) != '.') {
            TrieNode next = parNode.mp.get(word.charAt(s));
            return next != null && searchFromStart(word, next, s + 1);
        }
        else {
            for(Character c : parNode.mp.keySet()) 
                if(searchFromStart(word, parNode.mp.get(c), s + 1)) return true;
            return false;
        }
    }
}
