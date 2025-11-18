import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a mobile company managing a list of tariffs.
 * <p>
 * Provides functionality to add tariffs, count clients, sort tariffs,
 * and search for tariffs within a price range.
 * </p>
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class MobileCompany {
    private String companyName;
    private List<Tariff> tariffs;

    /**
     * Constructs a MobileCompany.
     *
     * @param companyName The name of the company.
     */
    public MobileCompany(String companyName) {
        this.companyName = companyName;
        this.tariffs = new ArrayList<>();
    }

    /**
     * Adds a tariff to the company's list.
     *
     * @param tariff The tariff to add.
     * @throws IllegalArgumentException if the tariff is null.
     */
    public void addTariff(Tariff tariff) {
        if (tariff == null) {
            throw new IllegalArgumentException("Cannot add a null tariff.");
        }
        tariffs.add(tariff);
    }

    /**
     * Calculates the total number of clients across all tariffs.
     *
     * @return The total client count.
     */
    public int getTotalClients() {
        int total = 0;
        for (Tariff t : tariffs) {
            total += t.getClientsCount();
        }
        return total;
    }

    /**
     * Sorts the tariffs by monthly fee in ascending order.
     */
    public void sortTariffsByFee() {
        Collections.sort(tariffs);
    }

    /**
     * Finds tariffs within a specified range of monthly fees.
     *
     * @param minFee The minimum monthly fee.
     * @param maxFee The maximum monthly fee.
     * @return A list of tariffs that fall within the range.
     * @throws IllegalArgumentException if minFee is greater than maxFee.
     */
    public List<Tariff> findTariffsByRange(double minFee, double maxFee) {
        if (minFee > maxFee) {
            throw new IllegalArgumentException("Min fee cannot be greater than max fee.");
        }
        List<Tariff> result = new ArrayList<>();
        for (Tariff t : tariffs) {
            if (t.getMonthlyFee() >= minFee && t.getMonthlyFee() <= maxFee) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Prints the list of tariffs to the console.
     */
    public void printTariffs() {
        if (tariffs.isEmpty()) {
            System.out.println("No tariffs available.");
        } else {
            for (Tariff t : tariffs) {
                System.out.println(t);
            }
        }
    }
}