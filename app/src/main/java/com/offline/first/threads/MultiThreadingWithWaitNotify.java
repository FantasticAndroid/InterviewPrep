package com.offline.first.threads;

public class MultiThreadingWithWaitNotify {

    static class Customer {
        int balance = 10000;

        synchronized void withdraw(int amount) throws InterruptedException {
            System.out.println("withdraw-> Going to withdraw...");

            if (this.balance < amount) {
                System.out.println("withdraw-> Less balance; waiting for deposit...");
                try {
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("withdraw started...");
            Thread.sleep(2000);
            this.balance -= amount;
            System.out.println("withdraw completed for amount: " + amount + " , Balance : " + this.balance);
        }

        synchronized void deposit(int amount) throws InterruptedException {
            System.out.println("Deposit: Balance Amount: " + this.balance);
            System.out.println("Deposit: Going to deposit Amount: " + amount);
            Thread.sleep(2000);
            this.balance += amount;
            System.out.println("Deposit: Deposit completed. Amount: " + this.balance);
            notify();
        }
    }

    class Test {
        public void main() {
            final Customer c = new Customer();
            new Thread() {
                public void run() {
                    try {
                        c.withdraw(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(5000);
                        c.deposit(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();

        }
    }
}
