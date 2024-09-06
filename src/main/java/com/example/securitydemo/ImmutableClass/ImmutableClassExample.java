package com.example.securitydemo.ImmutableClass;

public class ImmutableClassExample {

    public static void main(String[] args){
        MutableStudent s = new MutableStudent(1,"nabin");
        System.out.println(s);

        s.setId(2);
        s.setName("ghosh");

        System.out.println(s);

        ImmutableStudent s1 = new ImmutableStudent(2, "hello");
        //This object is created and after that its state can't be changes as its variable are final and
        //there is no setter method present inside it
        System.out.println(s1);

    }

}

class ImmutableStudent{
   final private int id;
   final private String name;

   public ImmutableStudent(int id, String name){
       this.id = id;
       this.name =name;
   }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class MutableStudent{

    private int id;
    private String name;

    public MutableStudent(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
