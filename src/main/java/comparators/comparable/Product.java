package comparators.comparable;

/*
* Comparable is a interface with compareTo() method which takes another object
* The main aim of comparable interface is the class which is extending can define a
* default/natural ordering of that object. When we do like this
* In future if any sorting is used on this class objects then default is applied first*/
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;
    private double rating;

    public Product(int id, String name, double price, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, rating=%.1f}", 
                              id, name, price, rating);
    }

    // Default comparison (Comparable)
    @Override
    public int compareTo(Product other) {



        // Default compare by id
        return Integer.compare(this.id, other.id);


    }
}
/**
 *
 * Comparable<T> - an interface with method compareTo(T other)
 *
 * Used for hardcoding the default sorting of class
 * The code for sorting is written in compareTo() method in the same class
 *
 * Advantages
 *
 * 1. Easy Integration
 *      Works directly with Java APIs like Collections.sort() or TreeSet, TreeMap, etc.
 *      Example: TreeSet<Product> will automatically use the compareTo() method.
 *
 * Disadvantages
 *
 * 1. Single Responsibility principle
 *      So in future if we want to change the natural sorting strategy then we need to change in original class
 * 2. Only one compareTo() implementation possible inside the class.
 *
 * 3. Intrusive
 *      You must modify the class to implement Comparable.
 *      Not possible if you don’t own the class (e.g., from a library).
 *
 * 4. Terrible in case when the original class is coming from a library (where we can't modify the class)
 * Now when you want multiple comparison strategies then comes the Comparator interface with compare() method
 *
 *
 * Final verdict
 * Use Comparable → if your class has a single natural order (like String, Integer, Employee by ID).
 * Use Comparator → if you want multiple ways of sorting or when the class cannot/should not be modified.
 * */