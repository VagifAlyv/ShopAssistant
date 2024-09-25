import java.io.IOException;

public class Query {
    private final String productsCSVPath;
    private final String shopAssistantsCSVPath;

    Query(String productsCSVPath, String shopAssistantsCSVPath){
        this.productsCSVPath = productsCSVPath;
        this.shopAssistantsCSVPath = shopAssistantsCSVPath;
    }
 
    public Transaction getHighestTotalPriceTransaction() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        Transaction[][] transactions = transactionManagement.getTransactions();
        double highestTotalPrice = 0;
        Transaction highestTotalPriceTransaction = null;
        for (int i = 0; i < transactions.length; i++){
            for (int j = 0; j < 15; j++) {
                if (transactions[i][j].getTotalPrice() > highestTotalPrice) {
                    highestTotalPrice = transactions[i][j].getTotalPrice();
                    highestTotalPriceTransaction = transactions[i][j];
                }
            }
        }
         
        return highestTotalPriceTransaction;
    }

    public Product getMostExpensiveProductInTheLowestPriceTransaction() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        Transaction[][] transactions = transactionManagement.getTransactions();
        //assigning lowestTotalPrice to temporary max value
        double lowestTotalPrice = Double.MAX_VALUE;
        Transaction lowestTotalPriceTransaction = null;
        for (int i = 0; i < transactions.length; i++){
            for (int j = 0; j < 15; j++) {
                if (transactions[i][j].getTotalPrice() < lowestTotalPrice) {
                    lowestTotalPrice = transactions[i][j].getTotalPrice();
                    lowestTotalPriceTransaction = transactions[i][j];
                }
            }
        }

        Product[] products = lowestTotalPriceTransaction.getProducts();
        double mostExpensiveProductPrice = 0;
        Product mostExpensiveProduct = null;
        for (int i = 0; i < products.length; i++){
            if (products[i].getPrice() > mostExpensiveProductPrice){
                mostExpensiveProduct = products[i];
                mostExpensiveProductPrice = products[i].getPrice();
            }
        }
        return mostExpensiveProduct;
    }

    public double getLowestTransactionFee() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        Transaction[][] transactions = transactionManagement.getTransactions();
        
        //Assigning lowestTransactionFee to temporary Max Value
        double lowestTransactionFee = Double.MAX_VALUE;
    
        for (int i = 0; i < transactions.length; i++){
            for (int j = 0; j < 15; j++) {
                if (transactions[i][j].getTransactionFee() < lowestTransactionFee) {
                    lowestTransactionFee = transactions[i][j].getTransactionFee();
    
                }
            }
        }
        return lowestTransactionFee;
    }

    public void printHighestSalaryShopAssistant() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        double[] salaries = transactionManagement.getSalaries();
        ShopAssistant[] shopAssistants = transactionManagement.getShopAssistants();
        double highestSalary = 0;
        int highestSalaryShopAssistantIndex = 0;
        for (int i = 0; i < shopAssistants.length; i++){
            if (salaries[i] > highestSalary){
                highestSalary = salaries[i];
                highestSalaryShopAssistantIndex = i;
            }
        }
        ShopAssistant highestSalaryShopAssistant = shopAssistants[highestSalaryShopAssistantIndex];
        
        System.out.println("Highest salary shop assistant's information is given below: ");
        System.out.println("ID: " + highestSalaryShopAssistant.getID());
        System.out.println("Name: " + highestSalaryShopAssistant.getName());
        System.out.println("Seniority: " + transactionManagement.getSeniorities()[highestSalaryShopAssistantIndex]);
        System.out.println("Weekly Basis Salary: " + transactionManagement.getWeeklySalaries()[highestSalaryShopAssistantIndex]);
        System.out.println("Commission: " + transactionManagement.getCommissions()[highestSalaryShopAssistantIndex]);
        System.out.println("Total Salary: " + transactionManagement.getSalaries()[highestSalaryShopAssistantIndex]);
    }

    public double getTotalRevenueAndTransactionFees() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        Transaction[][] transactions = transactionManagement.getTransactions();
        
        double totalRevenue = 0;
        for(int i=0; i < transactions.length; i++) {
        	for(int j = 0; j < 15; j++) {
        		Transaction transaction = transactions[i][j];
        		double totalTransactionRevenue = transaction.getTotalPrice() + transaction.getTransactionFee();
        		
        		//Adding transaction revenue to the total revenue
        		totalRevenue+= totalTransactionRevenue;
        	}
        }
        return totalRevenue;
    
    }

    public double getTotalProfitAfterPayingSalaries() throws IOException {
        TransactionManagement transactionManagement = new TransactionManagement(productsCSVPath, shopAssistantsCSVPath);
        double[] totalProfits = transactionManagement.getProfits();
        double totalProfit = 0;
        for (int i = 0; i < totalProfits.length; i++){
            totalProfit += totalProfits[i];
        }

       
        return totalProfit ;
        
    }
    
}
