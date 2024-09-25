import java.io.IOException;

public class TransactionManagement {
    private Product[] allProducts;
    private Transaction[][] transactions;
    private ShopAssistant[] shopAssistants;
    private double[] salaries;
    private double[] revenues;
    private double[] profits;
    private int[] seniorities;
    private double[] weeklySalaries;
    private double[] commissions;
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    TransactionManagement(String productCSVPath, String shopAssistantsCSVPath) throws IOException {
        SalaryManagement salaryManagement = new SalaryManagement(shopAssistantsCSVPath);
        setShopAssistants(salaryManagement.getShopAssistants());
        setAllProducts(productCSVPath);
        initializeTransactionsArray();
        setTransactions();
        setSalaries();

    }
    
    private void initializeTransactionsArray(){
        this.transactions = new Transaction[shopAssistants.length][15];
    }

    public Transaction[][] getTransactions() {
        Transaction[][] copiedTransactions = new Transaction[transactions.length][15];
        for (int i = 0; i < transactions.length ; i++){
            for (int j = 0; j < 15; j++ ){
                copiedTransactions[i][j] = transactions[i][j].getCopy();
            }
        }
        return copiedTransactions;
    }
    
    private void setTransactions(){
        int idCounter = 0;
        for (int i = 0; i < getShopAssistants().length; i++){
            int count = 0;
            while (count < 15){
                this.transactions[i][count] = new Transaction(idCounter, getAllProducts());
                idCounter++;
                count++;
            }
        }
    }

    private Product[] getAllProducts() {
        return allProducts;
    }
    
    private void setAllProducts(String filePath) throws IOException {
        String fileContents = FileIO.readFileToString(filePath);
        String[] allProductDetails = fileContents.split("\\n");
        initializeAllProducts(allProductDetails.length);
        for (int i = 0; i < allProductDetails.length; i++){
            setProductAtIndex(getAllProducts(), i, new Product(allProductDetails[i]));
        }

    }

    public ShopAssistant[] getShopAssistants() {
        ShopAssistant[] copyShopAssistants = new ShopAssistant[shopAssistants.length];
        for (int i = 0; i < shopAssistants.length; i++){
            copyShopAssistants[i] = shopAssistants[i];
        }
        return copyShopAssistants;
    }
    
    private void setShopAssistants(ShopAssistant[] shopAssistants){
        this.shopAssistants = shopAssistants;
    }
    
    public double[] getSalaries() {
        return salaries;
    }
    
    private void setSalaries(){
        salaries = new double[shopAssistants.length];
        revenues = new double[shopAssistants.length];
        profits = new double[shopAssistants.length];
        weeklySalaries = new double[shopAssistants.length];
        commissions = new double[shopAssistants.length];
        seniorities = new int[shopAssistants.length];
        // individual assistant's transactions
        for (int i = 0; i < this.transactions.length; i++){ 
            int sumOfTransactionsTotalRevenue= 0;        
            int sumOfTransactionsTotalProfit = 0;
            int seniority = randomNumberGenerator.chooseRandomIntBetweenMandN(0,15);
            double weeklySalary = SalaryManagement.getWeeklySalary(seniority);
            double assistantSalary = weeklySalary * 4;
   
            for (int j = 0; j < this.transactions[i].length; j++){     
                sumOfTransactionsTotalRevenue += transactions[i][j].getTotalPrice()  + transactions[i][j].getTransactionFee();
                
            }
           
            double commission = 0;
            if (sumOfTransactionsTotalRevenue > 7500){
            	commission = sumOfTransactionsTotalRevenue * 0.03;
                this.commissions[i] = commission;
            } else {
            	commission = sumOfTransactionsTotalRevenue * 0.01;
                this.commissions[i] = commission;
            }
            
            
            sumOfTransactionsTotalProfit += sumOfTransactionsTotalRevenue - assistantSalary - commission;
            weeklySalaries[i] = weeklySalary;
            this.salaries[i] = assistantSalary + commission;
            this.revenues[i] = sumOfTransactionsTotalRevenue;
            this.profits[i] = sumOfTransactionsTotalProfit;
            this.seniorities[i] = seniority;

            }
    }
    
    private void initializeAllProducts(int allProductCount){
        this.allProducts = new Product[allProductCount];
    }

    private void setProductAtIndex(Product[] allProducts, int index, Product product){
        allProducts[index] = product;
    }

    public double[] getRevenues() {
        return revenues;
    }

    public double[] getProfits() {
        return profits;
    }

    public int[] getSeniorities() {
        return seniorities;
    }


    public double[] getWeeklySalaries() {
        return weeklySalaries;
    }

    public double[] getCommissions() {
        return commissions;
    }
}
