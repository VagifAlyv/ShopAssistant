import java.util.Arrays;
import java.util.Random;
public class Transaction {
    private String ID;
    private Product[] products;
    private double totalPrice; 
    private double transactionFee;
    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();


    Transaction(int ID, Product[] allProducts){
        initializeProducts();
        int[] productIndices = randomNumberGenerator.chooseRandomNIntegers(0, allProducts.length,3);
        int productCounter = 0;
        for (int productIndex : productIndices){
            products[productCounter] = allProducts[productIndex];
            productCounter++;
        }
        setTotalPrice();
        setTransactionFee();
        this.ID = Integer.toString(ID);

    }

    public Transaction(String ID, Product[] products, double totalPrice, double transactionFee, RandomNumberGenerator randomNumberGenerator) {
        this.ID = ID;
        this.products = products;
        this.totalPrice = totalPrice;
        this.transactionFee = transactionFee;
        this.randomNumberGenerator = randomNumberGenerator;
    }


    private void initializeProducts(){
        this.products = new Product[3];
    }

    private void setTotalPrice(){
        double totalPrice = 0;
        Random random = new Random();
        for (Product product : products){
            totalPrice = totalPrice + random.nextInt(1,10) * product.getPrice();
        }

        setTotalPrice(totalPrice);
    }


    private void setTransactionFee(){
        if (getTotalPrice() >= 1000){
            setTransactionFee(0.09 * getTotalPrice());

        } else if (999 >=getTotalPrice() && getTotalPrice() >= 800){
            setTransactionFee(0.05 * getTotalPrice());

        } else if (799 >=getTotalPrice() && getTotalPrice() >= 500){
            setTransactionFee(0.03 * getTotalPrice());

        } else if (499>= getTotalPrice() && getTotalPrice() >= 0) {
            setTransactionFee(0.01 * getTotalPrice());

        } else {
            System.out.println("Negative total price.");
        }
    }

    public String getID() {
        return ID;
    }



    public Product[] getProducts() {
        return products;
    }

   
    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    private void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Transaction getCopy(){
        Product[] copyProducts = new Product[products.length];
        for (int i = 0; i < products.length; i++){
            copyProducts[i] = products[i].getCopy();
        }
        return new Transaction(this.ID, copyProducts, this.totalPrice, this.transactionFee, this.randomNumberGenerator);
    }


    public String toString() {
        return "Transaction{" +
                "ID='" + ID + '\'' +
                ", products=" + Arrays.toString(products) +
                ", totalPrice=" + totalPrice +
                ", transactionFee=" + transactionFee +
                '}';
    }
}
