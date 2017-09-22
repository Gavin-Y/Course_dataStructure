package Dungeon.model;

/**
 * Created by yejiaquan on 2016/11/12.
 */
public class Midpoint {
    private int x;
    private int y;
    private Midpoint(){}
    public Midpoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
