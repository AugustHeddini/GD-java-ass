import java.util.ArrayList;

public class Band {

    private String name;
    private ArrayList<Musician> members;

    /**
     * Constructor for the Band class
     * @param name The name of the Band
     */
    public Band(String name) {
        members = new ArrayList<Musician>();
        this.name = name;
    }

    /**
     * Attempts to add a member to the band.
     * If a Musician playing the same type of Instrument is already
     * in the band, the applicant is rejected.
     * @param mem The applying Musician
     * @return Boolean representing whether or not the Musician was allowed to join
     */
    public boolean addMember(Musician mem) {
        for (Musician m : members) {
            if (m.getInstrumentType().equals(mem.getInstrumentType())) {    // If a Musician playing the same instrument already exists, reject the applicant
                return false;
            }
        }
        members.add(mem);
        return true;
    }

    /**
     * Get the member list
     * @return A copy of the member list
     */
    public ArrayList<Musician> getMembers() {
        return new ArrayList<Musician>(members);
    }

    /**
     * Removes a musician from the band.
     * @param memberIndex The index of the musician to be removed
     * @return The Musician which was removed
     */
    public Musician removeMember(int memberIndex) {
        return members.remove(memberIndex);
    }
    
     /**
     * Returns a String represenation of the band (band name).
     */
    public String toString() {
        return name;
    }

}