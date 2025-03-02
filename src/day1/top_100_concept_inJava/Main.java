package day1.top_100_concept_inJava;


class OuterClass {
    private int data = 10;

    private void run() {
        System.out.println("This is outer class method");
    }

    class InnerCl {
        InnerCl() {
            System.out.println("Data in constructor: " + data);
        }

        void show() {
            data = 20;
            System.out.println("Data after modification: " + data);
            run();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerCl ic = oc.new InnerCl();
        ic.show();
    }
}

