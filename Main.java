import instruments.*;

public class Main {

    public static void main(String[] args) {
        Venue venue = new Venue();
        init(venue);
        venue.manage();
    }

    /**
     * Initialize the described scenario
     * @param venue The Venue which is initialized
     */
    public static void init(Venue venue) {
        // Add first band and musicians
        Band b = new Band("Spoke 'n hub");
        b.addMember(new Musician("Liza Baar", new Guitar("Bender", 5, 0.4)));
        b.addMember(new Musician("Null Beat", new Piano("McFaren", 51, true)));
        b.addMember(new Musician("Void", new Synthesizer("Lorg", 47, true)));

        venue.addBand(b);

        // Add second band and musicians
        b = new Band("Berats");
        b.addMember(new Musician("Stringsteen", new Banjo("Gibson", 4, 8)));
        b.addMember(new Musician("Xindea", new Drums("Toyota", true)));
        b.addMember(new Musician("Captor", new Synthesizer("Suzuki", 72, false)));

        venue.addBand(b);

        // Add musicians without bands
        venue.addFreeMusician(new Musician("Slam Itur", new Guitar("TweEntiOan", 5, 0.2)));
    }
}