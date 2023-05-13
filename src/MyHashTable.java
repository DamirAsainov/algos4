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
            HashNode currentNode = chainArray[hs];
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = hashNode;
        }
    }
    public V get(K key){
        int hs = hash(key);
        if(chainArray[hs] == null){
            return null;
        }
        else{
            HashNode currentNode = chainArray[hs];
            while (currentNode.next != null && !currentNode.key.equals(key)){
                currentNode = currentNode.next;
            }
            if(currentNode.key == key)
                return (V) currentNode.value;
            return null;
        }
    }
    public V remove(K key){
        int hs = hash(key);
        V valueReturn = null;
        if(chainArray[hs] == null){
            return null;
        }
        if(chainArray[hs].key == key){
            valueReturn = chainArray[hs].value;
            chainArray[hs] = chainArray[hs].next;
            return valueReturn;
        }
        HashNode currentNode = chainArray[hs];
        while (!currentNode.next.key.equals(key)){
            if(currentNode == null){
                return null;
            }
            currentNode = currentNode.next;
        }
        valueReturn = (V) currentNode.next.value;
        currentNode.next = null;
        return valueReturn;
    }
    public boolean contains(V value){
        for(int i = 0; i < M; i++){
            if(chainArray[i] == null){
                continue;
            }
            if(chainArray[i].value == value){
                return true;
            }
            HashNode currentNode = chainArray[i];
            while (currentNode.next != null){
                if(currentNode.value == value || currentNode.next.value == value){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
    public K getKey(V value){return null;}
}
