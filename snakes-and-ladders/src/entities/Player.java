package entities;

public class Player {

    private static int counter = 0;
    private int id;
    private String name;
    private int currPosition;

    public Player(String name) {
        this.name = name;
        this.id = counter++;
        this.currPosition = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(int currPosition) {
        this.currPosition = currPosition;
    }
}
