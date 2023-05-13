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
