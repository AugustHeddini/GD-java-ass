package instruments;

public abstract class Instrument {
    
    protected String type;
    protected String manufacturer;

    /**
     * Constructor for the Instrument abstract class
     * @param type The type of the Instrument
     * @param manufacturer The manufacturer of the Instrument
     */
    public Instrument(String type, String manufacturer) {
        this.type = type;
        this.manufacturer = manufacturer;
    }

    /**
     * Getter for the manufacturer of the Instrument
     * @return The manufacturer of the Instrument
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Getter for the type of the Instrument
     * @return The type of the Instrument
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a String representation of the Instrument
     */
    public String toString() {
        return manufacturer + " " + type;
    }

}