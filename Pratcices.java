package practice;
/*Task 1) Write a generic method to find all the repeated object in the
range of a list.
Input: [1, 1, 2, 2, 3, 4, 5, 6, 6]
Output 1: Repeated Elements are: 1 , 2 , 6
Input: ["apple", "banana", "apple", "orange", "banana", "grape",
"orange"]
Output: Repeated elements : apple, banana, orange]*/
import java.util.*;

public class RepeatedElements {

    public static <T> List<T> findRepeated(List<T> list) {
        Set<T> uniqueElements = new HashSet<>();
        Set<T> repeatedElements = new HashSet<>();
        
        for (T element : list) {
            if (!uniqueElements.add(element)) {
                repeatedElements.add(element);
            }
        }
        
        return new ArrayList<>(repeatedElements);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 6);
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape", "orange");

        List<Integer> repeatedNumbers = findRepeated(numbers);
        List<String> repeatedFruits = findRepeated(fruits);

        System.out.println("Repeated Elements are: " + repeatedNumbers);
        System.out.println("Repeated elements: " + repeatedFruits);
    }
}
/*Task 2) Write a Java program to get all the element in a tree set which is
greater than and less than to the given element.
Input: 23, 44, 45, 46, 55, 100, 102,2222, 100000
•Given number: 100 (get from the user)
Output: Less than given element: 23, 44, 46, 55
Greater than given element: 102, 2222, 100000*/
import java.util.*;

public class TreeSetElements {

    public static void main(String[] args) {
        // Create a TreeSet and add elements to it
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(23, 44, 45, 46, 55, 100, 102, 2222, 100000));

        // Get the given number from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int givenNumber = scanner.nextInt();
        scanner.close();

        // Get elements less than the given number
        NavigableSet<Integer> lessThanSet = treeSet.headSet(givenNumber, false); // Exclusive of given number
        System.out.println("Less than given element: " + lessThanSet);

        // Get elements greater than the given number
        NavigableSet<Integer> greaterThanSet = treeSet.tailSet(givenNumber, false).descendingSet(); // Exclusive of given number
        System.out.println("Greater than given element: " + greaterThanSet);
    }
}
/*Task 3 ) Write a Java program to add all the elements which is divisible
by both 3 and 5 of a priority queue to another priority queue.*/
import java.util.*;

public class PriorityQueueDivisible {

    public static void main(String[] args) {
        // Create a priority queue and add elements to it
        PriorityQueue<Integer> originalQueue = new PriorityQueue<>(Arrays.asList(15, 30, 45, 12, 18, 25, 10, 5));

        // Create another priority queue to store elements divisible by both 3 and 5
        PriorityQueue<Integer> divisibleByThreeAndFiveQueue = new PriorityQueue<>();

        // Iterate through the original queue and add elements divisible by both 3 and 5 to the new queue
        for (Integer element : originalQueue) {
            if (element % 3 == 0 && element % 5 == 0) {
                divisibleByThreeAndFiveQueue.add(element);
            }
        }

        // Print the elements in the new queue
        System.out.println("Elements divisible by both 3 and 5: " + divisibleByThreeAndFiveQueue);
    }
}
/*Task 4) Create a class called Cinema with attributes (String Genre, double
revenue, String year). By using LinkedHashSet, write a program to
Implement the following
•Sort the cinema objects based on the Genre
•Find the movie that made highest profit
•Find the total revenue of the given year*/
import java.util.*;

class Cinema {
    private String genre;
    private double revenue;
    private String year;

    public Cinema(String genre, double revenue, String year) {
        this.genre = genre;
        this.revenue = revenue;
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "genre='" + genre + '\'' +
                ", revenue=" + revenue +
                ", year='" + year + '\'' +
                '}';
    }
}

public class CinemaProgram {

