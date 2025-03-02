package day1.top_100_concept_inJava;
class Parent{
    String name;
    int age;
    Parent(String name, int age){
        this.name = name;
        this.age = age;
    }
    void display(){
        System.out.println("This is Parent class");
    }
}
//class Child extends Parent{
//    void show(){
//        System.out.println("This is Child class");
//    }
//}
public class Main2 {
    public static void main(String[] args) {
        Parent p = new Parent("Prateek", 23);
        System.out.println(p.name);
        System.out.println(p.age);
        p.display();
//        Child c = new Child();
//        c.show();
//        c.display();
    }
}
