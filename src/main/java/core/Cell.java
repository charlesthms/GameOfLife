package core;

public class Cell {

    private int x, y;
    private boolean state;

    public Cell(int x, int y, boolean state){
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isState() {
        return state;
    }
}
