package com.company;

import java.util.concurrent.atomic.AtomicLong;

public class BeautifulWord {

    static String[] list;
    static int number;
    static AtomicLong counter = new AtomicLong(0);

    public BeautifulWord(String[] list) {

        this.list = list;
    }

    //      проверяем является ли строка палиндромом (счетчик внутри)
    public void palindromeCheck(int number) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() == number) {
                String reverse = new StringBuffer(list[i]).reverse().toString();
                if (list[i].equals(reverse)) {
                    counter.getAndIncrement();
//                    System.out.println(list[i] + " is palindrome");
                }
            }
        }
    }

    //    проверяем состоит ли строка только из одной буквы (счетчик внутри)
    public void oneLetterCheck(int number) {
        int numberOfLetters = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() == number) {
                for (int j = 0; j < list[i].length() - 1; j++) {
                    if (list[i].charAt(j) == list[i].charAt(j + 1)) {
                        numberOfLetters++;
                    } else {
                        numberOfLetters = 0;
                    }
                }
                if (numberOfLetters >= list[i].length() - 1) {
                    counter.getAndDecrement();
//                    System.out.println(list[i] + " simple word");
                }
            }
        }
    }

    //    проверяем идут ли буквы в строке по алфавиту (счетчик внутри)
    public void orderCheck(int number) {
        int numOfLetters = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() == number) {
                for (int j = 0; j < list[i].length() - 1; j++) {
                    if (list[i].charAt(j) <= list[i].charAt(j + 1)) {
                        numOfLetters++;
                    } else {
                        numOfLetters = 0;
                    }
                }
                if (numOfLetters >= list[i].length() - 1) {
                    counter.getAndIncrement();
//                    System.out.println(list[i] + " in order");
                }
            }
        }
    }

    public long getCurrent() {
        return counter.get();
    }
}
