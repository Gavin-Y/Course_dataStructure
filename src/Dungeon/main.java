package Dungeon;

import Dungeon.model.Game;

/**
 * Created by yejiaquan on 2016/11/9.
 */
public class main {

    public static void main(String[] args) {
        Game game=new Game();
        System.out.println(game.getRooms().toString());
        int num=0;
        for (int i = 0; i < game.getRooms().size(); i++) {
            if(game.getRooms().get(i).isMainRoom()) {
                System.out.println("主房间：" + game.getRooms().get(i).toString());
                num++;
            }
        }
        System.out.println("主房间数"+num);
    }
}