    public static void main(String[] args) {
        // Create a LinkedHashSet to store Cinema objects
        LinkedHashSet<Cinema> cinemaSet = new LinkedHashSet<>();

        // Add Cinema objects to the set
        cinemaSet.add(new Cinema("Action", 1000000, "2020"));
        cinemaSet.add(new Cinema("Comedy", 2000000, "2021"));
        cinemaSet.add(new Cinema("Horror", 1500000, "2020"));
        cinemaSet.add(new Cinema("Action", 3000000, "2021"));

        // Sort the cinema objects based on the Genre
        TreeSet<Cinema> sortedByGenre = new TreeSet<>(Comparator.comparing(Cinema::getGenre));
        sortedByGenre.addAll(cinemaSet);
        System.out.println("Sorted by Genre:");
        for (Cinema cinema : sortedByGenre) {
            System.out.println(cinema);
        }

        // Find the movie that made the highest profit
        Cinema highestProfitMovie = Collections.max(cinemaSet, Comparator.comparing(Cinema::getRevenue));
        System.out.println("\nMovie with highest profit: " + highestProfitMovie);

        // Find the total revenue of the given year
        String givenYear = "2021";
        double totalRevenueOfYear = cinemaSet.stream()
                .filter(cinema -> cinema.getYear().equals(givenYear))
                .mapToDouble(Cinema::getRevenue)
                .sum();
        System.out.println("\nTotal revenue of " + givenYear + ": " + totalRevenueOfYear);
    }
}
/*Task 5) Write a Java program to find the greatest key and the least key
in a map*/
import java.util.*;

class Cinema {
    private String genre;
    private double revenue;
    private String year;

    public Cinema(String genre, double revenue, String year) {
        this.genre = genre;
        this.revenue = revenue;
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "genre='" + genre + '\'' +
                ", revenue=" + revenue +
                ", year='" + year + '\'' +
                '}';
    }
}

public class CinemaProgram {

    public static void main(String[] args) {
        // Create a LinkedHashSet to store Cinema objects
        LinkedHashSet<Cinema> cinemaSet = new LinkedHashSet<>();

        // Add Cinema objects to the set
        cinemaSet.add(new Cinema("Action", 1000000, "2020"));
        cinemaSet.add(new Cinema("Comedy", 2000000, "2021"));
        cinemaSet.add(new Cinema("Horror", 1500000, "2020"));
        cinemaSet.add(new Cinema("Action", 3000000, "2021"));

        // Sort the cinema objects based on the Genre
        TreeSet<Cinema> sortedByGenre = new TreeSet<>(Comparator.comparing(Cinema::getGenre));
        sortedByGenre.addAll(cinemaSet);
        System.out.println("Sorted by Genre:");
        for (Cinema cinema : sortedByGenre) {
            System.out.println(cinema);
        }

        // Find the movie that made the highest profit
        Cinema highestProfitMovie = Collections.max(cinemaSet, Comparator.comparing(Cinema::getRevenue));
        System.out.println("\nMovie with highest profit: " + highestProfitMovie);

        // Find the total revenue of the given year
        String givenYear = "2021";
        double totalRevenueOfYear = cinemaSet.stream()
                .filter(cinema -> cinema.getYear().equals(givenYear))
                .mapToDouble(Cinema::getRevenue)
                .sum();
        System.out.println("\nTotal revenue of " + givenYear + ": " + totalRevenueOfYear);
    }
}
/*Task 6) Write a Java program to display the values of a tree map whose
keys are less than a given key*/

import java.util.*;

public class TreeMapLessThanKey {

    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        
        // Add elements to the TreeMap
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");
        
        // Given key
        int givenKey = 4;
        
        // Display the values of the TreeMap whose keys are less than the given key
        System.out.println("Values whose keys are less than " + givenKey + ":");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            if (entry.getKey() < givenKey) {
                System.out.println(entry.getValue());
            }
        }
    }
}
/*Task 7) In a provided linked list, remove the node that is second from the
tail (the penultimate node), without utilizing any pre-defined methods.
Implement the logic independently.
Input: 3 – 5 – 5 – 6 – 78 – 7 – 44 - 9
Output: 3 – 5 – 5 – 6 – 78 – 7 – 9*/
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemovePenultimateNode {

    public static void main(String[] args) {
        // Create the linked list
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(78);
        head.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next = new Node(44);
        head.next.next.next.next.next.next.next = new Node(9);

        // Remove the penultimate node
        removePenultimateNode(head);

        // Print the updated list
        printList(head);
    }

    // Function to remove the penultimate node from the linked list
    public static void removePenultimateNode(Node head) {
        // Handle cases where the list has 0 or 1 elements
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Traverse the list to find the length
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Traverse the list again to reach the node before the penultimate node
        int targetIndex = length - 2;
        current = head;
        for (int i = 0; i < targetIndex; i++) {
            current = current.next;
        }

        // Remove the penultimate node
        current.next = current.next.next;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


