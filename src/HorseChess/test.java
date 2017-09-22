package HorseChess;

/**
 * Created by yejiaquan on 2016/10/15.
 */
public class test {
    public static void main(String[] args) {
        HorseChess chess = new HorseChess(8, 8,1,1);
        int i=2;
        while (!chess.isOver()) {
            System.out.println(i++);
            chess.jump();
        }
        System.out.print(chess.toString());
    }
}