public class Bill {
    int total;
    Order order;
    
    public Bill(Order order){
        this.order = order; 
    }

    public void generateBill(int amount){
        total+=amount;
    }

    public void generateTotalBill(){
        System.out.println("------------------------------------------");
        System.out.println("|            BILL RECEIPT                |");
        System.out.println("------------------------------------------");
        System.out.printf("| %-20s %4s %10s   |%n", "Item", "QTY", "PRICE");
        System.out.println("------------------------------------------");
    
        for (OrderItem o : order.your_order) {
            System.out.printf("| %-20s %4d %10.2f   |%n", o.item.item_name, o.qty, (double) (o.qty * o.item.price));
        }
    
        System.out.println("------------------------------------------");
        System.out.printf("| %-26s %10.2f  |%n", "GST", GST(total));
        System.out.printf("| %-26s %10.2f  |%n", "Total", (total + GST(total)));
        System.out.println("------------------------------------------");
        System.out.println("Thanks " + order.customer.getName() + ", please visit again!");
    }
    

    public double GST(int amount){
        double total =  (0.18*amount);
        return total;
    }

    public int getTotal(){
        return this.total;
    }



}
