package com.sandy.dsalgo.trees.coding;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by gondals on 19/08/16.
 */
public class CountTrendingWords {

    public static void main(String[] args) {
        new CountTrendingWords().execute();


    }

    private void execute() {
        System.out.println("Hello");

        String[] input = {"Sandeep", "Sachin", "SandeepGondal", "Smita", "Sachin", "Sandeep", "Sandeep", "Smita", "Sandeep", "Smita"};
        PriorityQueue<TrieNode> blockingQueue = new PriorityQueue<>(2, (x, y) -> Integer.compare(y.count, x.count));
        Set<TrieNode> trieNodes = new HashSet<>();


        Trie trie = new Trie();
        for (String i : input) {
            TrieNode insert = trie.insert(i);
            insert.strValue = i;
            trieNodes.add(insert);
        }

        trieNodes.forEach(blockingQueue::offer);

        System.out.println("-----");
        while (blockingQueue.size() > 0) {
            TrieNode poll1 = blockingQueue.poll();
            System.out.println(poll1.strValue + " " + poll1.count);
        }
//        TrieNode poll1 = blockingQueue.poll();
//        System.out.println(poll1.strValue + " " + poll1.count);
//        TrieNode poll2 = blockingQueue.poll();
//        System.out.println(poll2.strValue + " " + poll2.count);

    }

    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        int count;
        String strValue;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final TrieNode trieNode = (TrieNode) o;

            return strValue != null ? strValue.equals(trieNode.strValue) : trieNode.strValue == null;

        }

        @Override
        public int hashCode() {
            return strValue != null ? strValue.hashCode() : 0;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public TrieNode insert(String word) {
            word = word.toLowerCase();
            TrieNode p = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                int index = c - 'a';
                if(p.arr[index] == null){
                    TrieNode temp = new TrieNode();
                    p.arr[index] = temp;
                    p = temp;
                } else
                    p=p.arr[index];
            }
            p.isEnd=true;
            p.count++;
            return p;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            word = word.toLowerCase();
            TrieNode p = searchNode(word);
            if(p==null){
                return false;
            }else{
                if(p.isEnd)
                    return true;
            }

            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = searchNode(prefix);
            if(p==null){
                return false;
            }else{
                return true;
            }
        }

        public TrieNode searchNode(String s){
            TrieNode p = root;
            for(int i=0; i<s.length(); i++){
                char c= s.charAt(i);
                int index = c-'a';
                if(p.arr[index]!=null){
                    p = p.arr[index];
                }else{
                    return null;
                }
            }

            if(p==root)
                return null;

            return p;
        }
    }
}
