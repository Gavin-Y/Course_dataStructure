package Dungeon.model;

import util.Math.NormalDbt.NormalDbt;
import util.SeqList.SeqList;

/**
 * Created by yejiaquan on 2016/11/9.
 */
public class Game {
    public static final int ROOM_NUM = 60;
    public static final int RADIUS = 100;
    public static final int HEIGHT = 24;
    public static final int WIDTH = 24;
    public static final int TILE = 4;

    private SeqList<Room>rooms;

    public Game(){
        rooms=new SeqList<Room>(ROOM_NUM);
        NormalDbt height=new NormalDbt(24,24);
        NormalDbt width=new NormalDbt(24,24);
        for (int i = 0; i < ROOM_NUM; i++) {
            rooms.insert(new Room(i,height.Next(),width.Next()));
            randomPointInCircle(i);
        }
    }

    private double roundm(double n){
        return Math.floor(((n + TILE - 1)/TILE))*TILE;
    }

    private void randomPointInCircle(int i){
        double t=2*Math.PI*Math.random();
        double u=Math.random()+Math.random();
        double r;
        if (u>1) r=2-u;
        else r=u;
        rooms.get(i).setX((int)(roundm(RADIUS*r*Math.cos(t))));
        rooms.get(i).setY((int)(roundm(RADIUS*r*Math.sin(t))));
    }

    public void randomSize(int i){

    }

    public void start(){

    }

    public void end(){

    }

    public SeqList<Room> getRooms() {
        return rooms;
    }
}
