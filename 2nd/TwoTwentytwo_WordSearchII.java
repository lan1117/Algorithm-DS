package 二刷;
import java.util.*;
public class TwoTwentytwo_WordSearchII {
	class TrieNode{
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	public TrieNode buildTrie(String[] words){
		TrieNode root = new TrieNode();
		for(String s : words){
			TrieNode p = root;
			for(char c : s.toCharArray()){
				int i = c - 'a';
				if(p.next[i] == null) p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = s;
		}
		return root;
	}
	public List<String> findWords(char[][] board, String[] words){
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				dfs(board, root, i, j, res);
			}
		}
		return res;
	}
	public void dfs(char[][] board, TrieNode p, int i, int j, List<String> res){
		char c = board[i][j];
		if(c == '#' || p.next[c - 'a'] == null) return;
		p = p.next[c - 'a'];
		if(p.word != null){
			res.add(p.word);
			p.word = null;
		}
		board[i][j] = '#';
		if(i > 0) dfs(board, p, i - 1, j, res);
		if(i < board.length - 1) dfs(board, p, i + 1, j, res);
		if(j > 0) dfs(board, p, i, j - 1, res);
		if(j < board[0].length - 1) dfs(board, p, i, j+1, res);
		
		board[i][j] = c;
	}
}
