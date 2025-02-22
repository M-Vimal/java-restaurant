import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class WrongInput extends Exception{
    public WrongInput(String msg){
        super(msg);

    }
}

class OrderItem{
    Item item;
    int qty;

    public OrderItem(Item item,int qty){
        this.item = item;
        this.qty = qty;
    }

    public String toString() {
        return item.getName() + " (Qty: " + qty + ")";
    }
}

public class Order{
    private static int ORDERIDCOUNTER = 1;
    int order_id;
    Customer customer;
    public List <OrderItem> your_order = new ArrayList<>();
    public Order(Customer customer){
        this.order_id = ORDERIDCOUNTER++;
        this.customer = customer;
    }

    public static boolean phoneNumberCheck(long number){
        String regex = "^[6-9]\\d{9}$";
        String num_str = String.valueOf(number);
        return num_str.matches(regex);
    }

    public static void main(String [] args){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String c_name = scanner.nextLine();
        System.out.println("Enter your mobile");
        long mobile_no = scanner.nextLong();
        while (!phoneNumberCheck(mobile_no)){
            System.out.println("please enter a valid mobile number");
            System.out.println("Enter your mobile");
            mobile_no = scanner.nextLong();
        }

        //create a customer object
        Customer customer = new Customer(c_name,mobile_no);
        //create a order object using customer object
        Order order = new Order(customer);
        order.takeOrder(scanner,order);
        
    }
    public void takeOrder(Scanner scanner, Order order){
        //object for bill
        Bill bill = new Bill(order);
        Menu menu = new Menu();
        menu.displayMenu();
        System.out.println("please order...");
        String s="y";
        do{
            try {
                System.out.println("choose item by id");
                int item_no = scanner.nextInt();
                scanner.nextLine();
                System.out.println("how much you want");
                int qty = scanner.nextInt();
                scanner.nextLine();

                //price added to total for each item
                int item_price = menu.getItemPrice(item_no);
                bill.generateBill(item_price * qty);

                //add item to orders
                boolean item_found = false;
                Item  item_ordered = menu.getItem(item_no);
                for (OrderItem order_item : your_order){
                    if(order_item.item.equals(item_ordered)){
                        order_item.qty += qty;
                        item_found = true;
                        break;
                    }
                }
                if(!item_found){
                    your_order.add(new OrderItem(item_ordered,qty));
                }



                //take order from user
                System.out.println("do you order anything.'y' for yes and 'n' for no:");
                s = scanner.nextLine();
                s.toLowerCase();
                if (!s.equals("y") &&  !s.equals("n") ){
                    throw new WrongInput("please enter 'y' or 'n' ");
                }
                else if (s.equals("n")){
                    bill.generateTotalBill();
                }
            }
            //catch exception when user enter other character,other than 'y' or 'n'
            catch(Exception e){
                System.out.println(e);
  
            }
        }while(s.equals("y"));


    }
}