package com.company.mystring;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
    /*    MyString a = new MyString(" Hello ");
        System.out.println(" Объект 1 класса MyString :" + a);
        MyString b = new MyString(" world ");
        System.out.println(" Объект 2 класса MyString :" + b);
        MyString c = a.concat(b);
        System.out.println(" Метод concat : " + c);
        MyString d = c.substring(1, 5);
        System.out.println(" Метод substring : " + d);
        MyString e = d.replace('l', 'k');
        System.out.println(" Метод replace : " + e);*/
        MyString f = new MyString("огонь, я иду гулять и иду один");
   /*     MyString j = new MyString("иду");
        MyString q = new MyString("ползу");
        System.out.println("|---------------------------------------------------|");
        MyString h = f.replace(j, q);
        System.out.println(" Строка после замены последовательности : | " + h);*/
        System.out.println(" Изначальная строка : | " + f);
        System.out.println(" Длина изначальной строки : "+f.length());
        System.out.println("|---------------------------------------------------|");
        System.out.println("|------------------MyString[] split(char s)---------------------|");
        MyString[] y = f.split('я');
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
        }
        System.out.println("|-----------------MyString[] split(MyString s)--------------------------|");
        MyString[] z = f.split(new MyString("иду"));
        for (int i = 0; i < z.length; i++) {
            System.out.println(z[i]);
        }



    }
}
