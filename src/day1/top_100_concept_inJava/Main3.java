package day1.top_100_concept_inJava;
interface A{
    void run();
}
interface B{
    void run();
}
class C implements A, B{
    @Override
    public void run() {

    }
}
public class Main3 {
    public static void main(String[] args) {
        C c = new C();
        c.run();
    }
}
