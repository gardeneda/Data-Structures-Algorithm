import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
//        Employee billEnd = new Employee("Bill", "End", 78);

//        Demonstration of Linear Probing Hashtable
//        SimpleHashTable ht = new SimpleHashtable();
//        ht.put("Jones", janeJones);
//        ht.put("Doe", johnDoe);
//        ht.put("Wilson", mikeWilson);
//        ht.put("Smith", marySmith);
//
//
//        ht.printHashtable();
//
//        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
//
//        ht.remove("Wilson");
//        ht.remove("Jones");
//        ht.printHashtable();
//
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        // ##############################################################

//        Demonstration of Chaining Hashtable
//
//        ChainedHashTable ht = new ChainedHashtable();
//        ht.put("Jones", janeJones);
//        ht.put("Doe", johnDoe);
//        ht.put("Wilson", mikeWilson);
//        ht.put("Smith", marySmith);
//
//
//        ht.printHashtable();
//
//        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
//
//        ht.remove("Wilson");
//        ht.remove("Jones");
//        ht.printHashtable();
//
//        System.out.println("Retrieve key Smith: " + ht.get("Smith"));

        // ##############################################################

//        Demonstration of Using the JDK
        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Smith", marySmith);
        Employee employee = hashMap.put("Doe", mikeWilson);
        System.out.println("Previous value associated with the Key: put()" + employee);

        Employee employee2 = hashMap.putIfAbsent("Smith", janeJones);

        System.out.println("Previous value associated with the key: putIfAbsent()" + employee2);


        System.out.println(hashMap.getOrDefault("someone", mikeWilson));

        // #1 Method of Iterating through
//        Iterator<Employee> iterator = hashMap.values().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        System.out.println("");

        hashMap.forEach((k, v) -> System.out.println("Key= " + k + ", Employee = " + v));

        System.out.println("");

        // The key will be hashed, so it will be very quick to find.
        System.out.println(hashMap.containsKey("Doe"));
        // We have to traverse through the hashtable to find this value.
        System.out.println(hashMap.containsValue(janeJones));

    }
}
