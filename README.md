# Assignment 4 Documentaion
## 
# Test all methods

```java
System.out.println("Test all methods");
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.put("Zoe", 1);
        hashTable.put("Bea", 2);
        hashTable.put("Tim", 3);
        hashTable.put("Mia", 4);
        hashTable.put("Sue", 5);
        hashTable.put("Len", 6);
        hashTable.put("Moe", 7);
        hashTable.put("Lou", 8);
        hashTable.put("Rae", 9);
        hashTable.put("Max", 10);
        hashTable.put("Tod", 11);
        System.out.println("Tim - " + hashTable.get("Tim"));
        System.out.println("remove 'Lou' - " + hashTable.remove("Lou"));
        System.out.println("Lou - " + hashTable.get("Lou"));
        System.out.println("8 in hash table - " + hashTable.contains(8));
        System.out.println("2 in hash table - " + hashTable.contains(2));
        System.out.println("Key of 3 - " + hashTable.getKey(3));
        System.out.println("Hash Table size - " + hashTable.getSize());
```
## Results
```
Test all methods
Tim - 3
remove 'Lou' - 8
Lou - null
8 in hash table - false
2 in hash table - true
Key of 3 - Tim
Hash Table size - 10
```
# Testing (50%):
For test program create random 10000 `MyTestingClass` and out them in hash table.

Then program print number of elements in each bucket

```java
        int rows = 11;
        String[] NAMES = {"Damir", "Asain", "Mansur", "DaBaby", "Asanali", "Karina", "Chakir", "Yesken", "Timur", "Tyson", "Daryn", "Logan", "Abay", "Darina", "Karima", "Assima", "Dauren", "Daulet", "Abylai", "Carter", "Danik", "WAter", "Sanjar", "Erkeldy", "Aldiar", "Beka", "Rakhat", "Olzhas", "Aslan", "Levi", "Ackerman", "Hinata", "Naruto", "Goky", "Sasuke", "Itachi", "Eren", "Messi", "Ronaldy", "Son", "Kane", "Maguire", "S1mple", "Dosia", "Evangelion", "Ada", "Yashin", "Henry", "Maksim", "Ryan", "Gosling"};
        MyHashTable<MyTestingClass, String> testHashTable = new MyHashTable<>(rows);
        for(int id = 0; id < 10000; id++){
            Random random = new Random();
            MyTestingClass student = new MyTestingClass(id, NAMES[random.nextInt(0, NAMES.length)], NAMES[random.nextInt(0, NAMES.length)]);
            testHashTable.put(student, student.getFullName());
        }
        System.out.println("\n----------------------Test-------------------------");
        System.out.println("Hash Table size - " + testHashTable.getSize());
        for(int i = 0; i < rows; i++){
            System.out.println("row " + i + " - " + testHashTable.numOfItemsInRow(i));
        }
```
## Results
```
----------------------Test-------------------------
Hash Table size - 10000
row 0 - 930
row 1 - 915
row 2 - 922
row 3 - 903
row 4 - 882
row 5 - 920
row 6 - 853
row 7 - 945
row 8 - 944
row 9 - 911
row 10 - 875
```
# MyTestingClass
**Description**:is a class for testing hash table

## Fields
`id` - id of student

`name` - name of student

`surname` - surname of student...
```java
private int id;
    private String name;
    private String surname;
    private int age;
    private double gpa;
```
## hashCode method
The method returns the absolute value of hash to ensure that the hash code is always non-negative.

This implementation of hashCode() ensures that objects with the same values for id, name, and surname will have the same hash code, which is a requirement for the hashCode() method.
```java
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (surname == null ? 0 : surname.hashCode());
        return Math.abs(hash);
    }
}
```
## Code
```java
public class MyTestingClass{
    private int id;
    private String name;
    private String surname;
    private int age;
    private double gpa;
    public MyTestingClass(int id){
        this.id = id;
    }
    public MyTestingClass(int id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (surname == null ? 0 : surname.hashCode());
        return Math.abs(hash);
    }
    public String getFullName(){
        return name + " " +  surname;
    }

}
```
# MyHashTable
## Fields
`chainArray` - array to hold chains

`M` - number of chains 

`size` - size of the hash table, number of elements in all the chains
```java
private HashNode<K, V>[] chainArray;
private int M = 11;
private int size = 0;
```
## Private Methods
`hash` - return hash value for the key 
```java
private int hash(K key){
        return key.hashCode() % M;
    }
```

## Public Methods 
`put(K key, V value)` - Associates the specified value with the specified key in this hash table.

`put` - first get index to chainArray, check if any node is already present in chain, if present then replace its value else add new node with key-value pair.

`key` - key with which the specified value is to be associated

`value` - value to be associated with the specified key
```java
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
```
`get(K key)` - Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

`get` - first get index to chainArray, search for node in the chain with the specified key, if present return its value else return null.

`key` - the key whose associated value is to be returned

`return` - the value to which the specified key is mapped, or null if this map contains no mapping for the key
```java
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
```
`remove(K key)` - Removes the mapping for the specified key from this hash table if present.

`remove` - first get index to chainArray, search for node in the chain with the specified key, if present remove it and reduce size of hash table by one.

`key` - key whose mapping is to be removed from the map
```java
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
```
`contains(V value)` - Returns true if this hash table contains a mapping for the specified key.

`contains` - first get index to chainArray, search for node in the chain with the specified key, if present return true else return false.
```java
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
```



`size()` - Returns the number of key-value mappings in this map.

`size` - the number of key-value mappings in this map.

```java
public int size() {
    return size;
}
```





