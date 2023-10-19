public class Smartphone extends Device {
    private double screenSize;
    private int cameraResolution;

    public Smartphone(String type, double price, double weight, double screenSize, int cameraResolution) {
        super(type, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

    // Additional methods or getters specific to Smartphone
}

