package com.company.mystring;


/*
Строка - ни что иное как массив символов
Задача
Реализовать класс MyString, который позволяет удобно работать с этим массивом
Необходимо реализовать в этом классе следующие методы:
String toString() - будет возвращать классическую java-строку на основе внутрененнего массива, нужен для вывода
int length() - получить кол-во символов в строке
MyString concat(MyString another) - возвращает результат приклеивания строки another к текущей строке
MyString substring(int offset, int count) - возвращает новую строку, состоящую из части исходной (подстрока) длиной count символов, начиная с символа offset - пропустить офсет
MyString replace(char old, char new) - возвращает новую строку, полученную из исходной путем замены всех символов old на символы new
MyString replace(MyString old, MyString ne) - возвращает новую строку, полученную из исходной путем замены всех
 последовательностей символов old на последовательности ne
MyString[] split(char s) - возвращает массив строк, полученный путем разбиения исходной строки по указанному символу
MyString[] split(MyString s) - возвращает массив строк, полученный путем разбиения исходной строки по указанной последовательности символов
конструкторы:
MyString() - создает пустую строку
MyString(char[] symbols) - создает строку с указанным внутренним массивом
MyString(String s) - создает строку на снове классической java-строки
*/

import java.util.Arrays;

public class MyString {


    private final char[] newString;
    private int size = 0;
    private int standard = 50;


    public MyString() {
        newString = new char[0];
    }

    public MyString(char[] symbols) {
        this.newString = symbols;
    }

    public MyString(String s) {
        newString = s.toCharArray();
    }

    public int length() {
        return this.newString.length;
    }

    public String toString() {
        return new String(this.newString);
    }

    public int size() {
        return this.size;
    }


    /**
     * MyString concat(MyString another) - возвращает результат приклеивания строки another к текущей строке
     *
     * @param another
     * @return
     */
    public MyString concat(MyString another) {
        char[] con = new char[newString.length + another.newString.length];
        for (int i = 0; i < newString.length; i++) {
            con[i] = newString[i];
        }
        for (int i = newString.length, j = 0; i < con.length; j++, i++) {
            con[i] = another.newString[j];
        }
        return new MyString(con);
    }

    /**
     * возвращает новую строку, состоящую из части исходной (подстрока) длиной count символов,
     * начиная с символа offset - пропустить офсет
     *
     * @param offset
     * @param count
     * @return
     */
    public MyString substring(int offset, int count) {
        char[] sub = new char[count];

        for (int i = offset, j = 0; i < newString.length && j < count; j++, i++) {
            sub[j] = newString[i];

        }
        return new MyString(sub);
    }


    /**
     * MyString replace(char old, char new) - возвращает новую строку, полученную из исходной путем замены всех символов old на символы new
     *
     * @param oldsymbol
     * @param newsymbol
     * @return
     */
    public MyString replace(char oldsymbol, char newsymbol) {
        char[] buf = new char[newString.length];
        System.out.println(" Длина массива : " + newString.length);
        for (int i = 0; i < newString.length; i++) {
            buf[i] = newString[i];
            if (newString[i] == oldsymbol) {
                buf[i] = newsymbol;
            }
        }
        return new MyString(buf);
    }

    /**
     * возвращает индекс первого эелемента последовательности символов при первом вхождении
     *
     * @param
     * @return
     */
    public int indexOf(MyString needle, int offset) {
        char marker = needle.newString[0];

        MyString examine = null;
        for (int i = offset; i < newString.length; i++) {
            if (newString[i] == marker) {
                examine = substring(i, needle.length());
                if (examine.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * MyString replace(MyString old, MyString ne) - возвращает новую строку, полученную из исходной путем замены всех
     * последовательностей символов old на последовательности ne
     *
     * @param b
     * @return
     */
    public boolean equals(MyString b) {
        if (this.length() != b.length()) return false;
        for (int i = 0; i < b.newString.length; i++) {
            if (this.newString[i] != b.newString[i]) {
                return false;
            }
        }
        return true;
    }

    public MyString replace(MyString old, MyString ne) {

        char targetElem = old.newString[0];
        MyString work = new MyString();
        MyString workString;
        int index = 0;
        for (int i = 0; i < newString.length; i++) {
            if (newString[i] == targetElem) {
                workString = this.substring(i, old.length());
                if (workString.equals(old)) {
                    work = work.concat(substring(index, i - index));
                    work = work.concat(ne);
                    index = i + old.length();
                    i += old.length() - 1;
                }
            }
        }
        work = work.concat(substring(index, newString.length - index));
        return work;
    }


    /**
     * MyString[] split(char s) - возвращает массив строк, полученный путем разбиения исходной строки по указанному символу
     *
     * @param s
     * @return
     */
    public MyString[] split(char s) {
        int num = 0;
        int newlength = 0;
        MyString[] workString;
        for (int i = 0; i < newString.length; i++) {
            if (newString[i] == s) {
                newlength++;
            }
        }
        workString = new MyString[newlength + 1];
        int k = 0;
        for (int j = 0; j < newString.length && k < newlength; j++) {
            if (newString[j] == s) {
                workString[k] = substring(num, j - num);
                k++;
                num = j;
            }
            workString[newlength] = new MyString();
            workString[newlength] = substring(num, newString.length - num);
        }
        if (newlength == 0) {
            return new MyString[]{this};
        }
        return workString;
    }


    /**
     * MyString[] split(MyString s) - возвращает массив строк, полученный путем разбиения исходной строки по указанной последовательности символов
     *
     * @param s
     * @return
     */
    public MyString[] split(MyString s) {

        char marker = s.newString[0];
        int lengthS = s.length();
        int target = 0;
        MyString[] arrString;
        MyString checkedString;
        int numberRepetitions = 0;

        for (int i = 0; i < newString.length; i++) {
            if (newString[i] == marker) {
                checkedString = this.substring(i, lengthS);
                if (checkedString.equals(s)) {
                    i = i + lengthS;
                    numberRepetitions++;
                }
            }
        }
        arrString = new MyString[numberRepetitions + 1];

        for (int i = 0, j = 0; i < newString.length && j < arrString.length; i++) {
            if (newString[i] == marker) {
                checkedString = this.substring(i, lengthS);

                if (checkedString.equals(s)) {
                    arrString[j] = this.substring(target, i - target);
                    target = i + lengthS;
                    j++;
                }
                arrString[numberRepetitions] = this.substring(target, newString.length - target);
            }
            if (numberRepetitions == 0) {
                return new MyString[]{this};
            }
        }
        return arrString;
    }

}



