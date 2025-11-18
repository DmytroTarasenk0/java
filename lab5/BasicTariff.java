/**
 * Represents a basic tariff plan focused on local calls.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class BasicTariff extends Tariff {
    private double costPerMinute;

    /**
     * Constructs a BasicTariff.
     *
     * @param name The tariff name.
     * @param monthlyFee The monthly fee.
     * @param clientsCount The number of clients.
     * @param costPerMinute The cost per minute for local calls.
     */
    public BasicTariff(String name, double monthlyFee, int clientsCount, double costPerMinute) {
        super(name, monthlyFee, clientsCount);
        this.costPerMinute = costPerMinute;
    }

    @Override
    public String getTypeDetails() {
        return String.format("Type: Basic (Call cost: %.2f UAH/min)", costPerMinute);
    }
}