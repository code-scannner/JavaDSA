package trie;

class Node{
    Node links[] = new Node[26];
    boolean flag = false;

    boolean contains(char c){
        return links[c - 'a'] != null;
    }
    Node get(char c){
        return links[c - 'a'];
    }

    Node put(char c){
        Node node = new Node();
        links[c - 'a'] = node;
        return node;
    }
    
}

public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.contains(c)){
                curr.put(c);
            }
            curr = curr.get(c);
        }
        curr.flag = true;

    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(!curr.contains(c)) return false;
            curr = curr.get(c);
        }
        return curr.flag == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c : prefix.toCharArray()){
            if(!curr.contains(c)) return false;
            curr = curr.get(c);
        }
        return true;
    }
}
