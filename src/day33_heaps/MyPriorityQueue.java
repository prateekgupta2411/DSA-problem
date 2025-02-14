package day33_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class NewStudent implements Comparable<NewStudent> {
    int marks;
    String name;

    NewStudent(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Name: " + name + ", Marks: " + marks;
    }

    @Override
    public int compareTo(NewStudent that) {
//        return this.marks - that.marks; //inc -> ascending order Sort kr deta he
        if(that.marks == this.marks){
            // me smjata hu ag dono student ke marks same he to fir unke student ke name
            // lexiographical order me check kiya jata h agr -ve ya o ayee to swap nhi krte as it is
            // +ve ke case me swap hota he
            return this.name.compareTo(that.name);//-ve,0,+ve
        }
        return that.marks - this.marks; //dec -> descending order Sort kr deta he
    }
    @Override
    public boolean equals(Object obj) {
        // yhaa pe Object a rha he Student nhi a rha to muje phle check krna hoga ki
        // ki ye obj NewStudent Class ka he ya nhi ek keyword hota he instanceof check kr lega
        if(obj instanceof NewStudent) {
            NewStudent that = (NewStudent) obj;
            boolean isNameSame = (this.name.compareTo(that.name) == 0);
            if(this.marks == that.marks){
                return true;
            }
        }
       return false;
    }
}
public class MyPriorityQueue {
    public static void main(String[] args) {
//        PriorityQueue<Integer> minPg = new PriorityQueue<>();
//        minPg.offer(1);
//        minPg.offer(2);
//        minPg.offer(10);
//        minPg.offer(0);
//        System.out.println("Highest priority Element is : " + minPg.peek()); // prints 0
//
//        PriorityQueue<Integer> maxPg = new PriorityQueue<>(Collections.reverseOrder());
//        // Insert Element
//        maxPg.offer(1);
//        maxPg.offer(2);
//        maxPg.offer(10);
//        maxPg.offer(0);
//        System.out.println("max pq : Highest priority Element is : " + maxPg.peek());// get highest priority element
//        System.out.println(maxPg.contains(10)); // check element is present or not
//        System.out.println("max pq : Deleted: " + maxPg.poll());// delete element
//        System.out.println("max pq : Highest priority Element is : " + maxPg.peek());
//        System.out.println(maxPg.contains(10));

        PriorityQueue<NewStudent> studentQueue = new PriorityQueue<>();
        studentQueue.offer(new NewStudent("John", 80));
        studentQueue.offer(new NewStudent("Alice", 80));
        studentQueue.offer(new NewStudent("Bob", 75));
        studentQueue.offer(new NewStudent("Charlie", 8));
        System.out.println(studentQueue.peek());

        System.out.println(studentQueue.contains(80));
    }
}
