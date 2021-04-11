package instruments;

public abstract class KeyInstrument extends Instrument {

    protected int nrKeys;

    /**
     * Constructor for the KeyInstrument abstract class
     * @param type The type of the Instrument
     * @param manufacturer The manufacturer of the Instrument
     * @param nrKeys The number of keys of the KeyInstrument
     */
    public KeyInstrument(String type, String manufacturer, int nrKeys) {
        super(type, manufacturer);
        this.nrKeys = nrKeys;
    }

    /**
     * Returns a String representation of the KeyInstrument
     */
    public String toString() {
        return super.toString() + " with specifications:\n\tNumber of keys: " + nrKeys;
    }
}
