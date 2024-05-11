package TrainTicket;

import java.util.HashMap;
import java.util.Scanner;

public class BookingSystem {

    private final HashMap<String, User> UserList;
    private final Admin admin;
    public TrainSystem trainSystem;

    public BookingSystem() {
        UserList = new HashMap<>();
        trainSystem = new TrainSystem();

        // creating a default admin
        admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword("admin");

        // creating two demo users
        User user1 = new User("user1", "pass", 1000.00);
        User user2 = new User("user2", "pass", 1000.00);
        UserList.put(user1.getUsername(), user1);
        UserList.put(user2.getUsername(), user2);

    }

    public void loginFunction(UserAdminTemplate obj) {

        System.out.println("Enter your password: ");
        Scanner scanner = new Scanner(System.in);

        if (scanner.next().equals(obj.getPassword())) {
            obj.setLoginStatus(true);
        } else {
            System.out.println("Incorrect Password !!");
        }
    }

    public void UserMenu() {

        System.out.println("1.New User");
        System.out.println("2.Existing User");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        String username;

        switch (option) {
            // ------------ 1. creating new user ---------------
            case 1:
                User NewUser = new User();

                while (true) {
                    System.out.println("Enter your Username: ");
                    username = scanner.next();
                    if (UserList.containsKey(username)) {
                        System.out.println("sorry, entered username already exists, try something different");
                    } else {
                        break;
                    }
                }
                NewUser.setUsername(username);

                System.out.println("Enter your Password: ");
                NewUser.setPassword(scanner.next());
                System.out.println("Enter your Balance: ");
                double b = scanner.nextDouble();
                NewUser.setAccountBalance(b);

                UserList.put(NewUser.getUsername(), NewUser);
                System.out.println("New user created !!");

            /*------------ 2. user login and menu ------------------*/
            case 2:
                System.out.println("-------- User Login ------------");
                System.out.println("Enter your Username: ");
                username = scanner.next();
                if (UserList.containsKey(username)) {

                    User User = UserList.get(username);
                    int choice;
                    boolean check = true;
                    loginFunction(User);
                    if (User.getLoginStatus()) {
                        System.out.println("logged in as user !!");

                        while (check) {
                            System.out.println("------------ User Menu -----------------");
                            System.out.println("1. Display Trains List");
                            System.out.println("2. My Bookings");
                            System.out.println("3. Book Ticket");
                            System.out.println("4. Cancel Ticket");
                            System.out.println("5. Check Balance");
                            System.out.println("6. Exit");
                            System.out.println("Enter your choice: ");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    TrainSystem.displayTrainList();
                                    break;
                                case 2:
                                    User.listBookings();
                                    break;
                                case 3:
                                    User.bookTicket();
                                    break;
                                case 4:
                                    User.cancelBooking();
                                    break;
                                case 5:
                                    User.CheckBalance();
                                    break;
                                case 6:
                                    check = false;
                                    break;
                                default:
                                    System.out.println("please enter a valid option");
                            }
                        }
                        User.setLoginStatus(false);
                    }
                } else {
                    System.out.println("Invalid username !!");
                }
                break;
            default:
                System.out.println("Invalid option !!");
        }
    }

    public void adminMenu() {

        Scanner scanner = new Scanner(System.in);
        String uname;
        boolean check = true;
        int choice;
        System.out.println("------------ Admin Login ----------------");
        System.out.println("Enter your username: ");
        uname = scanner.next();
        if (uname.equals(admin.getUsername())) {

            loginFunction(admin);
            if (admin.getLoginStatus()) {
                System.out.println("Logged in as admin");
                while (check) {
                    System.out.println("----------- Admin Menu -------------------");
                    System.out.println("1. Get train list");
                    System.out.println("2. Add train");
                    System.out.println("3. Remove train");
                    System.out.println("4. Update train");
                    System.out.println("5. Exit");
                    System.out.println("Enter your choice: ");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            TrainSystem.displayTrainList();
                            break;
                        case 2:
                            admin.addTrain();
                            break;
                        case 3:
                            admin.removeTrain();
                            break;
                        case 4:
                            admin.updateTrain();
                            break;
                        case 5:
                            check = false;
                            break;
                        default:
                            System.out.println("please enter a valid option");
                    }
                    admin.setLoginStatus(false);
                }
            }
        } else {
            System.out.println("Invalid username !!");
        }
        System.out.println("Enter your choice: ");
    }

    public static void main(String[] args) {

        BookingSystem bookingSystem = new BookingSystem();

        int option;
        Scanner scanner = new Scanner(System.in);

        boolean check = true;
        while (check) {
            System.out.println("1. Login as User");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.println("Enter your Option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    bookingSystem.UserMenu();
                    break;
                case 2:
                    bookingSystem.adminMenu();
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.println("Invalid option !!, try again");
            }
        }
    }
}
