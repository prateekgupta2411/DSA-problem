package day1.top_100_concept_inJava;
class Fruit{
    Fruit(){

    }
    public Fruit(String name){
        System.out.println("fruit constructor is invocked");
    }
}
class Apple extends Fruit{
//    public Apple(String name) {
//        super(name);
//    }
}
public class Main5 {
    public static void main(String[] args) {
        Apple a = new Apple();
    }
}
