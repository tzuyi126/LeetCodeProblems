// 212. Word Search II
// https://leetcode.com/problems/word-search-ii
class TrieNode {
    String word;
    TrieNode[] next = new TrieNode[26];
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, result);
            }
        }
        return result;
    }

    public void dfs(int i, int j, char[][] board, TrieNode cur, List<String> result) {
        char letter = board[i][j];

        if (letter == '#' || cur.next[letter - 'a'] == null) return;

        cur = cur.next[letter - 'a'];

        // Find a word
        if (cur.word != null) {
            result.add(cur.word);

            // Avoid duplicate words
            cur.word = null;
        }

        // Avoid using the same letter in a word
        board[i][j] = '#';

        if (i > 0) dfs(i - 1, j, board, cur, result);
        if (j > 0) dfs(i, j - 1, board, cur, result);
        if (i < board.length - 1) dfs(i + 1, j, board, cur, result);
        if (j < board[0].length - 1) dfs(i, j + 1, board, cur, result);

        // Resume the letter to the board
        board[i][j] = letter;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';
                if (cur.next[index] == null) cur.next[index] = new TrieNode();
                cur = cur.next[index];
            }
            
            cur.word = word;
        }

        return root;
    }
}
