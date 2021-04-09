import java.util.ArrayList;

public class Band {

    public String name;
    public ArrayList<Musician> members;

    public Band(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}