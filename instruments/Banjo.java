package instruments;

public class Banjo extends StrumInstrument {

    /**
     * Constructor for the Banjo class
     * @param manufacturer The manufacturer of the Instrument
     * @param nrStrings The number of strings of the StrumInstrument
     * @param stringSize The string size of the StrumInstrument
     */
    public Banjo(String manufacturer, int nrStrings, double stringSize) {
        super("Banjo", manufacturer, nrStrings, stringSize);
    }

    /**
     * Returns a String representation of the Banjo
     */
    public String toString() {
        return super.toString();
    } 
}
