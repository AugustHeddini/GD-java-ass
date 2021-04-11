package instruments;

public class Guitar extends StrumInstrument {
    
    /**
     * Constructor for the Guitar class
     * @param manufacturer The manufacturer of the Instrument
     * @param nrStrings The number of strings of the StrumInstrument
     * @param stringSize The string size of the StrumInstrument
     */
    public Guitar(String manufacturer, int nrStrings, double stringSize) {
        super("Guitar", manufacturer, nrStrings, stringSize);
    }

    /**
     * Returns a String representation of the Guitar
     */
    public String toString() {
        return super.toString();
    }

}
