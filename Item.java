
public class Item{
    int id;
    String item_name;
    int price;

    public Item(int id,String item_name ,int price){
        this.id = id;
        this.item_name = item_name;
        this.price = price;
    }

    public String getName(){
        return item_name;

    }
}


