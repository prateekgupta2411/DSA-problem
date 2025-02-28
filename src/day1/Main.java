package day1;

class OuterClass {
    private int data = 10; // Private variable

    private void run() { // Private method
        System.out.println("This is outer class method");
    }

    class InnerClass {
        InnerClass() {
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
        OuterClass outer = new OuterClass(); // Creating OuterClass instance
        OuterClass.InnerClass inner = outer.new InnerClass(); // Creating InnerClass instance

        inner.show(); // Calling the method
    }
}