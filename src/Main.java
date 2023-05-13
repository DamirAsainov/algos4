import java.util.Random;

public class Main {
    public static void main(String[] args) {
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
    }
}