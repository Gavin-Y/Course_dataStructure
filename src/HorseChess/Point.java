package HorseChess;

/**
 * Created by yejiaquan on 2016/10/14.
 */
public class Point implements Comparable<Point>{
    private int x;
    private int y;

    public int getFirst() {
        return first;
    }

    private int first;
    private int state;

    public Point(int x,int y,int first,int state){
        this.x=x;
        this.y=y;
        this.first=first;
        this.state=state;
    }

    public Point(int x,int y,int state){
        this.x=x;
        this.y=y;
        this.state=state;
    }

    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    public Point(Point p){
        this(p.getX(),p.getY(),p.getFirst(),p.getState());
    }

    public int compareTo(Point p) {
        if(this.first==p.first) {
            return 0;
        }else if (this.first<p.first) {
            return 1;
        }else {
            return -1;
        }
    }

    public void setState(int state){
        this.state=state;
    }

    public int getState(){
        return this.state;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public String toString (){
        return this.state+"";
    }
}
