package instruments;

public class Piano extends KeyInstrument {

    private boolean isAcoustic;

    /**
     * Constructor for the Piano class
     * @param manufacturer The manufacturer of the Instrument
     * @param nrKeys The number of keys of the KeyInstrument
     * @param isAcoustic Whether or not the Piano is acoustic
     */
    public Piano(String manufacturer, int nrKeys, boolean isAcoustic) {
        super("Piano", manufacturer, nrKeys);
        this.isAcoustic = isAcoustic;
    }

    /**
     * Returns a String representation of the Piano
     */
    public String toString() {
        return super.toString() + "\n\t" + (isAcoustic ? "Acoustic" : "Electronic");
    }
    
}
