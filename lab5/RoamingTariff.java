/**
 * Represents a tariff plan designed for international roaming usage.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class RoamingTariff extends Tariff {
    private String targetRegion;

    /**
     * Constructs a RoamingTariff.
     *
     * @param name The tariff name.
     * @param monthlyFee The monthly fee.
     * @param clientsCount The number of clients.
     * @param targetRegion The specific region where roaming applies.
     */
    public RoamingTariff(String name, double monthlyFee, int clientsCount, String targetRegion) {
        super(name, monthlyFee, clientsCount);
        this.targetRegion = targetRegion;
    }

    @Override
    public String getTypeDetails() {
        return "Type: Roaming (Region: " + targetRegion + ")";
    }
}