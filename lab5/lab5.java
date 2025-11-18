import java.util.List;

/**
 * Main class to demonstrate the Mobile Company Tariff Hierarchy.
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 18-11-2025
 */
public class lab5 {
    public static void main(String[] args) {
        try {
            // Create the company and tariffs
            MobileCompany myCompany = new MobileCompany("Vodafone");

            Tariff basic = new BasicTariff("Social Talk", 100.00, 1500, 0.10);
            Tariff roaming = new RoamingTariff("Euro Trip", 150.00, 300, "European Union");
            Tariff data = new DataTariff("Super Net", 125.00, 800, 50);
            Tariff unlimited = new DataTariff("Unlim 5G", 200.00, 500, 9999);

            // Add tariffs to company
            myCompany.addTariff(basic);
            myCompany.addTariff(roaming);
            myCompany.addTariff(data);
            myCompany.addTariff(unlimited);

            // Show initial list
            System.out.println("Initial Tariff List:");
            myCompany.printTariffs();

            // Calculate total clients
            int totalClients = myCompany.getTotalClients();
            System.out.println("\nTotal active clients: " + totalClients);

            // Sort tariffs by fee
            System.out.println("\nSorted Tariff List by Monthly Fee:");
            myCompany.sortTariffsByFee();
            myCompany.printTariffs();

            // Find tariff in range
            double minRange = 100.0;
            double maxRange = 175.0;
            System.out.println("\nSearching for tariffs in range $" + minRange + " - $" + maxRange + ":");
            
            List<Tariff> found = myCompany.findTariffsByRange(minRange, maxRange);
            if (found.isEmpty()) {
                System.out.println("No tariffs found in this range.");
            } else {
                for (Tariff t : found) {
                    System.out.println("Found: " + t);
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error occurred: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}