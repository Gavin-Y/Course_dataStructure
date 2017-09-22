package HorseChess;

import util.SinglyList.SortedSinglyList;

/**
 * Created by yejiaquan on 2016/10/14.
 */
public class Horse extends Point{
    private SortedSinglyList<Point> go;
    public Horse(int x, int y, int state, SortedSinglyList<Point> go){
        super(x,y,state);
        this.go=go;
    }

    public void setNo(Point p){
        go.remove(p);
    }

    public Horse(Point p, SortedSinglyList<Point> go){
        this(p.getX(),p.getY(),p.getState(),go);
    }

    public SortedSinglyList<Point> getGo() {
        return go;
    }
}
