public class Main {
    public static void main(String[] args) {
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


    }
}