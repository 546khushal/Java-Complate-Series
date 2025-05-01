/**With the help of Book(id,name,price) class do the followings (Refer Javadoc): 
d. Create Queue of 5 Books. Iterate from first to last book and display all the information about 
each book. 
e. Create SortedSet of 5 Books Iterate from first to last book and display all the information 
about each book. 
f. Create TreeSet of 5 Books. Iterate from first to last book and display all the information about 
each book.  */
import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String name;
    double price;

    Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Book b) {
        return this.id - b.id; // Sorting by ID
    }
}

public class day09_2 {
    public static void main(String[] args) {
        Queue<Book> bookQueue = new LinkedList<>();
        bookQueue.add(new Book(1, "Java Programming", 499.99));
        bookQueue.add(new Book(2, "Data Structures", 349.50));
        bookQueue.add(new Book(3, "Algorithms", 599.75));
        bookQueue.add(new Book(4, "Database Systems", 399.00));
        bookQueue.add(new Book(5, "Operating Systems", 299.99));

        System.out.println("Iterating over Queue:");
        for (Book b : bookQueue) {
            System.out.println(b);
        }

        SortedSet<Book> bookSortedSet = new TreeSet<>();
        bookSortedSet.addAll(bookQueue);

        System.out.println("\nIterating over SortedSet:");
        for (Book b : bookSortedSet) {
            System.out.println(b);
        }

        TreeSet<Book> bookTreeSet = new TreeSet<>(bookQueue);

        System.out.println("\nIterating over TreeSet:");
        for (Book b : bookTreeSet) {
            System.out.println(b);
        }
    }
}
