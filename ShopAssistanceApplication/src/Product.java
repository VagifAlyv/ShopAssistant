public class Product {
    private String ID;
    private String productName;
    private double price;


    Product(){
        setID("-");
        setProductName("");
        setPrice(-1);
    }
 
    Product(String stringParameterFromCSV){
        String[] parameters = stringParameterFromCSV.split(";");
        double price = Double.parseDouble(parameters[2].replace(",","."));
        setID(parameters[0]);
        setProductName(parameters[1]);
        setPrice(price);
    }    
 
    public Product(String ID, String productName, double price) {
        this.ID = ID;
        this.productName = productName;
        this.price = price;
    }

    public String getID() {
    	return ID;
    }
    
    private void setID(String ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
  
    public String getProductName() {
    	return productName;
    }
   
    private void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getCopy(){
        return new Product(this.ID, this.productName, this.price);
    }

    public String toString() {
        return "Product{" +
        		"ID='" + ID + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}