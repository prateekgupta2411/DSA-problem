package day1.top_100_concept_inJava;

class Car{
   private static Car car ;
    private Car(){
    }
    public static Car car(){
        if(car == null){
            car = new Car();
        }
        return car;
    }
}
public class Main6 {
    public static void main(String[] args) {
        Car c1 = Car.car();
        Car c2 = Car.car();

        System.out.println(c1 == c2); // Should print true, proving singleton
    }
}
