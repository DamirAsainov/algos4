public class Main {
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.put("DAAA", 121);
        hashTable.put("DAAA", 124);
        hashTable.put("2", 12304);
        hashTable.put("2", 999);
        System.out.println(hashTable.get("DAAA"));
        System.out.println(hashTable.get("2"));
        System.out.println(hashTable.remove("DAAA"));
        System.out.println(hashTable.get("DAAA"));
    }
}