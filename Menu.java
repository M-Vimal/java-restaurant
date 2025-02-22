
import java.util.List;
import java.util.ArrayList;
class Menu {
    public List <Item> non_veg_menu = new ArrayList<>();
    public List <Item> veg_menu = new ArrayList<>();


    public Menu(){
        Item i1 = new Item(1,"Chicken Biriyani",200);
        Item i2 = new Item(2,"Mutton Biriyani",200);
        Item i3 = new Item(3,"Prawn Biriyani",280);
        Item i4 = new Item(4,"Chicken Gravy",250);
        Item i5 = new Item(5,"Mutton Nalli",350);
        Item i6 = new Item(6,"Prawn 65",300);
        non_veg_menu.add(i1);
        non_veg_menu.add(i2);
        non_veg_menu.add(i3);
        non_veg_menu.add(i4);
        non_veg_menu.add(i5);
        non_veg_menu.add(i6);

        Item i7 = new Item(7,"Mushroom Biriyani",180);
        Item i8 = new Item(8,"paneer Biriyani",200);
        Item i9 = new Item(9,"cauliflower 65",150);
        Item i10 = new Item(10,"Veg Fried Rice",250);
        Item i11 = new Item(11,"Mushroom Gravy",180);
        Item i12 = new Item(12,"Paneer Gravy",270);
        veg_menu.add(i7);
        veg_menu.add(i8);
        veg_menu.add(i9);
        veg_menu.add(i10);
        veg_menu.add(i11);
        veg_menu.add(i12);
    }
    // to retieve item
    public int getItemPrice(int id){
        for (Item item:non_veg_menu){
            if (item.id == id){
                return item.price;
            }
        }
        for (Item item:veg_menu){
            if (item.id == id){
                return item.price;
            }
        }
        return 0;
    }

    //get item to store in your_orders
    public Item getItem(int id){
        for (Item item:non_veg_menu){
            if (item.id == id){
                return item;
            }
        }
        for (Item item:veg_menu){
            if (item.id == id){
                return item;
            }
        }
        return null;
    }

    
    //to display menu items
    public void displayMenu(){
        //to display non-veg menu
        System.out.println("------------------------------------------------");
        System.out.println("                  NON-VEG  MENU                         ");
        System.out.println("------------------------------------------------");
        System.out.printf("%-5s %-20s %-6s%n", "ID", "Name", "Price"); // Header

        for (Item item : non_veg_menu) {
            System.out.printf("%-5d %-20s Rs. %-6d%n", item.id, item.item_name, item.price);
        }
        
        //to display veg menu
        System.out.println("------------------------------------------------");

        System.out.println("------------------------------------------------");
        System.out.println("                  NON-VEG  MENU                         ");
        System.out.println("------------------------------------------------");
        System.out.printf("%-5s %-20s %-6s%n", "ID", "Name", "Price"); // Header

        for (Item item : veg_menu) {
            System.out.printf("%-5d %-20s Rs. %-6d%n", item.id, item.item_name, item.price);
        }
        
        System.out.println("------------------------------------------------");
    }
   
}
