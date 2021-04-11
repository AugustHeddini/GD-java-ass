package instruments;

public class Synthesizer extends KeyInstrument {

    private boolean hasLED;

    /**
     * Constructor for the Synthesizer class
     * @param manufacturer The manufacturer of the Instrument
     * @param nrKeys The number of keys of the KeyInstrument
     * @param hasLED Whether or not the Synthesizer has LEDs
     */
    public Synthesizer(String manufacturer, int nrKeys, boolean hasLED) {
        super("Synthesizer", manufacturer, nrKeys);
        this.hasLED = hasLED;
    }
    
    /**
     * Returns a String representation of the Synthesizer
     */
    public String toString() {
        return super.toString() + "\n\t" + (hasLED ? "Has LEDs" : "Without LEDs");
    }
}
