import java.io.IOException;

public class SalaryManagement {
    private ShopAssistant[] shopAssistants;
   

    SalaryManagement(String filePath) throws IOException {
        setShopAssistants(filePath);
    }

    public ShopAssistant[] getShopAssistants() {
        ShopAssistant[] copyShopAssistants = new ShopAssistant[shopAssistants.length];
        int count = 0;
        for (ShopAssistant shopAssistant : shopAssistants){
            copyShopAssistants[count] = shopAssistant.getCopy();
            count++;
        }
        return copyShopAssistants;
    }
    
    private void setShopAssistants(String filePath) throws IOException {
        String fileContents = FileIO.readFileToString(filePath);
        String[] shopAssistantDetails = fileContents.split("\\n");
        initializeShopAssistantsArray(shopAssistantDetails.length);

        for (int i = 0; i < shopAssistantDetails.length; i++){
            shopAssistants[i] = new ShopAssistant(shopAssistantDetails[i]);
        }

    }

    private void initializeShopAssistantsArray(int shopAssistantCount){
        this.shopAssistants = new ShopAssistant[shopAssistantCount];
    }

  
    public static double getWeeklySalary(int seniority) {
        if (seniority >= 5){
            return 3000 ;
        } else if (seniority >= 3){
            return 2500 ;

        } else if (seniority >= 1){
            return 2000;

        } else {
            return 1500;
        }
    }


}
