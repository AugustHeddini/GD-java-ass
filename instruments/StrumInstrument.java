package instruments;

public abstract class StrumInstrument extends Instrument {

    protected int nrStrings;
    protected double stringSize;

    /**
     * Constructor for the StrumInstrument abstract class
     * @param type The type of the Instrument
     * @param manufacturer The manufacturer of the Instrument
     * @param nrStrings The number of strings of the StrumInstrument
     * @param stringSize The string size of the StrumInstrument
     */
    public StrumInstrument(String type, String manufacturer, int nrStrings, double stringSize) {
        super(type, manufacturer);
        this.nrStrings = nrStrings;
        this.stringSize = stringSize;
    }

    /**
     * Returns a String representation of the StrumInstrument
     */
    public String toString() {
        return super.toString() + " with specifications:\n\tNumber of strings: " + nrStrings 
                + "\n\tString size: " + stringSize + "mm";
    }
}
