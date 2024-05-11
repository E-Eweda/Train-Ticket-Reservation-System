package TrainTicket;

import java.util.Scanner;

public class Admin extends UserAdminTemplate {

    public Admin() {
        Train t1 = new Train("Train 1", "Alexandria", "Cairo", 20.00, 50);
        TrainSystem.trainList.put(t1.getTrainNumber(), t1);

        Train t2 = new Train("Train 2", "Cairo", "Aswan", 40.00, 70);
        TrainSystem.trainList.put(t2.getTrainNumber(), t2);

        Train t3 = new Train("Train 3", "Luxor", "Aswan", 10.00, 90);
        TrainSystem.trainList.put(t3.getTrainNumber(), t3);
    }

    public void addTrain() {
        Train t = new Train();
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Enter Train Name: ");
        t.setTrainName(scanner.nextLine());

        System.out.println("Enter Train's Destination city: ");
        t.setDestinationCity(scanner.nextLine());

        System.out.println("Enter Train's Departure city:  ");
        t.setDepartureCity(scanner.nextLine());

        System.out.println("Enter Train's Fare: ");
        t.setTrainFare(scanner.nextDouble());

        System.out.println("Enter Train's Seat Capacity: ");
        t.setTotalNumberOfSeats(scanner.nextInt());
        t.setAvailableSeats();

        TrainSystem.trainList.put(t.getTrainNumber(), t);
        System.out.println("New train successfully added to the list!");
    }

    public void updateTrain() {

        if (TrainSystem.trainList.isEmpty()) {
            System.out.println("sorry list is empty");
            return;
        }

        int trainNo;
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Enter the train's number u want to update");
        trainNo = scanner.nextInt();

        if (TrainSystem.trainList.containsKey(trainNo)) {
            boolean check = true;
            int option;
            Train train = TrainSystem.trainList.get(trainNo);
            do {
                System.out.println("\n-------Choose your option to update-------");
                System.out.println("1. Fare");
                System.out.println("2. Departure city");
                System.out.println("3. Destination city");
                System.out.println("4. Total Number of Seats");
                System.out.println("5. exit");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Old value of train fare: " + train.getTrainFare() + " L.E");
                        System.out.println("Enter new train fare: ");
                        train.setTrainFare(scanner.nextDouble());
                        System.out.println("Train fare updated");
                        break;
                    case 2:
                        System.out.println("Old departure city: " + train.getDepartureCity());
                        System.out.println("Enter new departure city: ");
                        train.setDepartureCity(scanner.next());
                        System.out.println("Departure city updated");
                        break;
                    case 3:
                        System.out.println("Old destination city: " + train.getDestinationCity());
                        System.out.println("Enter new destination city: ");
                        train.setDestinationCity(scanner.next());
                        System.out.println("Destination city updated");
                        break;
                    case 4:
                        System.out.println("Old value of total number of seats: " + train.getTotalNumberOfSeats());
                        System.out.println("Enter new value for total number of seats: ");
                        train.setTotalNumberOfSeats(scanner.nextInt());
                        train.setAvailableSeats();
                        System.out.println("Total number of seats updated");
                        break;
                    case 5:
                        check = false;
                        System.out.println("Exited from update menu");
                        break;
                    default:
                        System.out.println("Invalid option !!");
                }
            } while (check);
        } else {
            System.out.println("Invalid train number !!");
        }
    }

    public void removeTrain() {
        if (TrainSystem.trainList.isEmpty()) {
            System.out.println("list is already empty");
            return;
        }

        int trainNo;
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Enter the train's number you want to remove");
        trainNo = scanner.nextInt();
        if (TrainSystem.trainList.containsKey(trainNo)) {
            System.out.println("---- Selected Train details ----");
            TrainSystem.trainList.get(trainNo).displayTrain();
            System.out.println("Confirm removal y/n: ");
            switch (scanner.next()) {
                case "y":
                    TrainSystem.trainList.remove(trainNo);
                    System.out.println("Successfully removed the train");
                    break;
                default:
                    System.out.println("Invalid option !!");
                case "n":
                    System.out.println("Train removal cancelled");
            }
        } else {
            System.out.println("Invalid train number !!");
        }
    }
}
