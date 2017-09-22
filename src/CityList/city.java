package CityList;

/**
 * Created by yejiaquan on 2016/10/26.
 */
public class city {
    String name;
    int x,y;
    public city(String name,int x,int y){
        this.name=name;
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return "城市名："+name+"坐标："+x+","+y;
    }
}
