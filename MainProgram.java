import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainProgram {
    public static void main(String[] args) {
        // Input the number of devices to create (1 to 20)
        int numDevices = getUserInput();
        if (numDevices < 1 || numDevices > 20) {
            System.out.println("Invalid input. Please enter a number between 1 and 20.");
            return;
        }

        // Create random instances of derived classes
        List<Device> devices = generateRandomDevices(numDevices);

        // Calculate and display information
        calculateAndDisplayInfo(devices);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of devices (1 to 20): ");
        int numDevices = scanner.nextInt();
        scanner.close(); // Don't forget to close the scanner
        return numDevices;
    }

    private static List<Device> generateRandomDevices(int numDevices) {
        List<Device> devices = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numDevices; i++) {
            // Generate random attributes for the derived classes
            String type = getRandomDeviceType();
            double price = random.nextDouble() * 1000;  // Adjust as needed
            double weight = random.nextDouble() * 1000; // Adjust as needed

            if (type.equals("Smartphone")) {
                double screenSize = random.nextDouble() * 6.0;  // Adjust as needed
                int cameraResolution = random.nextInt(20) + 5; // Adjust as needed
                devices.add(new Smartphone(type, price, weight, screenSize, cameraResolution));
            }
            // Similar code for "Laptop" and "Tablet" classes
        }

        return devices;
    }

    private static String getRandomDeviceType() {
        String[] deviceTypes = {"Smartphone", "Laptop", "Tablet"};
        Random random = new Random();
        int randomIndex = random.nextInt(deviceTypes.length);
        return deviceTypes[randomIndex];
    }

    private static void calculateAndDisplayInfo(List<Device> devices) {
        // Calculate and display the required information
        HashSet<String> distinctTypes = new HashSet<>();
        double totalPrice = 0.0;
        double totalWeight = 0.0;

        for (Device device : devices) {
            distinctTypes.add(device.getType());
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types created: " + distinctTypes.size());
        System.out.println("Total price of all devices: $" + totalPrice);
        System.out.println("Total weight of all devices: " + totalWeight + " grams");
    }
}

