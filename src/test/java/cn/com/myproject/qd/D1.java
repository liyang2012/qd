package cn.com.myproject.qd;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class D1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Integer> list = new ArrayList<>(64);
        list.add(3);
        list.add(13);
        list.add(33);
        list.add(31);
        list.add(32);
        list.add(22);
        list.add(55);
        list.add(55);
        list.add(35);
        list.add(5);
        list.add(3);
        list.add(13);
        list.add(33);
        list.add(31);
        list.add(32);
        list.add(22);
        list.add(55);
        list.add(55);
        list.add(35);
        list.add(5);
        list.add(3);
        list.add(13);
        list.add(33);
        list.add(31);
        list.add(32);
        list.add(22);
        list.add(55);
        list.add(55);
        list.add(35);
        list.add(5);
        list.add(3);
        list.add(13);
        list.add(33);
        list.add(31);
        list.add(32);
        list.add(22);
        list.add(55);
        list.add(55);
        list.add(35);
        list.add(5);
        System.out.println(list.toString());
        //序列化对象到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/liyang-macbook/Downloads/template1"));
        oos.writeObject(list);
        oos.close();
        //反序列化
        File file = new File("/Users/liyang-macbook/Downloads/template1");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Integer> newList = (List<Integer>) ois.readObject();
        System.out.println(newList.toString());

    }
}
