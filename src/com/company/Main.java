package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String[] nameList = Generator.nameMaker("abc", 3);

        Counter.count(nameList);

//        for (int j = 0; j < nameList.length; j++)
//        System.out.println(nameList[j]);

    }
}
