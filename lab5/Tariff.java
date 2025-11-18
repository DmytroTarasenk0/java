/**
 * Abstract class representing a generic mobile tariff.
 * <p>
 * This class defines the common properties for all tariffs, such as name,
 * monthly fee, and the number of active clients. It implements the {@link Comparable}
 * interface to support sorting by monthly fee.
 * </p>
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public abstract class Tariff implements Comparable<Tariff> {
    private String name;
    private double monthlyFee;
    private int clientsCount;

    /**
     * Constructs a new Tariff.
     *
     * @param name The name of the tariff.
     * @param monthlyFee The monthly subscription fee.
     * @param clientsCount The number of clients using this tariff.
     * @throws IllegalArgumentException if the monthly fee or clients count is negative.
     */
    public Tariff(String name, double monthlyFee, int clientsCount) {
        if (monthlyFee < 0 || clientsCount < 0) {
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
     * Abstract method to get a string detail of the specific tariff type.
     * @return specific details string.
     */
    public abstract String getTypeDetails();

    /**
     * Compares this tariff with another tariff based on the monthly fee.
     *
     * @param other the other tariff to compare to.
     * @return a negative integer, zero, or a positive integer as this tariff's fee
     * is less than, equal to, or greater than the specified tariff's fee.
     */
    @Override
    public int compareTo(Tariff other) {
        return Double.compare(this.monthlyFee, other.monthlyFee);
    }

    @Override
    public String toString() {
        return String.format("Tariff '%s' | Fee: %.2f UAH | Clients: %d | %s", 
                name, monthlyFee, clientsCount, getTypeDetails());
    }
}