package instruments;

public class Drums extends Instrument {

    private boolean hasHiHat;

    /**
     * Constructor for the Drums class
     * @param manufacturer The manufacturer of the Instrument
     * @param hasHiHat Whether or not the Drums have a hi-hat
     */
    public Drums(String manufacturer, boolean hasHiHat) {
        super("Drums", manufacturer);
        this.hasHiHat = hasHiHat;
    }
    
    /**
     * Returns a String representation of the Drums
     */
    public String toString() {
        return super.toString() + " with specifications:\n\t" + (hasHiHat ? "Has a Hi-hat" : "Without Hi-hat");
    }

}
