package HorseChess;

/**
 * Created by yejiaquan on 2016/10/14.
 */
public class Chessboard {
    private Point [][]chessboard;

    public Chessboard(int height,int width){
        chessboard=new Point[height][width];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                int first=0;
                if (i<=1||i>=chessboard.length-2){
                    first+=1;
                }
                if(j<=1||j>=chessboard[i].length-2){
                    first+=1;
                }
                if(i==0||i==chessboard.length-1){
                    first+=1;
                }

                if(j==0||j==chessboard[i].length-1){
                    first+=1;
                }
                chessboard[i][j]=new Point(i,j,first,0);
            }
        }
    }

    public void setChess(int x,int y,int state){
        if (canPlace(x,y)){
            chessboard[x][y].setState(state);
        }
    }

    public void setChess(Point p){
//        if (canPlace(p.getX(),p.getY())){
            chessboard[p.getX()][p.getY()].setState(p.getState());
//        }
    }

    public Point getPoint(int x,int y){
        if (canPlace(x,y)) {
            return chessboard[x][y];
        }
        return null;
    }

    public void goBack(Point p){
        chessboard[p.getX()][p.getY()].setState(0);
    }

    public boolean canPlace(int x,int y){
        return (x >= 0 && x < chessboard.length && y >= 0 && y < chessboard[0].length && chessboard[x][y].getState() == 0);
    }

    public String toString (){
        String str="|";
        for (Point[] aChessboard : chessboard) {
            for (Point anAChessboard : aChessboard) {
                if(anAChessboard.toString().length()<2)
                    str += " "+anAChessboard.toString()+"|";
                else
                    str += anAChessboard.toString()+"|";
            }
            str += "\n|";
        }
        str=str.substring(0,str.length()-2);
        return str;
    }

    public boolean isFull(){
        for (Point[] aChessboard : chessboard) {
            for (Point anAChessboard : aChessboard) {
                if (anAChessboard.getState()==0)
                    return false;
            }
        }
        return true;
    }
}