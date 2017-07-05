package 二刷;
import java.util.*;
public class TwoEleven_AddAndSearchWord_DataStructureDesign {
	class TrieNode{
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean hasWord;
		public TrieNode(){
			
		}
		public TrieNode(char c){
			this.c = c;
		}
	}
	TrieNode root;
	public TwoEleven_AddAndSearchWord_DataStructureDesign(){
		root = new TrieNode();
	}
	public void addWord(String word){
		TrieNode cur = root;
		char[] wordArray = word.toCharArray();
		for(int i = 0; i < wordArray.length; i++){
			HashMap<Character, TrieNode> children = cur.children;
			if(children.containsKey(wordArray[i])){
				cur = children.get(wordArray[i]);
			}else{
				children.put(wordArray[i], new TrieNode(wordArray[i]));
				cur = children.get(wordArray[i]);
			}
			if(i == wordArray.length - 1){
				cur.hasWord = true;
			}
		}
	}
	public boolean search(String word){
		TrieNode cur = root;
		return find(word, cur, 0);
	}
	public boolean find(String word, TrieNode cur, int idx){
		if(cur == null) return false;
		if(idx == word.length()) return cur.hasWord;
		char c = word.charAt(idx);
		if(c == '.'){
			for(TrieNode node : cur.children.values()){
				if(find(word, node, idx+1)) return true;
			}
			return false;
		}
		return find(word, cur.children.get(c), idx+1);
	}
}
