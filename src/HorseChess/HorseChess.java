package HorseChess;

import util.SinglyList.SortedSinglyList;
import util.Stack.LinkedStack;

/**
 * Created by yejiaquan on 2016/10/14.
 */
public class HorseChess {
    private LinkedStack<Horse>course;
    private Chessboard chessboard;
    private Horse horse;
    private boolean solution=true;

    public HorseChess(){
        this(5,5);
    }

    public HorseChess(int height, int width){
        this(height, width,1,1);
    }

    public HorseChess(int height, int width, int x, int y){
        chessboard=new Chessboard(height, width);
        horse =new Horse(x-1,y-1,1,go(x-1,y-1));
        chessboard.setChess(horse);
        course=new LinkedStack<Horse>();
        course.push(horse);
    }

    public void jump() {
        SortedSinglyList<Point> go = horse.getGo();
        if(!go.isEmpty()){
            Horse old= horse;
            horse = new Horse((Point) go.get(0),go((((Point) go.get(0)).getX()),((Point) go.get(0)).getY()));
            horse.setState(old.getState()+1);
            chessboard.setChess(horse);
            course.push(horse);
        }else{
            recall();
        }
    }

    private void recall(){
        chessboard.goBack(horse);
        course.pop();
        if (course.isEmpty()){
            solution=false;
            return;
        }
        horse =course.peek();
        if (!horse.getGo().isEmpty()) {
            horse.setNo((Point) horse.getGo().get(0));
        }else{
            recall();
        }
        jump();
    }

    private SortedSinglyList<Point> go(int x, int y){
        SortedSinglyList<Point> go=new SortedSinglyList<Point>();
        go.insert(chessboard.getPoint(x-2,y-1));
        go.insert(chessboard.getPoint(x+2,y-1));
        go.insert(chessboard.getPoint(x-2,y+1));
        go.insert(chessboard.getPoint(x+2,y+1));
        go.insert(chessboard.getPoint(x-1,y-2));
        go.insert(chessboard.getPoint(x+1,y-2));
        go.insert(chessboard.getPoint(x-1,y+2));
        go.insert(chessboard.getPoint(x+1,y+2));
        return go;
    }

    public boolean isOver(){
        return chessboard.isFull()||!solution;
    }

    public String toString(){
        return solution ? chessboard.toString():"无解";
    }
}