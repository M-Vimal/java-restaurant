
class Customer{
    private static int IDCOUNTER = 1;
    private  int customer_id;
    private String name;
    private long phone_number;
    public Customer(String name,long phone){
        setDetails(name,phone);
    }

    public void setDetails(String name,long phone){
        this.customer_id = IDCOUNTER++;
        this.name = name;
        this.phone_number = phone;
    }

    public int getCustomerId(){
        return customer_id;
    }

    public String getName(){
        return name;
    }
    public long getPhoneNumber(){
        return phone_number;
    }


    public void placeOrder(){
        
    }
}