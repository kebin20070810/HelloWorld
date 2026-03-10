public class eRyder {
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String linkedAccount;
    private final String linkedPhoneNumber;

    private String bikeId;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;
    private int totalUsageInMinutes;
    private double totalFare;

    public eRyder(String bikeId, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        this.bikeId = bikeId;
        this.setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.linkedAccount = linkedAccount;
        this.linkedPhoneNumber = linkedPhoneNumber;
    }

    public eRyder(String bikeId, int batteryLevel, boolean isAvailable, double kmDriven) {
        this.bikeId = bikeId;
        this.setBatteryLevel(batteryLevel);
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;
        this.linkedAccount = "guest_user";
        this.linkedPhoneNumber = "00000000000";
    }

    public void ride() {
        if (batteryLevel > 0 && isAvailable) {
            System.out.println("The bike is available.");
        } else {
            System.out.println("The bike is not available.");
        }
    }

    public void printBikeDetails() {
        System.out.println("Bike ID: " + bikeId);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Availability: " + isAvailable);
        System.out.println("Distance Travelled: " + kmDriven + " km");
    }

    public void printRideDetails(int usageInMinutes) {
        this.totalFare = calculateFare(usageInMinutes);
        this.totalUsageInMinutes = usageInMinutes;
        System.out.println("Linked Account: " + linkedAccount);
        System.out.println("Linked Phone Number: " + linkedPhoneNumber);
        System.out.println("Bike ID: " + bikeId);
        System.out.println("Usage in Minutes: " + totalUsageInMinutes + " mins");
        System.out.println("Total Fare: " + totalFare + " EUR");
    }

    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Invalid battery level. Value must be between 0 and 100.");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        this.kmDriven = kmDriven;
    }

    public static void main(String[] args) {
        eRyder bike1 = new eRyder("EB001", 80, true, 120.5);
        bike1.printRideDetails(10);

        eRyder bike2 = new eRyder("EB002", 95, true, 88.2, "user_002", "12345678901");
        bike2.printRideDetails(15);
    }
}


