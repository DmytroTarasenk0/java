/**
 * Represents a tariff plan focused on internet data usage (Mixed/Data focus).
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class DataTariff extends Tariff {
    private int dataLimitGb;

    /**
     * Constructs a DataTariff.
     *
     * @param name The tariff name.
     * @param monthlyFee The monthly fee.
     * @param clientsCount The number of clients.
     * @param dataLimitGb The amount of data included in GB.
     */
    public DataTariff(String name, double monthlyFee, int clientsCount, int dataLimitGb) {
        super(name, monthlyFee, clientsCount);
        this.dataLimitGb = dataLimitGb;
    }

    @Override
    public String getTypeDetails() {
        return String.format("Type: Data (Traffic: %d GB)", dataLimitGb);
    }
}