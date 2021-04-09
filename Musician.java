

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
     * Returns the string representation of a Musician and their instrument
     */
    public String toString() {
        return name + ", on the " + instrument;
    }

}