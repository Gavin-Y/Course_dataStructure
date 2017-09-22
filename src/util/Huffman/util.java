package util.Huffman;

import java.io.*;

/**
 * Created by yejiaquan on 2016/10/28.
 */
public class util {
    public static int[] getWeight(String text){
        int[]weights=new int[2];
        for (int i=0;i<text.length();i++){
            if (text.charAt(i)>weights.length-1){
                int[]tmp=new int[text.charAt(i)+1];
                System.arraycopy(weights,0,tmp,0,weights.length);
                weights=tmp;
            }
            weights[text.charAt(i)]++;
        }
        return weights;
    }
    public static void writeString(String str,String file){
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        String str="";
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                if (((char) tempchar) != '\r') {
                    str+=(char) tempchar;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
//        try {
//            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
//            char[] tempchars = new char[30];
//            int charread = 0;
//            reader = new InputStreamReader(new FileInputStream(fileName));
//            while ((charread = reader.read(tempchars)) != -1) {
//                if ((charread == tempchars.length)
//                        && (tempchars[tempchars.length - 1] != '\r')) {
//                    System.out.print(tempchars);
//                } else {
//                    for (int i = 0; i < charread; i++) {
//                        if (tempchars[i] == '\r') {
//                            continue;
//                        } else {
//                            System.out.print(tempchars[i]);
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
    }
    public static void writeObject(Object o,String file){
        FileOutputStream out;
        ObjectOutputStream objectOut = null;
        try {
            out = new FileOutputStream(file);
            objectOut = new ObjectOutputStream(out);
            objectOut.writeObject(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object readObject(String file){
        FileInputStream in;
        ObjectInputStream objectIn;
        Object o=null;
        try {
            in = new FileInputStream(file);
            objectIn = new ObjectInputStream(in);
            o = objectIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
