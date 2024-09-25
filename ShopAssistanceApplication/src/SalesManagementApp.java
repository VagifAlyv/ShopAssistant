import java.io.IOException;

public class SalesManagementApp {
    public static void main(String[] args) throws IOException {
        Query query = new Query("products.csv", "shopAssistants.csv");
        System.out.println("The highest total price transaction is: " + query.getHighestTotalPriceTransaction());
        System.out.println("The most expensive product in the lowest-price transaction is: " + query.getMostExpensiveProductInTheLowestPriceTransaction().getProductName());
        System.out.println("The lowest Transaction fee is: " + query.getLowestTransactionFee());
        query.printHighestSalaryShopAssistant();
        System.out.println();
        System.out.println("The total revenue is: " + query.getTotalRevenueAndTransactionFees());
        System.out.println("The total profit that is earned after paying the shop assistant salaries: " + query.getTotalProfitAfterPayingSalaries());
    }
}
