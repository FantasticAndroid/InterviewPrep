package com.offline.first.threads;

public class MultiThreadingWithJoin {

    class JoinThread extends Thread {
        String threadName;
        JoinThread(String threadName) {
            this.threadName = threadName;
        }
        public void run() {
            for(int i=1; i<=3; i++) {
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {
                    System.out.println(e);
                }
                System.out.println("JoinThread threadName: "+threadName+", i: "+i);
            }
        }
    }

    public class MainClass {
        public void main() {
            // creating three threads
            JoinThread t1 = new JoinThread("T1");
            JoinThread t2 = new JoinThread("T2");
            JoinThread t3 = new JoinThread("T3");
            // thread t1 starts
            t1.start();
            // starts second thread when first thread t1 is died.
	        try {
	            t1.join();
	        } catch(Exception e) {
	            System.out.println(e);
	        }
            // start t2 and t3 thread
            t2.start();
            t3.start();
        }
    }
}
