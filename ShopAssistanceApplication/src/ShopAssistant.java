public class ShopAssistant {
    private String ID;
    private String name;
    private String surname;
    private String phoneNumber;

  
    ShopAssistant(){
        setID("-");
        setName("");
        setSurname("");
        setPhoneNumber("-");

    }

    ShopAssistant(String ID, String name, String surname, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    ShopAssistant(String stringParameterFromCSV){
        String[] parameters = stringParameterFromCSV.split(";");
        setID(parameters[0]);
        setName(parameters[1]);
        setSurname(parameters[2]);
        setPhoneNumber(parameters[3]);

    }

    public String getID() {
        return ID;
    }

    private void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShopAssistant getCopy(){
        return new ShopAssistant(getID(),getName(),getSurname(),getPhoneNumber());
    }
    
}
