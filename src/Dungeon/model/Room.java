package Dungeon.model;

/**
 * Created by yejiaquan on 2016/11/9.
 */
public class Room {
    private int id;
    private int x;
    private int y;
    private int height;
    private int width;
    private Midpoint midp;

    public Room(int id,double height,double width){
        this(id,0,0,height,width);
    }

    public Room(int id, double x, double y, double height, double width) {
        this.id = id;
        this.x = (int)x;
        this.y = (int)y;
        this.height = (int)height;
        this.width = (int)width;
    }

    public Room(double x,double y){
        this(0,x,y,0,0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String toString(){
        return "id="+id+",x="+x+",y="+y+",height="+height+",width="+width;
    }

    public boolean isMainRoom(){
        return (height>= Game.HEIGHT*1.25)||(width>=Game.WIDTH*1.25);
    }
}
