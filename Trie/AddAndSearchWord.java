package Trie_Tree;
//Design a data structure that supports the following two operations:

//void addWord(word)
//bool search(word)
//search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.


public class AddAndSearchWord {
	class TrieNode{
		boolean word;
		TrieNode[] children;
		public TrieNode(){
			word = false;
			children = new TrieNode[26]; 
		}
	}
	class Trie{
		TrieNode root;
		public Trie(){
			root = new TrieNode();
		}
		public void insert(String word){
			TrieNode cur = root;
			for(char c : word.toCharArray()){
				if(cur.children[c - 'a'] == null){
					cur.children[c - 'a'] = new TrieNode();					
				}
				cur = cur.children[c - 'a'];
			}
			cur.word = true;
		}
		public boolean dfs(String word, TrieNode cur, int idx){
			if(cur == null) return false;
			if(idx == word.length()){
				return cur.word;
			}
			
			char c = word.charAt(idx);
			if(c == '.'){
				for(TrieNode n : cur.children){
					if(dfs(word, n, idx + 1))
						return true;
					return false;
				}
			}
			return dfs(word, cur.children[c - 'a'], idx + 1);
		}
	}
	Trie trie = new Trie();
	public void addWord(String word){
		trie.insert(word);
	}
	public boolean search(String word){
		
		return trie.dfs(word, trie.root, 0);
	}//因为要在这个trie里面找，不是其他任何一个trie，所以search里面的函数一定要trie.root，所以在trie这个class里面的dfs中，要从trie.root的下一位找。
	//即使第一位不在trie里面，那也先循环一遍，直到cur是cur.children里面的数，这个时候再判断cur是不是null（一个边界条件）。
	//因此，要多看一个index，所以这里面另外一个边界条件是idx == length而不是idx = length - 1;
}
