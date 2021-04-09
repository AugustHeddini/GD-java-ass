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
     * Returns the string represenation of the band (band name).
     */
    public String toString() {
        return name;
    }

    /**
     * Adds a member to the band member list
     * @param mem The Musician to be added
     */
    public void addMember(Musician mem) {
        members.add(mem);
    }

    /**
     * Get the member list
     * @return A copy of the member list
     */
    public ArrayList<Musician> getMembers() {
        return new ArrayList<Musician>(members);
    }

    /**
     * Removes a Musician from the band member list at the specified index.
     * @param memberIndex The index of the Musician to be removed from the member array
     * @return True if the index was successfully removed, false otherwise
     */
    public boolean removeMember(int memberIndex) {
        try {
            members.remove(memberIndex);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}