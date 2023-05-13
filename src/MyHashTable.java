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
    private int size = 0;

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
    /*
     * Returns the hash value for a given key.
     * @param key the key to be hashed
     * @return the hash value
     */

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
        size++;
    }
    /*
     * Adds a new key-value pair to the hash table. If there are multiple nodes
     * that hash to the same index, the new node is added to the end of the linked list.
     * @param key the key to add
     * @param value the value to add
     */
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
    /*
     * Returns the value associated with a given key in the hash table.
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not found
     */

    public V remove(K key){
        int hs = hash(key);
        V valueReturn = null;
        if(chainArray[hs] == null){
            return null;
        }
        if(chainArray[hs].key == key){
            valueReturn = chainArray[hs].value;
            chainArray[hs] = chainArray[hs].next;
            size--;
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
        size--;
        return valueReturn;
    }
    /*
     Removes the key-value pair corresponding to the given key
     @param key the key
     @return the value associated with the key, or null if the key is not found
     */

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
    /*
     * Returns true if the hash table contains a node with the given value,
     * and false otherwise.
     * @param value the value to search for in the hash table
     * @return true if the hash table contains the value, false otherwise
     */

    public K getKey(V value){
        for(int i = 0; i < M; i++){
            if(chainArray[i] == null){
                continue;
            }
            if(chainArray[i].value == value){
                return chainArray[i].key;
            }
            HashNode currentNode = chainArray[i];
            while (currentNode.next != null){
                if(currentNode.value == value || currentNode.next.value == value){
                    return (K) currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
    /*
     * Returns the key of the node containing the specified value,
     * or null if the value is not found in the hash table.
     * @param value the value to search for in the hash table
     * @return the key of the node containing the value, or null if the value is not found
     */

    public int getSize() {
        return size;
    }
    /*
    * Returns actual size of hash table
    * @return field size
     */
}
