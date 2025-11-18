import java.util.Objects;

/**
 * Represents a generic mobile tariff.
 * This is a concrete class, serving as the base type for the collection.
 * It implements {@link Comparable} for sorting and includes equals()
 * and hashCode() for Set functionality.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class Tariff implements Comparable<Tariff> {
    private String name;
    private double monthlyFee;
    private int clientsCount;

    /**
     * Constructs a new Tariff object.
     *
     * @param name The name of the tariff plan.
     * @param monthlyFee The monthly subscription fee.
     * @param clientsCount The number of clients subscribed to this tariff.
     * @throws IllegalArgumentException if the monthly fee or clients count is negative.
     */
    public Tariff(String name, double monthlyFee, int clientsCount) {
        if (monthlyFee < 0 || clientsCount < 0) {
            // Processing exception: check for non-negative input values
            throw new IllegalArgumentException("Fee and clients count must be non-negative.");
        }
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.clientsCount = clientsCount;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getClientsCount() {
        return clientsCount;
    }

    /**
     * Default implementation of type details for the Tariff class.
     * @return a descriptive string.
     */
    public String getTypeDetails() {
        return "Standard Tariff";
    }

    /**
     * Compares this tariff with another tariff based on the monthly fee (ascending order).
     * @param other the other tariff to compare to.
     * @return a value indicating the order based on monthly fee.
     */
    @Override
    public int compareTo(Tariff other) {
        return Double.compare(this.monthlyFee, other.monthlyFee);
    }

    /**
     * Provides a structured string representation of the Tariff object.
     * @return the formatted tariff details.
     */
    @Override
    public String toString() {
        return String.format("Tariff '%s' | Fee: %.2f UAH | Clients: %d | %s", 
                name, monthlyFee, clientsCount, getTypeDetails());
    }

    /**
     * Defines equality for Tariff objects.
     * Two tariffs are considered equal if they have the same name and monthly fee,
     * regardless of the client count.
     *
     * @param o the object to compare against.
     * @return true if the objects are logically equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return Double.compare(tariff.monthlyFee, monthlyFee) == 0 && 
               Objects.equals(name, tariff.name);
    }

    /**
     * Generates a hash code consistent with the equals() method.
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, monthlyFee);
    }
}