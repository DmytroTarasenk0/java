package lab3;

import java.util.Arrays;

/**
 * Demonstrates sorting and searching operations with the {@link Car} class.
 * <p>
 * The program creates an array of Car objects, sorts them by year (increasing)
 * and price (decreasing), and then searches for a specific car using the {@link Car#equals(Object)} method.
 * </p>
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 15-10-2025
 */
public class lab3 {

    /**
     * Entry point of the program.
     * <p>
     * Creates and sorts an array of cars, prints them in sorted order, and
     * performs a simple search by comparing a target car with the elements in
     * the array.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Car[] cars = {
            new Car("Mitsubishi", "Lancer", 2012, "White", 40000),
            new Car("Mitsubishi", "Space Star", 2004, "Red", 25000),
            new Car("Porsche", "911 Turbo", 2020, "Black", 50000),
            new Car("BMW", "X3", 2017, "Blue", 30000),
            new Car("Audi", "A4", 2021, "Grey", 45000),
            new Car("Ferrari", "F430", 2004, "Grey", 200000),
            new Car("BMW", "I4", 2021, "White", 30000)
        };

        // Sort cars by year (increasing) and then by price (decreasing)
        Arrays.sort(cars, (i, j) -> {
            if (i.getYear() != j.getYear()) {
                return Integer.compare(i.getYear(), j.getYear());
            } else {
                return Integer.compare(j.getPrice(), i.getPrice());
            }
        });

        System.out.println("\nSorted by year(inc) and price(dec):");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Search for a specific car
        Car target = new Car("Porsche", "911 Turbo", 2020, "Yellow", 50000);
        boolean found = false;
        for (Car car : cars) {
            if (car.equals(target)) {
                System.out.println("\nFound car: " + car);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nCar not found.");
        }
    }
}
