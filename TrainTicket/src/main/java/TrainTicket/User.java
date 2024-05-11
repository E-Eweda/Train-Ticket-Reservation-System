package TrainTicket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User extends UserAdminTemplate {

    private Double accountBalance;

    private final HashMap<Integer, Ticket> bookingsList;

    Scanner scanner;

    public User() {
        bookingsList = new HashMap<>();
    }

    public User(String userName, String password, Double accountBalance) {
        this();
        this.username = userName;
        this.password = password;
        this.accountBalance = accountBalance;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double Acc) {
        this.accountBalance = Acc;
    }

    public void bookTicket() {
        scanner = new Scanner(System.in);
        if (TrainSystem.trainList.isEmpty()) {
            System.out.println("You can't book a ticket right now");
        } else {
            System.out.println("Enter train number: ");
            int n = scanner.nextInt();

            if (TrainSystem.isValid(n) == null) {
                System.out.println("Invalid Train Number !!");
            } else {
                if (TrainSystem.isValid(n).getAvailableSeats() > 0) {
                    if (accountBalance < TrainSystem.isValid(n).getTrainFare()) {
                        System.out.println("Sorry your account balance is insufficient");
                    } else {
                        System.out.println("Your selected Train Details");
                        TrainSystem.isValid(n).displayTrain();
                        System.out.println("confirm booking y/n: ");
                        switch (scanner.next()) {
                            case "y":
                                Ticket ticket = new Ticket(TrainSystem.isValid(n));
                                accountBalance -= TrainSystem.isValid(n).getTrainFare();
                                System.out.println(
                                        TrainSystem.isValid(n).getTrainFare() + "L.E " + "withdrawn from your account");
                                System.out.println("Current balance : " + getAccountBalance());
                                System.out.println("Booking successful");
                                bookingsList.put(ticket.getTicketNumber(), ticket);
                                TrainSystem.isValid(n).updateAvailableSeats();
                                ticket.printTicket();
                                break;
                            default:
                                System.out.println("Invalid option !!");
                            case "n":
                                System.out.println("Booking cancelled");
                                break;
                        }
                    }
                } else {
                    System.out.println("Sorry, No Seats Available");
                }
            }
        }

    }

    public void cancelBooking() {
        if (bookingsList.isEmpty()) {
            System.out.println("sorry you have no bookings to cancel");
            return;
        }

        scanner = new Scanner(System.in);

        System.out.println("Enter ticket number of the booking you want to cancel: ");
        int ticketNo = scanner.nextInt();
        int tempTrainNumber = bookingsList.get(ticketNo).getTrainNumber();
        if (bookingsList.containsKey(ticketNo)) {
            accountBalance += TrainSystem.isValid(tempTrainNumber).getTrainFare();
            System.out.println(TrainSystem.isValid(tempTrainNumber).getTrainFare() + "L.E " + "added to your account");
            System.out.println("Current balance : " + getAccountBalance());
            TrainSystem.trainList.get(TrainSystem.isValid(tempTrainNumber).getTrainNumber()).updateAvailableSeats2();
            bookingsList.remove(ticketNo);
            System.out.println("Booking cancelled");
        } else {
            System.out.println("Invalid ticket number !!");
        }
    }

    public void CheckBalance() {
        System.out.println("Your Balance is : " + getAccountBalance() + " L.E");
    }

    public void listBookings() {
        if (bookingsList.isEmpty()) {
            System.out.println("------ Your booking list is empty ------");
            return;
        }

        System.out.println("--------------Your Bookings------------------");
        for (Map.Entry<Integer, Ticket> m : bookingsList.entrySet()) {
            m.getValue().printTicket();
        }
    }
}
