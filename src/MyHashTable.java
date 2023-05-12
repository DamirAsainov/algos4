import org.w3c.dom.Node;

public class MyHashTable <K, V> {
    private class HashNode<K, V>{
        private K key;
        private V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private int M = 11;// default number of chain
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
        for(int i = 0; i < M; i++){
            chainArray[i] = null;
        }
    }
    public MyHashTable(int M){
        chainArray = new HashNode[M];
        for(int i = 0; i < M; i++){
            chainArray[i] = null;
        }
    }
    private int hash(K key){
        return key.hashCode() % M;
    }
    public void put(K key, V value){
        int hs = hash(key);
        HashNode hashNode = new HashNode(key, value);
        if(chainArray[hs] == null){
            chainArray[hs] = hashNode;
        }
        else{
            HashNode currentNode = new HashNode(key, value);
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = hashNode;
        }
        System.out.println("Da");
    }
    public V get(K key){return null;}
    public V remove(K key){return null;}
    public boolean contains(V value){return false;}
    public K getKey(V value){return null;}
}
