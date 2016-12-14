/*
 * Word Search II
 * Tag: Trie
 * Tag: Backtracking
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

public class WordSearchII {
    TrieNode root = new TrieNode();
    int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> resSet = new HashSet<String>();
        if(board.length == 0 || board[0].length == 0) return new ArrayList<String>();
        int m = board.length, n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        
        for(String word : words) addWord(word);
        for(int i = 0; i <= m - 1; i ++)
            for(int j = 0; j <= n - 1; j ++)
                search(board, visited, i, j, root, new StringBuilder(), resSet);
        return new ArrayList<String>(resSet);
    }
    // check all existing strings with prefix in preStr. Following part is non-visited and STARTS with (r, c) FOLLOWING parNode
    // Correctness: any valid string is an exisiting string, non-visited and with prefix "" under root
    // basic idea: use trie for efficient pruning: if (r, c) is not following parNode, it is invalid
    private void search(char [][] board, boolean [][] visited, int r, int c, TrieNode parNode, StringBuilder preStr, Set<String> resSet) {
        int m = board.length, n = board[0].length;
        TrieNode cur = parNode.mp.get(board[r][c]);
        if(cur == null) return;
        preStr.append(board[r][c]);

        if(cur.hasWord) resSet.add(preStr.toString());
        // Note: type: we only need to update global status before branching
        visited[r][c] = true;
        for(int i = 0; i <= 3; i ++) {
            int newR = r + dirs[i][0], newC = c + dirs[i][1];
            if(valid(m, n, newR, newC) && !visited[newR][newC])
                search(board, visited, newR, newC, cur, preStr, resSet);
        }
        visited[r][c] = false;
        preStr.deleteCharAt(preStr.length() - 1);
    }
    
    private boolean valid(int m, int n, int r, int c) {
        return r >=0 && r < m && c >= 0 && c < n;
    }
    
    private void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i <= word.length() - 1; i ++) {
            char c = word.charAt(i);
            if(!cur.mp.containsKey(c)) cur.mp.put(c, new TrieNode());
            cur = cur.mp.get(c);
        }
        cur.hasWord = true;
    }
}
