package TrainTicket;

public class Ticket {

    private final int ticket_number;

    private final int train_number;

    private final String departure;

    private final String destination;

    private final int seat_number;

    private final double fare;

    private static int ticketCount = 0;

    public Ticket(Train t) {

        ticket_number = ++ticketCount;
        this.fare = t.getTrainFare();
        this.departure = t.getDepartureCity();
        this.destination = t.getDestinationCity();
        this.train_number = t.getTrainNumber();
        this.seat_number = t.getTotalNumberOfSeats() - t.getAvailableSeats() + 1;

    }

    public int getTicketNumber() {
        return ticket_number;
    }

    public int getTrainNumber() {
        return train_number;
    }

    public void printTicket() {
        System.out.println("\n---------------- Ticket -----------------------");
        System.out.println("Ticket number: " + ticket_number);
        System.out.println("Train number: " + train_number);
        System.out.println("Departure city: " + departure);
        System.out.println("Destination city: " + destination);
        System.out.println("Fare: " + fare + " L.E");
        System.out.println("Seat number: " + seat_number);
        System.out.println("-----------------------------------------");
    }
}
