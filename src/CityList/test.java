package CityList;

/**
 * Created by yejiaquan on 2016/10/26.
 */
public class test {
    public static void main(String[] args) {
        CityList cityList=new CityList();
        cityList.insert("b",1,1);
        cityList.insert("a",2,2);
        cityList.insert("d",1,2);
        cityList.insert("c",2,1);
        System.out.println(cityList.toString());

        System.out.println(cityList.remove("a").toString());
        System.out.println(cityList.toString());
        cityList.set("d",new city("hhh",8,8));
        System.out.println(cityList.toString());
        System.out.println(cityList.search("c"));
        System.out.println(cityList.search("d"));
        city[]cities=cityList.extent(1,1,1);
        for (int i=0;i<cities.length;i++){
            if (cities[i]!=null)
                System.out.println(cities[i].toString());
        }
    }
}