import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class to test the Custom Set Implementation (TariffSet).
 * This class demonstrates all three constructors and core Set operations.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class lab6 {
    public static void main(String[] args) {
        try {
            // Tariff objects
            Tariff t1 = new Tariff("Basic", 10.0, 100);
            Tariff t2 = new Tariff("Premium", 50.0, 20);
            Tariff t3 = new Tariff("Ultra", 100.0, 5);
            // This object has the same name and fee as t1, testing the Set uniqueness (equals/hashCode)
            Tariff t1Duplicate = new Tariff("Basic", 10.0, 999); 

            // Constructor 1 (Empty) & add()
            System.out.println(">>> 1. Testing Empty Constructor & add()");
            TariffSet<Tariff> set1 = new TariffSet<>();
            set1.add(t1);
            set1.add(t2);
            System.out.println("Set 1 contents:\n" + set1);
            
            // Test Uniqueness by adding duplicate
            System.out.println("Attempting to add duplicate t1... " + set1.add(t1Duplicate)); 
            System.out.println("Set 1 size after attempt: " + set1.size());

            // Constructor 2 (Single Object)
            System.out.println("\n>>> 2. Testing Single Object Constructor");
            TariffSet<Tariff> set2 = new TariffSet<>(t3);
            System.out.println("Set 2 contents:\n" + set2);

            // Constructor 3 (Collection)
            System.out.println("\n>>> 3. Testing Collection Constructor");
            List<Tariff> list = Arrays.asList(t1, t2, t3, t1Duplicate); // list contains a duplicate
            TariffSet<Tariff> set3 = new TariffSet<>(list); // Set should only contain 3 unique elements
            System.out.println("Set 3 contents (built from list):\n" + set3);
            
            // Iterator & contains()
            System.out.println("\n>>> 4. Testing Iterator and contains()");
            System.out.println("Iterating over set3:");
            for (Tariff t : set3) {
                System.out.println("-> Tariff: " + t.getName() + " (Fee: " + t.getMonthlyFee() + ")");
            }
            System.out.println("Set 3 contains 'Premium'? " + set3.contains(t2));

            // Removal
            System.out.println("\n>>> 5. Testing remove() and toArray()");
            set3.remove(t2);
            System.out.println("Contains 'Premium' after remove? " + set3.contains(t2)); // Should be false
            
            // toArray
            Object[] arr = set3.toArray();
            System.out.println("Set 3 toArray length: " + arr.length);
            System.out.println("First element in array: " + arr[0]);

        } catch (IllegalArgumentException e) {
            System.err.println("Construction Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}