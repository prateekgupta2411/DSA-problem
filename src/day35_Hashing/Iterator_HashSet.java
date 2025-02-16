package day35_Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class Iterator_HashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<String>();
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("Houston");
        cities.add("Philadelphia");
        cities.add("New York");
//        Iterator it = cities.iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next()+ ", ");
//        }
        for(String city : cities){
            System.out.println(city);
        }
    }
}
