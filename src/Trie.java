/**
 * Created by alpb0130 on 2/26/16.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null) return;
        if (word.equals("")) {
            root.sentinel = true;
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.c = c;
            if (i == word.length() - 1)
                node.sentinel = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null) return false;
        if (word.equals("") && root.sentinel == true) return true;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
            if ((i == word.length() - 1) && (node.sentinel == true)) {
                return true;
            }
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) return true;
        if (prefix.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.next[c - 'a'] == null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }

    class TrieNode {
        boolean sentinel;
        char c;
        TrieNode[] next = new TrieNode[26];

        // Initialize your data structure here.
        public TrieNode() {
            sentinel = false;
            for (TrieNode node : next)
                node = null;
        }
    }
}

//class TrieNode {
//
//    TrieNode[] next = new TrieNode[26];
//    boolean sentinel;
//    // Constructor
//    public TrieNode() {
//    }
//}
//
//public class Trie {
//
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    // Inserts a word into the trie.
//    public void insert(String word) {
//        insert(word.toCharArray(), 0, root);
//    }
//
//    public void insert(char[] word, int i, TrieNode node) {
//
//        if (i == word.length) {
//            node.sentinel = true;
//            return;
//        }
//
//        char c = word[i];
//        if (node.next[c - 'a'] == null) {
//            node.next[c - 'a'] = new TrieNode();
//        }
//
//        insert(word, i + 1, node.next[c - 'a']);
//    }
//
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//        return search(word.toCharArray(), 0, root);
//    }
//
//    public boolean search(char[] word, int i, TrieNode node) {
//
//        if (i == word.length) {
//            return node.sentinel;
//        }
//
//        char c = word[i];
//
//        return node.next[c - 'a'] != null && search(word, i + 1, node.next[c - 'a']);
//    }
//
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix) {
//        return startsWith(prefix.toCharArray(), 0, root);
//    }
//
//    public boolean startsWith(char[] word, int i, TrieNode node) {
//
//        if (i == word.length) {
//            return true;
//        }
//
//        char c = word[i];
//        return node.next[c - 'a'] != null && startsWith(word, i + 1, node.next[c - 'a']);
//    }
//}
