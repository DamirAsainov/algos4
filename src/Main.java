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
        System.out.println("remove - " + hashTable.remove("Bue"));
        System.out.println(hashTable.get("Lou"));

    }
}