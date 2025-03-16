import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int op = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------- Setting up Hotel ---------------");
        System.out.print("Enter number of hotels: ");
        int hotels = scanner.nextInt();
        System.out.print("Enter number of rooms per hotel: ");
        int rooms = scanner.nextInt();
        int[][] newHotel = new int[hotels][rooms];
        do {
            System.out.println("------------- Hotel Management System ---------------");
            System.out.println("1. Check hotel");
            System.out.println("2. Book rooms");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Reset hotel");
            System.out.println("5. Exit");
            System.out.print("Choose option:(1-5) ");
            op = scanner.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Checking hotel...");
                    break;
                case 2:
                    System.out.println("Booking rooms...");
                    break;
                case 3:
                    System.out.println("Canceling booking...");
                    break;
                case 4:
                    System.out.println("Resetting hotel...");
                    newHotel = new int[hotels][rooms];
                    break;
                case 5:
                    Display(newHotel);
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        } while (op <= 6);

    }

    static void Display(int[][] hotels) {
        System.out.println("---Displaying hotels---");
        System.out.printf("%-5s %-10s %-10s %-12s\n","ID","ROOMS","AVAILABLE","UNAVAILABLE");
        for (int i = 0; i <hotels[i].length; i++) {
            System.out.print( i + 1 );
            int availableRooms = 0,unavailableRooms = 0;
            for (int j = 0; j <hotels[i].length; j++) {
                if (hotels[i][j] == 0) {
                    availableRooms++;
                }
                else{
                    unavailableRooms++;
                }
            }
            System.out.printf("%-5d %-10d %-10d %-12d\n", i + 1, hotels[i].length,availableRooms,unavailableRooms);
        }


    }
}
