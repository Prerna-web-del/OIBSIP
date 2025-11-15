import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, String> bookings = new HashMap<>();
    static int pnrCounter = 1;
    public static void main(String[] args){
        System.out.println("== ONLINE RESERVATION SYSTEM===");
        if (!login()) {
            System.out.println("Login Failed");
            return;
        }
            while(true) {
                System.out.println("\n1. Reserve Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Exit");
                System.out.println("Choose: ");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1: reserve(); break;
                    case 2: cancel(); break;
                    case 3: System.out.println("Thank you!");
                    return;
                    default: System.out.println("Invalid option!");
                } 
            }
        }
        static boolean login() {
            String user = "admin", pass = "1234";

            System.out.println("Username: ");
            String u = sc.next();

            System.out.println("Password: ");
            String p = sc.next();

            return u.equals(user) && p.equals(pass);
        }
        static void reserve() {
            sc.nextLine();//cleaer buffer
            System.out.println("--- RESERVATION FORM ---");

            System.out.println("Passenger Name: ");
            String name = sc.nextLine();

             System.out.println("From: ");
            String from = sc.nextLine();

             System.out.println("To: ");
            String to = sc.nextLine();

            String pnr = "PNR" + pnrCounter++;
            String details = name + " | " + from + " -> " + to;
            
            bookings.put(pnr, details);

            System.out.println("Ticket Booked! PNR: " + pnr);
        }
        static void cancel(){
            System.out.println("Enter PNR: ");
            String pnr = sc.next();

            if (bookings.containsKey(pnr)){
                System.out.println("Booking Found: "+bookings.get(pnr));
                bookings.remove(pnr);
                System.out.println("Ticket Cancelled!");
            }
            else{
                System.out.println("PNR not found!");
            }
        }
    }
        
        