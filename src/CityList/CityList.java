package CityList;

import util.SinglyList.*;

/**
 * Created by yejiaquan on 2016/10/26.
 */
public class CityList {
    private SinglyList<city> list;
    public CityList(){
        list=new SinglyList<city>();
    }
    public String search(String key){
        Node<city> p=list.head.next;
        while(p!=null){
            if(p.data.name.equals(key))
                return "x="+p.data.x+",y="+p.data.y;
            p=p.next;
        }
        return null;
    }
    public Node<city> find(String name){
        Node<city> p=list.head.next;
        while(p!=null){
            if(p.data.name.equals(name))
                return p;
            p=p.next;
        }
        return null;
    }
    public void insert(String name,int x,int y){
        insert(new city(name,x,y));
    }
    public void insert(city c){
        list.insert(c);
    }
    public city remove(String name){
        return list.remove(find(name).data);
    }
    public city set(String name,city c){
        city old=find(name).data;
        find(name).data=c;
        return old;
    }
    public city[] extent(int x,int y,double len){
        city[] cities=new city[list.size()];
        int i=0;
        Node<city> p=list.head.next;
        while(p!=null){
            if(Math.sqrt(Math.pow(p.data.x-x,2)+Math.pow(p.data.y-y,2))<=len) {
                cities[i]=p.data;
                i++;
            }
            p=p.next;
        }
        return cities;
    }
    public String toString() {
        return list.toString();
    }
}
