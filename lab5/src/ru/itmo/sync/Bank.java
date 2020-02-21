package ru.itmo.sync;

public class Bank {
    private int to;
    private int from = 220;

    public synchronized void calc(int transaction, long timeout) {
        System.out.println(
                String.format("Begin transaction: to: %d, from: %d, thread: %s",
                        to, from, Thread.currentThread().getName())
        );

        from -= transaction;

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        to += transaction;

        System.out.println(
                String.format("End transaction: to: %d, from: %d, thread: %s",
                        to, from, Thread.currentThread().getName())
        );
    }

    public int getTo() {
        return to;
    }

    public int getFrom() {
        return from;
    }
}
