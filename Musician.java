import instruments.*;

public class Musician {

    private String name;
    private Instrument instrument;

    /**
     * Constructor for the Musician class
     * @param name The name of the Musician
     * @param instrument The Instrument the Musician plays
     */
    public Musician(String name, Instrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    /**
     * Getter for the name of the Musician
     * @return The Musician's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the Musician's Instrument
     * @return The Musician's Instrument
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Getter for the type of Instrument the Musician plays
     * @return The type of the Musician's Instrument
     */
    public String getInstrumentType() {
        return instrument.getType();
    }

    /**
     * Returns the String representation of a Musician and their instrument
     */
    public String toString() {
        return name + ", on the " + instrument;
    }
}