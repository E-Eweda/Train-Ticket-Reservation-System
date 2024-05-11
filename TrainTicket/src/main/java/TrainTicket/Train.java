package TrainTicket;

public class Train {

    private final int trainNumber;
    private String trainName;
    private String departureCity;
    private String destinationCity;
    private double trainFare;
    private int totalNumberOfSeats;
    private int availableSeats;
    public static int numberOfTrains;

    public Train() {
        numberOfTrains++;
        trainNumber = numberOfTrains;
    }

    public Train(String trainName, String departureCity, String destinationCity, double trainFare, int totalNumberOfSeats) {
        this();
        this.trainName = trainName;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.trainFare = trainFare;
        this.totalNumberOfSeats = totalNumberOfSeats;
        this.availableSeats = this.totalNumberOfSeats;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public double getTrainFare() {
        return trainFare;
    }

    public void setTrainFare(double trainFare) {
        this.trainFare = trainFare;
    }

    public int getTotalNumberOfSeats() {
        return totalNumberOfSeats;
    }

    public void setTotalNumberOfSeats(int totalNumberOfSeats) {
        this.totalNumberOfSeats = totalNumberOfSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats() {
        this.availableSeats = totalNumberOfSeats;
    }

    public void updateAvailableSeats() {
        if (this.availableSeats > 0) {
            this.availableSeats--;
        }
    }

    public void updateAvailableSeats2() {
        this.availableSeats++;
    }

    public void displayTrain() {
        System.out.println("\n----------------------------------------");
        System.out.println("Train Name: " + getTrainName());
        System.out.println("Train Number: " + getTrainNumber());
        System.out.println("Destination: " + getDestinationCity());
        System.out.println("Departure: " + getDepartureCity());
        System.out.println("Train Fare: " + getTrainFare() + " L.E");
        System.out.println("Total Number of Seats: " + getTotalNumberOfSeats());
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("----------------------------------------\n");
    }
}
