package 二刷;
import java.util.*;
public class TwoEight_ImplementTrie {
	class TrieNode{
		char c;
		HashMap<Character, TrieNode> children = new HashMap<>();
		boolean hasWord;
		TrieNode(){
			
		}
		TrieNode(char c){
			this.c = c;
		}
	}
	TrieNode head;
	public TwoEight_ImplementTrie(){
		head = new TrieNode();
	}
	public void insert(String word){
		TrieNode cur = head;
		char[] wordArray = word.toCharArray();
		for(int i = 0; i < wordArray.length; i++){
			HashMap<Character, TrieNode> children = cur.children;
			if(children.containsKey(wordArray[i])){
				cur = children.get(wordArray[i]);
			}
			else{
				children.put(wordArray[i], new TrieNode(wordArray[i]));
				cur = children.get(wordArray[i]);
			}
			if(i == wordArray.length - 1){
				cur.hasWord = true;
			}
		}
	}
	public boolean search(String word){
		TrieNode cur = getPos(word);
		if(cur == null || cur.hasWord == false) return false;
		return true;
	}
	public TrieNode getPos(String word){
		char[] wordArray = word.toCharArray();
		TrieNode cur = head;
		for(int i = 0; i < wordArray.length; i++){
			HashMap<Character, TrieNode> children = cur.children;
			if(children.containsKey(wordArray[i])){
				cur = children.get(wordArray[i]);
			}
			else{
				return null;
			}
		}
		return cur;
	}
	//return if there is any word in the trie that starts with the given prefix
	public boolean startsWith(String prefix){
		TrieNode cur = getPos(prefix);
		if(cur == null) return false;
		return true;
	}
}
