package com.company;

public class Counter {

// создаем отдельный класс счетчик, в котором запускаем все потоки и создаем 3 статических счетчика

    static long counterFor_3_letters;
    static long counterFor_4_letters;
    static long counterFor_5_letters;

    public static void message(int number, long counter) {
        System.out.println("There are beautiful words with a length " + number + " : " + counter + " pieces");
    }

    static void threadMaker(BeautifulWord text, int number) throws InterruptedException {
        Thread threadPal = new Thread(() -> text.palindromeCheck(number));
        Thread threadLetter = new Thread(() -> text.oneLetterCheck(number));
        Thread threadOrder = new Thread(() -> text.orderCheck(number));

        threadPal.start();
        threadLetter.start();
        threadOrder.start();

        threadPal.join();
        threadLetter.join();
        threadOrder.join();
    }

    static void count(String[] nameList) throws InterruptedException {
        BeautifulWord text = new BeautifulWord(nameList);
        threadMaker(text, 3);
        counterFor_3_letters = text.getCurrent();

        threadMaker(text, 4);
        counterFor_4_letters = text.getCurrent() - counterFor_3_letters;

        threadMaker(text, 5);

        counterFor_5_letters = text.getCurrent() - counterFor_3_letters - counterFor_4_letters;

        message(3, counterFor_3_letters);
        message(4, counterFor_4_letters);
        message(5, counterFor_5_letters);
    }
}
