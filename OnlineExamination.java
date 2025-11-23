import java.util.*;

public class OnlineExamination {

    static Scanner sc = new Scanner(System.in);
    static String username = "student";
    static String password = "1234";
    static boolean examSubmitted = false;

    public static void main(String[] args) {
        login();
    }
    //LOGIN FUNCTION
        public static void login() {
        System.out.println("-------LOGIN-------");
        System.out.println("Enter Username: ");
        String user = sc.nextLine();

        System.out.println("Enter Password");
        String pass = sc.nextLine();

        if (user.equals(username) && pass.equals(password))
        {
            System.out.println("\nLogin Successful!\n");
            menu();
        } else {
            System.out.println("Invalid Credentials. Try Again.\n");
            login();
        }
    }
    //MAIN MENU
    public static void menu(){
        while (true) {
            System.out.println("------ MENU ------"); 
            System.out.println("1. Update Password");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.println("Choose Option: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1: updatePassword(); break;
                case 2: startExam(); break;
                case 3: logout(); return;
                default: System.out.println("Invalid choice.");
            }
        }  
    }
    //UPDATE PASSWORD FUNCTION
    public static void updatePassword() {
        System.out.println("Enter New Password: ");
        sc.nextLine(); //clear buffer
        password = sc.nextLine();
        System.out.println("Password Updated Successfully!\n");
    }
        //EXAM FUNCTION
        public static void startExam() {
            examSubmitted = false;
            System.out.println("\nExam Started! (Timer: 30 seconds)");
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    public void run(){
        if (!examSubmitted){
            System.out.println("\nTime's up! Auto-submitting exam...\n");
            examSubmitted = true;
            submitExam(0);
        }
    }
}, 30000); //30 seconds timer
sc.nextLine(); //clear buffer

System.out.println("Q1. What is Java");
System.out.println("1. Programming Language");
System.out.println("2. Operating System");
System.out.println("Enter answer (1/2): ");

int ans = sc.nextInt();

if (!examSubmitted){
    examSubmitted = true;
    timer.cancel();
    submitExam(ans);
        }    
}

//SUBMIT EXAM FUNCTION
public static void submitExam(int ans) {
    int score = (ans == 1) ? 1 : 0;
    System.out.println("---- RESULT ----");
    System.out.println("Your Score: " + score + "/1\n");
}

//LOGOUT FUNCTION 
public static void logout(){
    System.out.println("\nLogged out successfully. Goodbye!");
    System.exit(0);
    }   
}
