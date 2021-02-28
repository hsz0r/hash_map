/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_hash_map;

    /**
 *
 * @author hsz0r
 * @param <K>
 * @param <V>
 */
public class hash_map<K, V> {
    private Node<K, V>[] hashTable;
    private int NUM_OF_LISTS;
    private int NUM_OF_ELEMENTS = 0;
    private double LC = 2; //LOAD COEFFICIENT
    
    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "|" + value;
        }
    }
   
    public hash_map() {
        this(16);
    }

    public double getLC(){
        return LC;
    }
    
    public void setLC(double newLC){
        this.LC = newLC;
    }
    
    public hash_map(int capacity) {
        this.NUM_OF_LISTS = capacity;
        this.hashTable = new Node[capacity];
    }

    public void add(K key, V value) {
        if (NUM_OF_ELEMENTS / NUM_OF_LISTS > LC) {
            rehash(2 * NUM_OF_LISTS + 1);
        }
        Node<K, V> newKey = new Node<>(key, value, null);

        Node<K, V> node = hashTable[hash(key)];
        if (node == null) {
            hashTable[hash(key)] = newKey;
            NUM_OF_ELEMENTS++;
        } else {
            while (node.next != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                }
                node = node.next;
            }
            if (node.key.equals(key)) {
                node.value = value;
            } else {
                node.next = newKey;
                NUM_OF_ELEMENTS++;
            }
        }
    }
    
    public void delete(K key){
        Node<K, V> index = hashTable[hash(key)];   
        while (index != null) {
            if (key == index.key) {
                index.key = null;
                index.value = null;
            }
            index = index.next;
        }        
    }

    public V get(K key) {
        Node<K, V> index = hashTable[hash(key)];
        while (index != null) {
            if (key == index.key) {
                return index.value;
            }
            index = index.next;
        }
        return null;
    }

    private void rehash(int capacity){
        Node<K, V>[] old = hashTable;
        NUM_OF_LISTS = capacity;
        NUM_OF_ELEMENTS = 0;
        hashTable = new Node[capacity];
        for (Node<K,V> e: old) {
            while (e != null) {
                add(e.key, e.value);
                e = e.next;
            }            
        }
    }
    
    private int hash(K key) {
        return key.hashCode() % hashTable.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node entry : hashTable) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append("] -> [");
                }
                entry = entry.next;
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
    
}
