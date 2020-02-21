package ru.itmo.sync;

public class BankThread extends Thread {
    private Bank bank;
    private int transaction;
    private long sleep;

    public BankThread(Bank bank, int transaction, long sleep) {
        this.bank = bank;
        this.transaction = transaction;
        this.sleep = sleep;
    }

    @Override
    public void run() {
        bank.calc(transaction, sleep);
    }
}
