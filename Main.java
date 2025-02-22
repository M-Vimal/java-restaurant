import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean start = true;
        while (start){
            Order.main(new String[]{});
            System.out.println("next customer please .'y' for yes.");
            String next = scanner.nextLine();
            if(next.equals("y")){
                start = true;
            }
            else if(next.equals("close"))
            {
                start = false;
            }       
        }
        System.out.println("restaurant closed!!!");
        scanner.close();
    }
}
